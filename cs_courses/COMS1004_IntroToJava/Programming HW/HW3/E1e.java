/**
* This program solves for the sum of all odd digits
* of an input (ex: input = 32677, sum = 3 + 7 + 7 = 17)
* 
* @author: Abdul Fayeed Abdul Kadir
* @UNI: aa5042
* @date: Feb 9th, 2024 (Friday)
*/

import java.util.Scanner;

public class E1e{

  public static void main(String[] args){

    int sum = 0;

    System.out.println("This program returns the sum of all odd digits " +
                    "of your given input.");
    System.out.print("Enter any whole number/integer: ");

    Scanner input = new Scanner(System.in);
    String wholeNum = input.next(); // this accept a string

    int wholeNumLen = wholeNum.length(); 
    // System.out.println("len is " + wholeNumLen); // for debugging
    int indexDigit; // will go through one digit at a time
    int digit; // the digit itself, according to the indexDigit

    for (indexDigit = 0; indexDigit < wholeNumLen; indexDigit++) {
      digit = Integer.parseInt(wholeNum.substring(indexDigit,indexDigit + 1));
      // will go through each digit one by one
      // System.out.println("index " + indexDigit + " the digit " + digit);
      // for debugging

      if (digit % 2 == 1) { // if digit is odd, modulus = 1
        sum += digit;
        // System.out.println("odd is " + digit + " sum is " + sum);
        // for debugging
      }
    }

    System.out.println("The sum is: " + sum);
    
  }
}