/**
* This program solves for the sum of all squares
* between 1 and 100 (inclusive)
* 
* @author: Abdul Fayeed Abdul Kadir
* @UNI: aa5042
* @date: Feb 9th, 2024 (Friday)
*/

import java.util.Scanner;

public class E1b{

  public static void main(String[] args){

    int sum = 0;

    int number;
    int NUM_MAX = 100; 
    int NUM_START = 1;

    for (number = NUM_START; number <= NUM_MAX; number++) {
      sum += Math.pow(number,2);
    }
  
    System.out.println("The sum is: " + sum);

  }
}