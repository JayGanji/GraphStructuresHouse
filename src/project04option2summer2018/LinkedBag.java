package project04option2summer2018;

/**
 *This is a class to create a bag type of collection, which uses a singly linked
 * list fashion to contain generic <E> types of elements. The bag will also keep
 * track of how many elements are currently in it.
 * 
 * @author Jay Ganji, iterator() method provided by Linda Yang.
 * @param <E>
 */
public class LinkedBag<E extends Comparable<E>> {
    
    private Node<E> head;
    private Node<E> tail;
    private int numElements;
    
    /**
     * Constructor
     * No arguments, sets the head and tail pointers to null, signifying an
     *     empty linked list to start out with, and appropriately set the number
     *     of elements in the bag to 0.
     */
    public LinkedBag(){
        
        head = null;
        tail = null;
        numElements = 0;
    }
    
    /**
     * Retrieve the number of elements in the bag
     * @return The number of elemetns in the bag, as an int
     */
    public int getSize(){
        
        return numElements;
    }
    
    /**
     * Add an <E> element to the bag, link it to the linked list within at the 
     *     tail end of the linked list
     * @param newElement The <E> element to be added
     */
    public void appendList(E newElement){
        
        if (numElements == 0){
            tail = new Node<>(newElement, null);
            head = tail;
        }
        else{
            tail.setNext(new Node<>(newElement, null));
            tail = tail.getLink();
        }
        numElements++;
    }
    
    /**
     * Add an <E> element to the bag, link it to the linked list within at the 
     *     head end of the linked list
     * @param newElement The <E> element to be added
     */
    public void prependList(E newElement){
        
        head = new Node<>(newElement, head);
        if (numElements==0)
            tail = head;
        numElements++;
    }
    
    /**
     * Check whether a target <E> element exists within the bag
     * @param target The target <E> element to be checked for
     * @return a boolean value. Method returns true if the target exists,
     *     otherwise returns false 
     */
    public boolean exists(E target){
        
        boolean found = false;
        Node<E> cursor = head;
        
        while (cursor != null && !found){
            if (cursor.getData().equals(target))
                found = true;
            else
                cursor = cursor.getLink();
        }
        return found;
    }
    
    /**
     * Count the number of occurrences a target <E> element appears in the
     *     linked list within the bag
     * @param target The target <E> element to count the occurrences of
     * @return The number of occurrences the target element had, as an int
     */
    public int countOccurences(E target){
        
        int numOccur = 0;
        Node<E> cursor = head;
        
        while (cursor != null){
            if (cursor.getData().equals(target))
                numOccur++;
            cursor = cursor.getLink();
        }
        return numOccur;
    }
    
    /**
     * Remove a target <E> element if it is part of the linked list within the 
     *     bag
     * @param target The target <E> element desired to be removed
     * @return a boolean value. Method returns true if the target element was 
     *     successfully removed, otherwise returns false
     */
    public boolean remove(E target){
        
        boolean found = false;
        Node<E> cursor = head, previous = null;
        
        while(cursor != null && !found){
            if (cursor.getData().equals(target))
                found = true;
            else{
                previous = cursor;
                cursor = cursor.getLink();
            }
        }
        
        if (found && cursor != null){
            if (previous == null)
                head = head.getLink();
            else
                previous.setNext(cursor.getLink());
            
            if (tail == cursor)
                tail = previous;
            numElements--;
        }
        return found;
    }
    
    /**
     * the iteratorPrototype method "copies" the linked list and passes the
     * copied linked list to a new Lister<E>
     *
     * @return a Lister<E> using a copy of the linked list
     */
    public Lister<E> iterator() {
        // declare variables
        Node headOfListToReturn; // beginning of new "copied" list
        Node cursorOfListToCopy; // active node of list to copy
        Node lastNodeOfListToReturn; // end of new "copied" list

        // establish the copied list
        headOfListToReturn = null;

        if (head != null) {
            // create the head of the new list
            headOfListToReturn = new Node(head.getData(), null);
            // use lastNodeOfListToReturn as a pointer to the last node in the 
            //copied list
            lastNodeOfListToReturn = headOfListToReturn;
            // use currentCursor as the pointer to the existing list
            cursorOfListToCopy = head.getLink();
            // if we have a node...
            while (cursorOfListToCopy != null) {
                // create a new node from the end of the new list
                lastNodeOfListToReturn.setNext(new Node(cursorOfListToCopy
                        .getData(), null));
                // move lastNodeOfListToReturn to the new last node
                lastNodeOfListToReturn = lastNodeOfListToReturn.getLink();
                // move the cursorOfListToCopy to the next node
                cursorOfListToCopy = cursorOfListToCopy.getLink();
            }
        }

        return new Lister(headOfListToReturn);
    }
}