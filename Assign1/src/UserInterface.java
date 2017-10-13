/* Marcus Tang 10086730 *Credit to James Tam* Version: April 14th, 2015
This calls for the menu for a user to understand the commands of the program. Once the user chooses an option, it calls the manager to run certain methods within the manager class. This class only calls for the actions, and therefore doesn't do any of the action it provides.
*/

import java.util.Scanner;

public class UserInterface
{
     private Scanner in = new Scanner(System.in);
     private Manager list = new Manager();
     private char choice;
     private String pick;
     private boolean quit = false;
     // Displays the menu to explain the options given
     public void displayMenu()
      {
         System.out.println("You have the option to add, remove, search, or display movies in your library.");  
         System.out.println("You may also exit if you are done with library");  
         System.out.println("\t (A)dd a movie to library");
         System.out.println("\t (R)emove a movie from library");
         System.out.println("\t (D)isplay movies");
         System.out.println("\t (S)earch for a movie in library");
         System.out.println("\t (E)xit out");
         System.out.print("What would you like to do?:"); 
      }
     // Checks to see if input is valid
     public void decision(char choice)
      {
        quit = list.choose(choice);
        userInput();
      }
      // Organizes the display menu with input, so it can be used again when action has finished.
      public void userInput()
       {
          
          while(quit == false)
           {
        	 try{
                displayMenu();
                pick = in.nextLine();
                choice = pick.charAt(0);
                decision(choice);
        	 }catch (Exception e){
        		 System.out.println("Wrong input, please try again\n");
        		 userInput();
        	 }
           }
       }   
      
      
    	 
      // The start of the program that runs the userInput method, and welcome title.
      public void start()
       { 
          System.out.println("Hi! Welcome to your movie library!");
          userInput();  
       }
        
    
}
