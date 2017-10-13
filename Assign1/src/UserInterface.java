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
     private boolean pass = false;
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
        switch(choice)
        {

           case 'A':
           case 'a': 
                     System.out.println("Adding a movie to library");
                     System.out.println();
                     pass = true;
                     list.add();
                     userInput();
                     break;
           case 'R':
           case 'r': 
                     System.out.println("Removing a movie from library");
                     System.out.println();
                     pass = true;
                     list.remove();
                     userInput();
                     break;
           case 'D': 
           case 'd': 
                     System.out.println("Displaying movies in library");
                     pass = true;
                     list.display();
                     userInput();
                     break;
           case 'S':
           case 's': 
                     System.out.println("Searching for a movie");
                     System.out.println();
                     pass = true;
                     list.search();
                     userInput();
                     break;
           case 'E':
           case 'e':
                     System.out.println("Exiting library.... Enjoy your day");
                     System.out.println();
                     pass = true;
                     quit = true;
                     break;

           default: 

                         System.out.println("I have no idea what that command is... use options provided.");
                         System.out.print("Enter a valid choice:");
                         pick = in.nextLine();
                         choice = pick.charAt(0);
                         decision(choice);
                      
        }
      }
      // Organizes the display menu with input, so it can be used again when action has finished.
      public void userInput()
       {
          pass = false;
          while(pass == false)
           {
             displayMenu();
             pick = in.nextLine();
             choice = pick.charAt(0);
             decision(choice);
           }
       }        
      // The start of the program that runs the userInput method, and welcome title.
      public void start()
       { 
          System.out.println("Hi! Welcome to your movie library!");
          userInput();  
       }
        
    
}