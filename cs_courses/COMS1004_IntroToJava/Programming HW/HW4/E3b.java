/*
* This program reads a line of input as a string and print
* every second letter of the string.
*  
* name: Abdul Fayeed Abdul Kadir
* uni: aa5042
* date: Feb 16th, 2024 (Friday)
*
*/

import java.util.Scanner;

public class E3b{

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    System.out.print("Enter the string to be converted: ");
    String text = input.nextLine();
    String newText = ""; // use this variable for your converted text

    int lenText = text.length(); // length of text
    int idxChar; // index of the character in the text, start from 0
    for (idxChar = 0; idxChar < lenText; idxChar++){
        if (idxChar % 2 == 1){
            // index 1,3,5,...(every second character)
            char letter = text.charAt(idxChar);
            newText += letter;
        }
    }


    System.out.println("The converted text is: " + newText);


  }
}