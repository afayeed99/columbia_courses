/**
* This program solves for the powers of 2
* from 2^0 up to 2^20.
* 
* @author: Abdul Fayeed Abdul Kadir
* @UNI: aa5042
* @date: Feb 9th, 2024 (Friday)
*/

import java.util.Scanner;

public class E1c{

  public static void main(String[] args){

    int result;

    int POW_START = 0;
    int POW_END = 20;

    int BASE_NUM = 2;
    int power;
    for (power = POW_START; power <= POW_END; power++) {
      result = (int) Math.pow(BASE_NUM,power);
      // cast an int to result cuz Math.pow returns a double
      System.out.println("2^" + power + " = " + result + ".");
    }

  }
}