package project04option2summer2018;
/**
 *This is a class to implement nodes to contain generic types of elements, 
 * any Java object. The nodes will then be linked together to form a linked list
 * collection.
 * 
 * @author Jay Ganji
 * @param <E>
 */
public class Node<E> {
    
    private E data;
    private Node<E> next;
    
    /**
     *Constructor
     * @param initialData any generic type of element
     * @param initialNext the node of the same generic type as the element to
     *    link with
     */
    public Node(E initialData, Node<E> initialNext){
        
        data = initialData;
        next = initialNext;
    }
    
    /**
     * Retrieve the <E> data that is in the node
     * @return The data in the node, could be any generic type <E>
     */
    public E getData(){
        
        return data;
    }
    
    /**
     * Retrieve a reference to the <E> Node that this particular <E> Node is 
     *     linked to
     * @return A reference to the node that this particular node is linked to
     */
    public Node<E> getLink(){
        
        return next;
    }
    
    /**
     * Change the <E> data in this <E> Node with some new <E> data
     * @param newData The new <E> data
     */
    public void setData(E newData){
        
        data = newData;
    }
    
    /**
     * Establish or change the link to an <E> Node that is attached to this
     *     particular node with a link a different  <E> Node
     * @param newNext The different <E> Node
     */
    public void setNext(Node<E> newNext){
        
        next = newNext;
    }
}