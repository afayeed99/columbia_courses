/* 
 * This is the Car test class
 * Your code for problem 3.13 must work with this
 * You should not change this class
 * 
 * name: Abdul Fayeed Abdul Kadir
 * UNI: aa5042
 * Date: Feb 9th, 2024 (Friday)
 * 
 */

public class CarTester{
    
    public static void main(String[] args){
        Car myCar = new Car(30.0);
        System.out.println("fresh car");
        System.out.println("current gas: " + myCar.gasLeft());
        System.out.println();
        
        myCar.addGas(20.0);
        System.out.println("added 20 gallons");
        System.out.println("current gas: " + myCar.gasLeft());
        System.out.println();
      
        myCar.drive(120.0);
        System.out.println("drove 120 miles");
        System.out.println("current gas: " + myCar.gasLeft());

    }
    
    
}