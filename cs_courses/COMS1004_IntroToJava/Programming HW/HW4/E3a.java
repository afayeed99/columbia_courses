/*
* This program reads a line of input as a string and print
* only the uppercase letters in the string.
*  
* name: Abdul Fayeed Abdul Kadir
* uni: aa5042
* date: Feb 16th, 2024 (Friday)
*
*/

import java.util.Scanner;

public class E3a{

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    System.out.print("Enter the string to be converted: ");
    String text = input.nextLine();
    String newText = ""; // use this variable for your converted text

    int lenText = text.length(); // length of text
    int idxChar; // index of the character in the text, start from 0
    for (idxChar = 0; idxChar < lenText; idxChar++){
      String letter = text.substring(idxChar, idxChar + 1);
      // char letter = text.charAt(idxChar);
      if (isUpperCase(letter)){
      // if (Character.isUpperCase(letter)){ 
        // if true (yes uppercase), then execute the line
        newText += letter;
      }     
    }
    System.out.println("The converted text is: " + newText);
  }
}