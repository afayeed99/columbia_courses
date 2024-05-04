Abdul Fayeed Abdul Kadir
aa5042
April 5th, 2024 (Friday) - late submission (April 9th, 2024 - Tuesday)

/*****************************************************************************/
Resources: lectures and zybooks

/*****************************************************************************/
AudioBook.java
This program, written by Professor Cannon, creates an AudioBook class, which
can be instantiated with the following 5 parameters:
a) title - title of the AudioBook
b) author - author of the AudioBook
c) readBy - name of the person who reads the AudioBook
d) cost - the cost of the AudioBook
e) minutes - the length of the AudioBook

This class has several methods (newly added and written by Prof. Cannon):
a) toString() - formatting the AudioBook information to terminal,
    if the user wishes to print out the content of the AudioBook
b) summary() - writing a summary of the AudioBook information, in the
    following format:
        "title"
        "author"
        "readBy"
        "cost"
        "minutes"

/*****************************************************************************/
AudioBookCollection.java
This program, written by Professor Cannon, creates an ArrayList collection of
AudioBooks. 

The AudioBookCollection can be instantiated in two ways:
a) By inputting the information of each AudioBook manually into the collection
b) By reading the information of each AudioBook from an existing text file

Prof. Cannon has provided the constructor for a). The constructor is overloaded 
for b), by taking information from an existing text file.
The information comprises of the description of each AudioBook, which
later to be added into a collection of AudioBook. 

A new method was added called writeSummary(String fileName):
- which is to write a summary of each AudioBook in the collection of 
    AudioBook, into a text file called fileName, 
    formatted the way that AudioBook class summary() method provides.

/*****************************************************************************/
Hw9Test.java
This is a tester code for HW9, where the first portion of the code manually
adds 5 AudioBook into a collection of AudioBook. It later writes the summary
of the collection of AudioBook into a text file called storedCollection.txt.
The next portion of the tester code is to read the text file created previously
and to write a different set of AudioBook collection, in which contains the 
same content as the other AudioBook collection.

Both AudioBook collections then printed out to user, and they should have the 
same description displayed to the user.
