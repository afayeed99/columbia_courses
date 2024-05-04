/**
* This program solves for the sum of all even numbers 
* between 2 and 100 (inclusive)
* 
* @author: Abdul Fayeed Abdul Kadir
* @UNI: aa5042
* @date: Feb 9th, 2024 (Friday)
*/

import java.util.Scanner;

public class E1a{

  public static void main(String[] args){

    int sum = 0;

    int number;
    int NUM_MAX = 100; 
    int NUM_START = 2;

    for (number = NUM_START; number <= NUM_MAX; number++) {
      if (number % 2 == 0) {// modulus = 0, even number 
        sum += number;
      }
    }

    System.out.println("The sum is: " + sum);

  }
}