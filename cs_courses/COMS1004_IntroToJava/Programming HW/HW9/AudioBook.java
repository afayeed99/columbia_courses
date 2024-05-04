/********************************************************************
*  AudioBook.java       Author: Cannon
*
*  Represents an audio book. 

* Modified by:
    - Abdul Fayeed Abdul Kadir
    - aa5042
    - April 5th, 2024 (Friday)
********************************************************************/
import java.text.NumberFormat;
import java.util.Locale;

public class AudioBook
{
    private String title, author, readBy;
    private double cost;
    private int minutes;

    //-----------------------------------------------------------------
    //  Creates a new audio book with the specified information.
    //-----------------------------------------------------------------
    public AudioBook (String title, String author, 
                        String readBy, double cost, int minutes)
    {
        this.title = title;
        this.author = author;
        this.readBy = readBy;
        this.cost = cost;
        this.minutes = minutes;
    }

    //-----------------------------------------------------------------
    //  Returns a string description of this audio book.
    //-----------------------------------------------------------------	

    public String toString()
    {
        // for formatting money
        Locale usa = new Locale("en", "US");
        NumberFormat fmt= NumberFormat.getCurrencyInstance(usa);
      
        String description;
        description = String.format(fmt.format(cost) + "\t" + minutes + "\t"
          + "%-20s" + "\t" + "%-50s",author,title);

        return description;
    }

    public String summary(){
        return (title + "\n" + author + "\n" + readBy + "\n" + cost + 
                "\n" + minutes + "\n");
    }
}
