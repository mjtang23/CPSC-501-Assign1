/* Marcus Tang 10086730 *Credit to James Tam* Version: April 14th, 2015
This class provides all the classes that are involved with the actions of the library. It adds, removes, searches and displays movies in the library. This actions have to be called upon, in order to figure out what the user wants to do in their library. This can only calls methods from the movie and movienode class to adjust their values. 
This code doesn't work properly,it will over delete when getting rid of the head.
*/
import java.util.*;


public class Manager
{
   private MovieNode head = null;
   private Scanner in = new Scanner(System.in);
   private String pick;
   //private int number;
   private static final int MATCH = 0;
   private boolean pass = false;
  
   
   // This method adds a movie class to the library
   public void add()
    {
        MovieMaker movie = new MovieMaker();
        movie.create();
        Movie data = movie.getMovie();
        MovieNode newNode = new MovieNode(data, null);
         

        // When the list is empty, it makes the new movie the head (start position)
        if (head == null)
        {
            head = newNode; 
            
        }
        // Case 2: Node not empty, find insertion point (end of list)
        else
        {
            MovieNode current = head;
            MovieNode previous = null;
            // Traverse list: when current is null end is reached
            // Previous reference is one step back and will refer to
            // the last node in the list.
            if(current.getNext() == null){
            	if((newNode.getData().getName()).compareToIgnoreCase(current.getData().getName()) < MATCH){
            		newNode.setNext(current);
            		if(head == current){
            			head = newNode;
            			current.getNext();
            			return;
                     	
            		}
	
            	}
            	else{
            		current.setNext(newNode);
            		return;
            	}
            }
            try{
               while (current != null)
               {
            
            	   // if the header needs to be pushed up and replaced by newNode
                   if(movie.getTitle().compareToIgnoreCase(current.getData().getName()) < MATCH)
                     {
                	    if(head == current){
                	     	newNode.setNext(current);
                	    	//current.setNext(null);
                         	head = newNode;
                         	previous = current;
                            current = current.getNext();
                            break;
                            
                         	
                        }
                	 
                	    else{
                           newNode.setNext(current);
                           previous.setNext(newNode);
                           break;
                	    }
                   
                    
                     }
                    // if head doesnt get replaced
                    else if(movie.getTitle().compareToIgnoreCase(current.getData().getName()) > MATCH ){
                	   previous = current;
                       current = current.getNext();
                    
                     }
            	
            	}
                  
            } catch(Exception e){
        		current.setNext(newNode);
        		return;
              
                
              
               
                 
            }
        
            // Previous refers to last node. Link in new node but adding
            // it to the end (last node's next pointer refers to the new
            // node).
            
            // Adds node to end: since a node's next field is 
            // already set to null at creation, nothing else
            // needs to be done.
        }
       
    }
   
    public void remove ()
    {

	// If the list is empty
	if (head == null)
	    System.out.println("List is already empty: Nothing to remove");

	// If list is not empty 
	else
	{
            removeNonempty();
        }
    } 

    // Case 2 & 3:
    private void removeNonempty()
    {
        MovieNode previous = null;
	MovieNode current = head;
	String searchName = null;
	boolean isFound = false;
	String currentName;
	Scanner in = new Scanner(System.in);
	System.out.print("Enter name of movie to remove: ");
	searchName = in.nextLine();      

        while ((current != null) && (isFound == false))
	{
	    currentName = current.getData().getName();
	    if (searchName.compareToIgnoreCase(currentName) == MATCH)
	        isFound = true;
	    else
	    {
	        previous = current;
		current = current.getNext();
	    }
	}

        // CASE 2A OR 2B: MATCH FOUND (REMOVE A NODE)         
	if (isFound == true)
	{
	    System.out.println("Removing movie called " + searchName);
	    // CASE 2A: REMOVE THE FIRST NODE
	    if (previous == null)
	        head = head.getNext();
	    // CASE 2B: REMOVE ANY NODE EXCEPT FOR THE FIRST 
	    else
	        previous.setNext(current.getNext());
	}

	// CASE 3: NO MATCHES FOUND (NOTHING TO REMOVE).
	else  // isFound == false
	    System.out.println("No movie called " + searchName + 
			      " in the collection.");
    }

    /* Remove from here onwards */
    // What it does: Displays list in current order.
    // How: Displays data for a node, moves onto next node and recursive call again.
 
   // Displays the movies in out library
   public void display(){
	    int count = 1;
        MovieNode temp = head;
        System.out.println("Movie Collection\n");
        System.out.println("---------------");
       
        if (temp == null)
            System.out.println("\tList is empty: nothing to display");
        
        while (temp != null){
        	try{
        		System.out.println("#" + count + " " + temp);
        		temp = temp.getNext();
        		count = count + 1;
        	} catch (Exception e){
        		break;
        	}
          
	}
	System.out.println();
	//return;
    }
   
  //Method searches if there is a list to search through
  public void search(){
     if(head == null){
         System.out.println("List is empty: Nothing to search for...");
      }
    
      else{ 
    	  findMovie(); 
      };
   }
  
  // Looks for a movie title the the user asks for
  public void findMovie(){
       MovieNode previous = null;
	   MovieNode current = head;
	   String searchName = null;
	   boolean isFound = false;
	   String currentName;
	   Scanner in = new Scanner(System.in);
	   System.out.print("What movie are you looking for?: ");
	   searchName = in.nextLine();      

       while ((current != null) && (isFound == false)){
	      currentName = current.getData().getName();
	      if (searchName.compareToIgnoreCase(currentName) == MATCH){
	         isFound = true;
             System.out.println(current);
          }
       
	      else{
	        previous = current;
		    current = current.getNext();
	     }
	   }
       if (isFound == false){
          System.out.println("This title doesn't exist in your library");
          System.out.println();
       }
       
  }
  public boolean choose (char choice){
	  
	     switch (choice){
	        case 'A':
	        case 'a': 
	               System.out.println("Adding a movie to library");
	               System.out.println();
	               //pass = true;
	               add();
	               return false;
	               
	        case 'R':
	        case 'r': 
	               System.out.println("Removing a movie from library");
	               System.out.println();
	               //pass = true;
	               remove();
	               return false;
	               
	        case 'D': 
	        case 'd': 
	               System.out.println("Displaying movies in library");
	               //pass = true;
	               display();
	               return false;
	               
	        case 'S':
	        case 's': 
	               System.out.println("Searching for a movie");
	               System.out.println();
	               //pass = true;
	               search();
	               return false;
	               
	               
	        case 'E':
	        case 'e':
	               System.out.println("Exiting library.... Enjoy your day");
	               System.out.println();
	               //pass = true;
	               return true;
	               

	               
	        default: 

	                   System.out.println("I have no idea what that command is... use options provided.");
	                   System.out.println("Enter a valid choice:");
	                   pick = in.nextLine();
	                   choice = pick.charAt(0);
	                   choose(choice);
	                   return false;
	                   
	                   
	     }
  }
}
