/**************************************
* WordTest.java
*
*  Class to test WordLists
*  Programming Project 5, COMS W1004
*
*
*  Your Name: Abdul Fayeed Abdul Kadir
*  Your Uni: aa5042
*  Date: April 19th, 2024 (Friday)
***************************************/

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class WordTest{

    public static void main(String[] args){

        String filename = "wordlist.txt";
        try(Scanner input = new Scanner(new File(filename));
            PrintWriter output = new PrintWriter("out.txt")){
            ArrayList<String> master = new ArrayList<String>();

            while (input.hasNextLine()){
                master.add(input.nextLine());
            }

            ArrayList<String> myList = WordLists.lengthN(master,4);
            myList = WordLists.letterAt(myList,'j',0);
            myList = WordLists.notAt(myList,'v',1);
            myList = WordLists.notIn(myList,'e');
            myList = WordLists.notIn(myList,'i');

            for (String word : myList){
                output.print(word);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }        
    }
}