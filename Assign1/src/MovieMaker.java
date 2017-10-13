import java.util.Scanner;

public class MovieMaker {
	private boolean pass = false;
	Movie newMovie;
	MovieNode newNode;

    private String title;
    private String genre;
    private String pick;
    private String rating;
    private int castSize;
    private int i;
    private String member;
	public void create(){
		
	
		
		Scanner in = new Scanner(System.in);
		String pick;
	    String genre;
	    String member;
	    String title;
	    String rating;
	    int castSize;
	
		
		
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
				System.out.println("incorrect input, please select another value");
				GenreMenu();
			}
			
		}while(pass == false);
 
		pass = false;
		System.out.print("What's the rating of this movie?(1 being the worst and 5 being the best)" + "\n Negative value will cancel a rating:");
    do{
    	pick = in.next();
    	rating = RatingCheck(pick);
    	if(rating.length() == 0)
         {
           System.out.println("Not valid input, please try again");
           
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
    for(int i = 0; i < castSize; i++)
     {
       System.out.print("Cast Member name:");
       member = in.next();
       newMovie.setCast(i, member);
     }
   
    

}
	public String getTitle(){
		return title;
	}
	
	public Movie getMovie(){
		return newMovie;
	}
	public String GenreInput(String pick)
    { 
      String temp = "";
      
      
     
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
}
