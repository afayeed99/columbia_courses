/**
 * This program converts a number of days and weeks into the
 * equivalent number of minutes
 * 
 * @author: Abdul Fayeed Abdul Kadir
 * @UNI: aa5042
 * @date: Feb 2nd, 2024 (Friday)
 */

import java.util.Scanner; 

public class Minutes
{
    public static void main(String[] args)
    {
        System.out.println("Hello! This program is to convert " +
        "a number of days and weeks to minutes.");

        // for input purpose
        Scanner input; 
	    input = new Scanner(System.in); 

        // Ask for the number of days
	    System.out.println("\nPlease enter a number of day(s) first:");
        int days; // assume that user will give integer
	    days = input.nextInt(); 

        // Ask for the number of weeks
        System.out.println("\nNow, please enter a number of week(s):");
        int weeks; // assume that user will give integer
        weeks = input.nextInt();
	
	    // Now do calculations
        int mins = days * 24 * 60 + weeks * 7 * 24 * 60; 
        // (60 mins in 1 hr, 24 hrs in 1 day, 7 days a week)

	    // Now present results
	    System.out.println("\nThere are " + mins + " minutes in " + 
                    days + " day(s) and " + weeks + " week(s).");
    }
}