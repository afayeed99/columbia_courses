/**
 * This program implements the algorithm created by Fredrich Gauss 
 * for determining the date of Easter
 * 
 * @author: Abdul Fayeed Abdul Kadir
 * @UNI: aa5042
 * @date: Feb 2nd, 2024 (Friday)
 */

import java.util.Scanner;

// import 3 built-in function for the list initializing
// Source: https://www.softwaretestinghelp.com/java-list-how-
// to-create-initialize-use-list-in-java/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Easter
{
    public static void main(String[] args)
    {
        Scanner input; // user input
        input = new Scanner(System.in);

        // Ask for the year
	    System.out.println("\nPlease enter a year (such as 1800 or 2024) " +
        "and I'll print out the month and day of Easter Sunday that year.");
    
        int y = input.nextInt(); // year

        int a = y%19; // remainder of y/19
        int b = y/100; // the quotient only of y/19
        int c = y%100; 
        int d = b/4;
        int e = b%4; 

        int g = (8 * b + 13)/25; 
        int h = (19 * a + b - d - g + 15)%30; 

        int j = c/4;
        int k = c%4;

        int m = (a + 11*h)/319; 
        int r = (2 * e + 2 * j - k - h + m + 32)%7;

        int n = (h - m + r + 90)/25;
        int p = (h - m + r + n + 19)%32;

        // string list
        // Source: https://www.softwaretestinghelp.com/java-list-
        // how-to-create-initialize-use-list-in-java/
        List<String> list = Arrays.asList("January","February",
                    "March","April","May","June","July","August",
                    "September","October","November","December");
        int idx = n - 1; 
        // if n = 1, idx = 0, so it will be January, 
        // since list.get(idx = 0) == January,  will assume (1 <= n <= 12)
        String month = list.get(idx);

        // Ask for the year
	    System.out.println("\nIn " + y + ", Easter Sunday fell on " + 
                            month + ", " + p + ".");
    }
}