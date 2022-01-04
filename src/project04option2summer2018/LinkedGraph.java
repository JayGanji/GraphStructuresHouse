package project04option2summer2018;

/**
 * This is a class to implement a graph data structure using a linked list to 
 *     keep track of nodes/vertices. The nodes/vertices contain data of type
 *     <Location>
 * 
 * @author Jay Ganji 
 */
public class LinkedGraph 
{
    private LinkedBag<Location> vertexList;
    
    /**
     * Constructor
     * 
     * initializes the linked list for use in the graph
     */
    public LinkedGraph()
    {
        vertexList = new LinkedBag();
    }
    
    /**
     * Add a Location object as a node in the linked list graph
     * @param newVertex The location object to be added to the graph
     */
    public void addVertex(Location newVertex)
    {
        vertexList.appendList(newVertex);
    }
    
    /**
     * Retrieve the size of the graph, the number of nodes in the linked list
     * @return The size of the graph, the number of nodes in the linked list as 
     *     an int
     */
    public int size()
    {
        return vertexList.getSize();
    }
    
    /**
     * Establish an edge between two vertices.
     * @param source The source vertex for the proposed edge
     * @param destination The target vertext for the proposed edge
     */
    public void addEdge(Location source, Location destination)
    {
        if (vertexList.exists(source) && vertexList.exists(destination))
        {
            source.addNeighbor(destination);
        }
    }
    
    /**
     * Checks to see if there is a valid edge between two vertices
     * @param source The source vertex of the edge to check for existence 
     * @param destination The target vertex of the edge to check for existence
     * @return a boolean value, will return true if a valid edge exists between
     *     the two vertices, otherwise returns false
     */
    public boolean isEdge(Location source, Location destination)
    {
        boolean edge = false;
        
        if (vertexList.exists(source) && vertexList.exists(destination))
        {
            edge = source.isNeighbor(destination);
        }
        
        return edge;
    }
    
    /**
     * Retrieve an iterator for a vertex's linked list of neighbors
     * @param vertex The location for which the iterator of the list of neighbors
     *     is desired
     * @return A Lister object that can iterate over the linked list of neighbors
     *     for this location vertex in the graph
     */
    public Lister<Location> neighbors(Location vertex)
    {
        return vertex.neighbors();
    }
}
