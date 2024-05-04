/**************************************
*
*  WordLists.java
*
*  Class to aid with Wordle
*  Programming Project 5, COMS W1004
*
*
*  Your Name: Abdul Fayeed Abdul Kadir
*  Your Uni: aa5042
*  Date: April 19th, 2024 (Friday)
***************************************/
import java.util.ArrayList;

public class WordLists{

   public static ArrayList<String> lengthN(ArrayList<String> words, int n){
      ArrayList<String> newArray = new ArrayList<String>();
      for (int i = 0; i < words.size(); i++){
         int wordLength = words.get(i).length();
         if (wordLength == n){
            newArray.add(words.get(i));
         }
      }
      return newArray;
   }

   public static ArrayList<String> letterAt(ArrayList<String> words, 
   char included, int index){
      ArrayList<String> newArray = new ArrayList<String>();
      for (String word : words){
         if (word.length() > index){
            char letter = word.charAt(index);
            if (letter == included){
               newArray.add(word);
            }
         }
      }
      return newArray;
   }

   public static ArrayList<String> notAt(ArrayList<String> words,
   char included, int index){
      ArrayList<String> newArray = new ArrayList<String>();
      for (String word : words){
         boolean found = word.contains(String.valueOf(included));
         // String.valueOf(included) to convert char to String
         // use contains to check if string included found in string word
         if (found && word.length() <= index){
            newArray.add(word);
         }
         else if (found){
            char letter = word.charAt(index);
            if (letter != included){
               newArray.add(word);
            }
         }
      }
      return newArray;
   }

   public static ArrayList<String> notIn(ArrayList<String> words,
   char included){
      ArrayList<String> newArray = new ArrayList<String>();
      for (String word : words){
         boolean found = word.contains(String.valueOf(included));
         if (!found){ 
            // if found = true, means included in word
            // if found = false, no included in word
            newArray.add(word);
         }
      }
      return newArray;
   }

} // end of class