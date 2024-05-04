/**
* This program solves for the sum of all odd numbers
* between a and b (inclusive),  where a and b are inputs
* 
* @author: Abdul Fayeed Abdul Kadir
* @UNI: aa5042
* @date: Feb 9th, 2024 (Friday)
*/

import java.util.Scanner;

public class E1d{

  public static void main(String[] args){

    int sum = 0;
    System.out.println("This program will return the sum of all odd numbers "
                          + "between integer a and b (inclusive).");
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the integer a (where a < b): ");
    int a = input.nextInt();

    System.out.print("Now enter the integer b (where a < b): ");
    int b = input.nextInt();

    int number;
    for (number = a; number <= b; number++) {
      if (number % 2 == 1) { // modulus 1, meaning they're odd numbers
        sum += number;
      }
    }

    System.out.println("The sum is: " + sum);

  }
}