/* Marcus Tang 10086730 *Credit to James Tam* Version April 14th, 2015
This class points where the next part of the list should point to. This takes the movies that are listed, and can point out what movies should go next. This can give the movies in a list a certain order. This has to call the Movie class.
*/

public class MovieNode
{
   private Movie data;
   private MovieNode next;
    // takes the data from movie class, while setNext will point to next movie class that was created
    public MovieNode()
    {
        setData(null);
        setNext(null);
    }
    // Sets the data and the getNext points
    public MovieNode(Movie someData, MovieNode nextNode)
    {
        setData(someData);
        setNext(nextNode);
    }
    // returns the class movie
    public Movie getData()
    {
        return(data);
    }
    // returns the movie that is next in the list
    public MovieNode getNext()
    {
        return(next);
    }
    // sets the class currently being looked at
    public void setData(Movie someData)
    {
        data = someData;
    }
    // sets the class that the list goes to next from that class
    public void setNext(MovieNode nextNode)
    {
        next = nextNode;
    }
    // prints out the current state of this class
    public String toString()
    {
        return(data.toString());
    }


}
