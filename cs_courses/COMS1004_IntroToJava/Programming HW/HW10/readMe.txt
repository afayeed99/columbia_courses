Abdul Fayeed Abdul Kadir
aa5042
April 19th, 2024 (Friday)

/*****************************************************************************/
Resources: Lecture and Zybook exercises
a) String.valueOf(included) - to convert included of type char to type String
    https://www.tutorialspoint.com/java/number_valueof.htm

/*****************************************************************************/
WordLists.java
A class where it generates useful word lists for Wordle players from a list
of words.

The class contains 4 static methods.
a) lengthN(ArrayList<String> words, int n) - return a new ArrayList of all
    elements in ArrayList words with length n.
b) letterAt(ArrayList<String> words, char included, int index) - return 
    a new ArrayList of all elements in ArrayList words that contain
    the letter included, at position index.
c) notAt(ArrayList<String> words, char included, int index) - return a new
    ArrayList of all elements in ArrayList words that contain the letter
    included, BUT not at position index.
d) notIn(ArrayList<String> words, char included) - return a new ArrayList
    of all elements in ArrayList words that DO NOT contain the letter
    included.

/*****************************************************************************/
WordTest.java
A program to test WordLists class. This program creates an ArrayList master,
containing words from wordlist.txt file. The program instantiates an ArrayList
myList, that contains only the words with length 4 from the list of words 
in master. The myList is further filtered, by only keeping the words where the 
letter 'j' is the first letter. Next, myList is filtered by only keeping the 
words that contain the letter 'v' and is not the second letter. Lastly, myList
is filtered by only keeping the words that do not have the letter 'e' and 'i'.
The remaining words in myList is then printed out into a file called 'out.txt'.