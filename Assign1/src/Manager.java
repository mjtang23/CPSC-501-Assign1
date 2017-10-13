/* Marcus Tang 10086730 *Credit to James Tam* Version: April 14th, 2015
This class provides all the classes that are involved with the actions of the library. It adds, removes, searches and displays movies in the library. This actions have to be called upon, in order to figure out what the user wants to do in their library. This can only calls methods from the movie and movienode class to adjust their values. 

*/
import java.util.*;


public class Manager
{
   private MovieNode head;
   private Scanner in = new Scanner(System.in);
   private String pick;
   //private int number;
   private static final int MATCH = 0;
   boolean pass = false;
   // null head means empty list
   public Manager()
   {
      MovieNode head = null;
   }
  // Sets the userinput for given genres
   public String GenreInput(String pick)
    { 
      String temp = "";
      int check;

      
     
      switch(pick)
      {
        case "1":
               temp = "Action";
               pass = true;
               break;
        case "2":
               temp = "Drama";
               pass = true;
               break;
        case "3":
               temp = "Science Fiction";
               pass = true;
               break;
        case "4":
               temp = "Comedy";  
               pass = true;             
               break;
        case "5":
               temp = "Horror"; 
               pass = true;              
               break;
        case "6":
               temp = "Martial Arts"; 
               pass = true;              
               break;
        case "7":
               temp = "Other"; 
               pass = true;              
               break;
        default:
               
                if(pick.length() == 0)
                {
                    temp = "";
                }
               else
                  System.out.print("Choice not valid, please pick again:");
               
       }
       return temp;
     }
   // Shows options for genre menu
   public void GenreMenu()
   {
      System.out.println("Select Genre");
      System.out.println("\t (1) Action");
      System.out.println("\t (2)Drama");
      System.out.println("\t (3)Science Fiction");
      System.out.println("\t (4)Comedy");
      System.out.println("\t (5)Horror");
      System.out.println("\t (6)Martial Arts");
      System.out.println("\t (7)Other");
      System.out.print("Enter choice:");
   }
   
   // Checks to see if rating input is valid 
   public String RatingCheck(String pick)
    {
       String temp = "0";
       char negative = '-';
       String choice;
       switch(pick)
       {
          case "1":
                   temp = "1";
                   pass = true;
                   break;
          case "2":
                   temp = "2";
                   pass = true;
                   break;
          case "3":
                   temp = "3";
                   pass = true;
                   break;
          case "4":
                   temp = "4";
                   pass = true;
                   break;
          case "5":
                   temp = "5";
                   pass = true;
                   break;
          default:
                  if(pick.charAt(0) == negative)
                   {
                      temp = "";
                      
                   }
                  else
                   {
                      System.out.print("Input invalid, please try again:"); 
                   }
        }
       return temp;
    }  
   // This method adds a movie class to the library
   public void add()
    {
        String title;
        String genre;
        String pick;
        String rating;
        int castSize;
        int i;
        String member;
        

        Movie newMovie;
        MovieNode newNode;
	    System.out.println("What movie do you want to add?:");
        System.out.print("Movie title: ");
        title = in.next();
        System.out.println();
        GenreMenu();
        do{
           pick = in.next();   
           genre = GenreInput(pick);
           if(genre.length() == 0)
            {
              System.out.println("Going to menu");
              return;
            }
         }while(pass == false);
     
        pass = false;
        System.out.print("What's the rating of this movie?(1 being the worst and 5 being the best)" + "\n Negative value will cancel a rating:");
        do{
           pick = in.next();
           rating = RatingCheck(pick);
           if(rating.length() == 0)
             {
               System.out.println("Going to menu");
               return;
             }
          
         }while(pass == false);

        pass = false;
        System.out.print("How many cast do you want to put for this movie?:");
        do{
           try{
               castSize = in.nextInt(); 
               pass = true;
             }
           catch(Exception e){
              System.out.println("Not a number... please try again:");
              castSize = in.nextInt();
             }
          }while(pass == false);

        newMovie = new Movie(title, genre, rating, castSize);
        System.out.println("Who is in this movie?");
        
        pass = false;
        for(i = 0; i < castSize; i++)
         {
           System.out.print("Cast Member name:");
           member = in.next();
           newMovie.setCast(i, member);
         }
        newNode = new MovieNode(newMovie,null);

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
            	if(title.compareToIgnoreCase(current.getData().getName()) < MATCH){
            		newNode.setNext(current);
            		head = newNode;
        	    	//current.getNext()
                 	
                 	
                 	
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
                   if(title.compareToIgnoreCase(current.getData().getName()) < MATCH)
                     {
                	    if(head == current){
                	     	newNode.setNext(current);
                	    	current.setNext(null);
                         	head = newNode;
                         	previous = current;
                            current = current.getNext();
                            
                         	
                        }
                	 
                	    else{
                           newNode.setNext(current);
                           previous.setNext(newNode);
                           break;
                	    }
                   
                    
                     }
                    // if head doesnt get replaced
                    else if(title.compareToIgnoreCase(current.getData().getName()) > MATCH ){
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
  
  
}
