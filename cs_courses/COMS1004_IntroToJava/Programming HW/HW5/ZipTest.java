/* ************************************************
*
* ZipTest.java
*
* This is a test class for your zip code class.
* Your Zipcode class must work with this test class.
* Do not alter this class.
*
* Zybook 6.18.22 - 6.18.23
***************************************************/

import java.util.Scanner;

public class ZipTest{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

	// Convert from Zip to bar code
        System.out.println("Please enter a ZIP code: ");
        int zip = input.nextInt();
        // System.out.println(zip);
        input.nextLine(); // helps to consume \n after using input.nextInt()
        // so that user can input the barcode for the next thing...

    //Instantiate a Zipcode object using an int    
        Zipcode code1 = new Zipcode(zip);
		System.out.println("The corresponding bar code: ");
        System.out.println(code1.getBarcode());

    //Convert from bar to ZIP code
	    System.out.println("Now please provide a bar code: ");
	    String bar = input.nextLine();

	//Instantiate a Zipcode object using a String      
	    Zipcode code2 = new Zipcode(bar);
	    System.out.println("The corresponding ZIP code: ");
	    System.out.println(code2.getZipcode());

	
    }
}