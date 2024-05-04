/*
* This program reads a line of input as a string and print
* the positions of all vowels in the string.
*  
* name: Abdul Fayeed Abdul Kadir
* uni: aa5042
* date: Feb 16th, 2024 (Friday)
* 
*/

import java.util.Scanner;

public class E3e{

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    System.out.print("Enter the string to be converted: ");
    String text = input.nextLine();

    int lenText = text.length(); // length of text
    int idxChar; // index of the character in the text, start from 0
    int position = -1; // position of vowels, initialize as -1 for now

    System.out.print("Vowels found in position: ");
    for (idxChar = 0; idxChar < lenText; idxChar++){
        String letter = text.substring(idxChar,idxChar + 1);
        if (("aeiou").contains(letter) || ("AEIOU").contains(letter)){
            // return true if they're vowels (upper or lowercase)
            position = idxChar;
            System.out.print(position + " ");
        }
    }
    
    if (position == -1){
        // sentinel value, position remains as initialization
        System.out.println("No vowels found.");
    }
    else{
        System.out.println();
    }
  }
}