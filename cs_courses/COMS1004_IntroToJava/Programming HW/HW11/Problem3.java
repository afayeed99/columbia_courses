/*
* Abdul Fayeed Abdul Kadir
* aa5042
* April 26th, 2024 (Friday)
* Problem3.java
* Determining whether a substring is contained in a string 
*
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Problem3{

    public static void main(String[] args){

        String[] a = {"apple","banana","cherry","date","eggplant"};
        System.out.println("Index: " + binarySearch(a,"banana"));
    }

    public static int binarySearch(Comparable[] a, Comparable x){
        // Arrays.sort(a);
        return binaryHelper(a, x, 0, a.length - 1);
    }

    private static int binaryHelper(Comparable[] a, Comparable x, 
                                    int start, int end){
        if (start > end){
            return -1; // out of bound -> not found
        }
        int mid = start + (end - start) / 2;
        int comparison = x.compareTo(a[mid]);
        if (comparison == 0){
            return mid;
            // same string
        } 
        else if (comparison < 0){
            return binaryHelper(a, x, start, mid - 1);
            // left half
        } 
        else{ // comparison > 0
            return binaryHelper(a, x, mid + 1, end); 
            // right half
        }
    }

}