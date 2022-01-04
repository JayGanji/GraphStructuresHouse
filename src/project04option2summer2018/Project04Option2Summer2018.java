package project04option2summer2018;
import java.util.Scanner;

/**
 * This is a driver file to demonstrate a model of a house implemented via a
 *     graph data structure using linked lists. A user can interact with the 
 *     program to travel around the house's various rooms or exit when they wish
 *     to do so.
 * 
 * @author Jay Ganji
 */
public class Project04Option2Summer2018 
{
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        HouseGraph myHouse = new HouseGraph();
        Scanner visitor = new Scanner(System.in);
        int guestChoice;
        Location currentLocation = myHouse.getHomeLocation();
        Lister neighborsList, responseList; 
        
        do{
            neighborsList = myHouse.neighbors(currentLocation);
            
            System.out.println("\nYou are currently in room " + 
                    currentLocation);
            System.out.println("neighbors of " + currentLocation + " are: ");
            for (int i=1; i<=currentLocation.numNeighbors(); i++)
            {
                System.out.print(i + "-" + neighborsList.next());
                if (neighborsList.hasNext())
                    System.out.print(", ");
            }
            System.out.print("\n\nWhere would you like to go? (-1 to exit): ");
            guestChoice = visitor.nextInt();
            
            while (guestChoice < -1 || 
                    guestChoice > currentLocation.numNeighbors() || 
                    guestChoice==0)
            {
                neighborsList = myHouse.neighbors(currentLocation);
                
                System.out.println("\noops! not a neighbor");
                System.out.println("\nYou are currently in room " + 
                        currentLocation);
                System.out.println("neighbors of " + currentLocation + 
                        " are: ");
                for (int i=1; i<=currentLocation.numNeighbors(); i++)
                {
                    System.out.print(i + "-" + neighborsList.next());
                    if (neighborsList.hasNext())
                        System.out.print(", ");
                }
                System.out.print("\n\nWhere would you like to go? "
                        + "(-1 to exit): ");
                guestChoice = visitor.nextInt();
            }
            
            responseList = myHouse.neighbors(currentLocation);
            for (int j=0; j<guestChoice; j++)
            {
                currentLocation = (Location)responseList.next();
            }
            
        } while (guestChoice!=-1);
        
        System.out.println("\nGood bye!");
    }
    
}
