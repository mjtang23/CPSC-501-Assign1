/* Marcus Tang 10086730 *Credit to James Tam* Version: April 14th, 2015
This contains the information of each movie type. Each movie gets a title, genre, rating , and cast members that are in it. If called to print off, the toString method will display all the values the movie. 
*/

public class Movie
{
   private String name;
   private String [] cast;
   private String genre = null;
   private String rating;
   private int count;
   private int i;

  // Sets the attribute values for the movie
  public Movie(String aName, String aGenre, String aRating, int castSize)
    {
	name = aName;
        genre = aGenre;
        rating = aRating;
        cast = new String[castSize];
    }

   // sets the cast for each position    
  public void setCast(int position, String member)
    { cast[position] = member;}
  
    // returns the title of film
    public String getName()
    { return(name);}
    // set the name of the title
    
    public void setName(String aName)
    { name = aName;}
    
    // returns all attributes when this class is printed off somewhere else
    public String toString()
    {
	String temp;
	if (name != null)
          {
	    temp = "Movie name: " + name + "\n Genre:" + genre + "\n Rating:" + rating;
            temp = temp + "\n Cast member(s):";
            for(i = 0; i < cast.length; i++)
             {
                String pos = cast[i];
                temp = temp + "\n" + "\t" + pos;
             }
          }

	else
	    temp = "Movie name: No-name";
     
	return(temp);
    }



}
