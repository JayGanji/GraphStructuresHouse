package project04option2summer2018;

/**
 * This is a class to implement Location objects, which will model rooms in a 
 *     house and keep track of their adjacent locations, other rooms of the 
 *     house. These Locations will be linked together as vertices of a graph.
 * 
 * @author Jay Ganji
 */
public class Location implements Comparable<Location> 
{
    private String description;
    private LinkedBag<Location> neighbors;
    
    /**
     * Constructor 
     * 
     * @param initDescription the name or description of the new room, as a 
     *     String
     */
    public Location(String initDescription)
    {
        description = initDescription;
        neighbors = new LinkedBag();
    }
    
    /**
     * Retrieve the String name or description of a location in the house
     * @return the String name or description of a location in the house
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Check if a proposed location is a neighbor of this location
     * @param otherLocation the proposed location to check if it is a neighbor
     * @return a boolean value, method returns true if the other location is a 
     *     neighbor of this location, otherwise returns false
     */
    public boolean isNeighbor(Location otherLocation)
    {
        return neighbors.exists(otherLocation);
    }
    
    /**
     * Compare another location to this location lexicographically. 
     * @param otherLocation The other location
     * @return a negative int value if this location is less than other location,
     *     a positive int value if this location is greater than other location,
     *     or 0 if they are equal
     */
    @Override
    public int compareTo(Location otherLocation)
    {
        return description.compareToIgnoreCase(otherLocation.getDescription());
    }
    
    /**
     * Checks if another location is equal to this location
     * @param otherLocation another location
     * @return a boolean value, method returns true if both locations are equal,
     *     otherwise returns false
     */
    public boolean equals(Location otherLocation)
    {
        return description.equalsIgnoreCase(otherLocation.getDescription());
    }
    
    /**
     * Add a neighbor location to the linked list of neighbors for this location
     * @param neighbor a neighboring location
     */
    public void addNeighbor(Location neighbor)
    {
        neighbors.appendList(neighbor);
    }
    
    /**
     * Method for printing locations, will print the description of location
     * @return the description of the location as a String
     */
    @Override
    public String toString()
    {
        return description;
    }
    
    /**
     * Retrieve the number of neighbors this location has
     * @return the number of locations this location has as an int
     */
    public int numNeighbors()
    {
        return neighbors.getSize();
    }
    
    /**
     * Create an iterator for the linked list of neighbors of this location
     * @return a Lister object that can iterate over the linked list of neighbors
     *     for this location
     */
    public Lister<Location> neighbors()
    {
        return neighbors.iterator();
    }
}
