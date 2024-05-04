/*
* This program reads a line of input as a string and print
* the number of vowels in the string.
*  
* name: Abdul Fayeed Abdul Kadir
* uni: aa5042
* date: Feb 16th, 2024 (Friday)
*
*/

import java.util.Scanner;

public class E3d{

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    System.out.print("Enter the string to be converted: ");
    String text = input.nextLine();

    int lenText = text.length(); // length of text
    int idxChar; // index of the character in the text, start from 0
    int count = 0; // number of vowels initilization

    for (idxChar = 0; idxChar < lenText; idxChar++){
        String letter = text.substring(idxChar,idxChar + 1);
        if (("aeiou").contains(letter) || ("AEIOU").contains(letter)){
            // return true if they're vowels (upper or lowercase)
            count += 1;
        }
    }
    System.out.println("The number of vowels in \"" + text + 
                            "\" is " + count + ".");
  }
}