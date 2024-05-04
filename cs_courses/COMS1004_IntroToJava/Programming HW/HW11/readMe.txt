Abdul Fayeed Abdul Kadir
aa5042
April 26th, 2024 (Friday)

/*****************************************************************************/
Resources: Lecture/Zybook Exercises

/*****************************************************************************/
Problem1.java
This program recursively test if a given text contains the provided string. 
The static method find returns a boolean and takes two arguments:
a) String text - text to be searched
b) String str - str to look for in text
For example, find("Mississippi", "sip") will return true.

/*****************************************************************************/
Problem2.java
This program recursively find the largest value in an array of integers
and will return that value. The static method findLargest takes two arguments:
a) int[] a - an array of integers to be searched
b) int n - the integer to look for in array a
It is assumed that there is no duplicate integer in the array.

/*****************************************************************************/
Problem3.java
This program implements a recursive version of binary search. The static method
binarySearch takes in two arguments:
a) Comparable[] a - an array of classes that have Comparable extensions, to be
                    searched
b) Comparable x - the class that have Comparable extension, to look for in a

The static method utilizes a helper static method called binaryHelper. 
The method takes in four arguments:
a) Comparable[] a - an array of classes that have Comparable extensions, to be
                    searched
b) Comparable x - the class that have Comparable extension, to look for in a
c) int start - the index to start searching for x in a
d) int end - the index to end searching for x in a