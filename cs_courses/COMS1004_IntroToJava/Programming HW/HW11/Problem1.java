/*
/* Abdul Fayeed Abdul Kadir
/* aa5042
/* April 26th, 2024 (Friday)
/* Problem1.java
/* Determining whether a substring is contained in a string 
/*
*/

public class Problem1{

    public static void main(String[] args){

        if (args.length>1)
        {
            if (find(args[0],args[1]))
                System.out.println("Present");
            else
                System.out.println("Not present");
        }
    }

    public static boolean find(String text, String str){

        if (text.length() < str.length()){
            return false; 
            // immediately cuz this is not possible
        }

        if (text.substring(0, str.length()).equals(str)){
            return true;
        } 
        else{
            return find(text.substring(1), str); 
            // call again
        }
    }
}