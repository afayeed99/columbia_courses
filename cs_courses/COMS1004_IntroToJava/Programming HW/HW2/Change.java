/**
 * This program determines how to give change to a customer
 * who provides a price and amount paid.
 * 
 * @author: Abdul Fayeed Abdul Kadir
 * @UNI: aa5042
 * @date: Feb 2nd, 2024 (Friday)
 */

// dollar - $1, quarters - 25 cents, dimes - 10 cents, 
// nickels - 5 cents, pennies - 1 cent
import java.util.Scanner;

public class Change
{
    public static void main(String[] args)
    {
        System.out.println("What is the amount due? For example, " +
                    "if the amount due is $2.74, please input 274, " +
                    "not 2.74, or 100 for $1.00.");

        Scanner input = new Scanner(System.in);

        int amtDue = input.nextInt();

        System.out.println("\nHow much does the customer paying? " +
                    "For example, if the customer pays $10.50, please " +
                    "input 1050, not 10.50, or 100 for $1.00.");
        
        int amtRec = input.nextInt();
        int totalChange = (amtRec - amtDue);

        int dolChange = totalChange/100; 
        // divide by 100 to get the change in dollar only, 
        // integer division

        int remCents = totalChange%100; 
        // remainder of the division in dollar, in cents

        int quartChange = remCents/25; 
        // amount of quarters
        int dimeChange = (remCents%25)/10; 
        // remainder of quarters, then divide by 10 
        // to get the amount of dimes change
        int nickelChange = ((remCents%25)%10)/5; 
        // remainder of dime, divide by 5 to get amount of nickels left
        int pennyChange = ((remCents%25)%10)%5; 
        // remainder of nickels will just be pennies

        System.out.println("\nThe customer should receive in return $" + 
                    dolChange + ", " + quartChange + " quarter(s), " + 
                    dimeChange + " dime(s), " + nickelChange + 
                    " nickel(s), and "+ pennyChange + " pennies.");
    }
}