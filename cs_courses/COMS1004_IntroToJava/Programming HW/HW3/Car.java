/* 
 * This is the Car class that you have to create
 * for problem E3.13
 * 1 constructor, 3 methods (drive, addGas, gasLeft)
 * drive - reduce the amount of gas in tank based on miles travelled
 * addGas - add gas into the tank
 * gasLeft - return to user the remaining gas left in the tank
 * 
 * name: Abdul Fayeed Abdul Kadir
 * UNI: aa5042
 * Date: Feb 9th, 2024 (Friday)
 * 
 */

public class Car{
  
    //  for this problem don't worry about the maximum amount of gas
    //  allowed in the tank or tracking the overall miles driven
  
    // 2 instance variables here
    private double gas; // gal
    private double gasMileage; // miles per gal

    public Car(double efficiency){
        // this is the constructor
        gas = 0.0; // initialize to 0
        gasMileage = efficiency; // input
    }
    
    public void drive(double miles){
        // this is a mutator method
        // that reduces the gas in the tank 
        gas -= (1.0/gasMileage) * miles; // gal
    }
    
    public void addGas(double gasAmount){
        // this is a mutator method
        // that adds gas to the tank
        // adds a specified amount of gas in gallons to the tank
        gas += gasAmount; // gal
    }
    
    public double gasLeft(){
        // this is an accessor method for the gas in the tank
        // returns the amount of gas currently left in the tank
        return gas;
    }
}