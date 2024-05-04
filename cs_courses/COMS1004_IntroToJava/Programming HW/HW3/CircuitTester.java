/* 
 * This is the test class fo the Circuit class
 * Your code for problem 3.4 must work with this
 * You should not change this class
 * 
 * name: Abdul Fayeed Abdul Kadir
 * UNI: aa5042
 * Date: Feb 9th, 2024 (Friday)
 * 
 */

public class CircuitTester{
    
    public static void main(String[] args){
        Circuit myCircuit = new Circuit();
      
        // test initial state
        System.out.println("current lamp state: " + myCircuit.getLampState());
        System.out.println("first switch state: " + myCircuit.getFirstSwitchState());
        System.out.println("second switch state: " + myCircuit.getSecondSwitchState());
        System.out.println();
        
        // test first switch
        System.out.println("Toggle first switch");
        myCircuit.toggleFirstSwitch();
        System.out.println("current lamp state: " + myCircuit.getLampState());
        System.out.println("first switch state: " + myCircuit.getFirstSwitchState());
        System.out.println("second switch state: " + myCircuit.getSecondSwitchState());
        System.out.println();
        
        // test second switch
        System.out.println("Toggle second switch");
        myCircuit.toggleSecondSwitch();
        System.out.println("current lamp state: " + myCircuit.getLampState());
        System.out.println("first switch state: " + myCircuit.getFirstSwitchState());
        System.out.println("second switch state: " + myCircuit.getSecondSwitchState());
        System.out.println();
        
        // test first switch again
        System.out.println("Toggle first switch");
        myCircuit.toggleFirstSwitch();
        System.out.println("current lamp state: " + myCircuit.getLampState());
        System.out.println("first switch state: " + myCircuit.getFirstSwitchState());
        System.out.println("second switch state: " + myCircuit.getSecondSwitchState());
        System.out.println();
      
      
    }
    
    
}