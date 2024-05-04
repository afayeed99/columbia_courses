/********************************************************************
*  AudioBookCollection.java       Author: Cannon
*
*  Represents a collection of audio books.

* Modified by:
    - Abdul Fayeed Abdul Kadir
    - aa5042
    - April 5th, 2024 (Friday)
********************************************************************/
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class AudioBookCollection
{
    private ArrayList<AudioBook> collection;;
    private double totalCost;

    /*-----------------------------------------------------------------
    * Constructor: Creates an initially empty collection.
    *----------------------------------------------------------------*/
    public AudioBookCollection ()
    {
        collection = new ArrayList<AudioBook>();
        totalCost = 0.0;
    }

    public AudioBookCollection(String fileName){

        collection = new ArrayList<AudioBook>();
        totalCost = 0.0;

        try(Scanner input = new Scanner(new File(fileName));){
            while (input.hasNextLine()){
                String arg1 = input.nextLine();
                String arg2 = input.nextLine();
                String arg3 = input.nextLine();
                double arg4 = Double.parseDouble(input.nextLine());
                int arg5 = Integer.parseInt(input.nextLine());
                addBook(arg1,arg2,arg3,arg4,arg5);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }
        catch(NumberFormatException e){
            System.out.println("Cannot convert string to double/integer!");
        }
    }

    /*-----------------------------------------------------------------
    *  Adds an audio book to the collection, increasing the size of the
    *  collection if necessary.
    *----------------------------------------------------------------*/
    public void addBook (String title, String author, String readBy,
                         double cost, int minutes)
    {
        collection.add(new AudioBook(title, author, readBy, cost, minutes));
        totalCost += cost;
    }

    /*-----------------------------------------------------------------
    *  Returns a report describing the Book collection.
    *----------------------------------------------------------------*/
    public String toString()
    {
        Locale usa = new Locale("en", "US");
        NumberFormat fmt= NumberFormat.getCurrencyInstance(usa);

        String report = "~~~~~~~~~~~~~~Wow Cool~~~~~~~~~~~~~~~~~~~~~~~\n";
        report += "My Audio Book Collection\n\n";

        report += "Number of Books: " + collection.size() + "\n";
        report += "Total cost: " + fmt.format(totalCost) + "\n";
        report += "Average cost: " + fmt.format(totalCost/collection.size());

        report += "\n\nBook List:\n\n";

        for (AudioBook book: collection)
            report += book + "\n";
        return report;
    }

    public void writeSummary(String fileName){
        
        try(PrintWriter output = new PrintWriter(fileName);){
            for (int i = 0; i < collection.size(); i++){
                String line = collection.get(i).summary();
                output.print(line);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
    }
}
