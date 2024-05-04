/*
/* Abdul Fayeed Abdul Kadir
/* aa5042
/* April 26th, 2024 (Friday)
/* Problem2.java
/* Determining whether a substring is contained in a string 
/*
*/

public class Problem2{

    public static void main(String[] args){

        int[] a = {4,3,-1,9,0,10};
        System.out.println("largest: " + findLargest(a,a.length));      

    }

    public static int findLargest(int[] a, int n){
        if (n == 1){
            return a[0];
        }

        int largest = findLargest(a, n - 1);    
        return Math.max(largest, a[n - 1]);
    }

}