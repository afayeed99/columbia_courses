/* 
 * This is the Circuit class that you have to create
 * for Problem 3
 * 
 * name: Abdul Fayeed Abdul Kadir
 * UNI: aa5042
 * Date: Feb 9th, 2024 (Friday)
 * 
 */

public class Circuit{
    
    private int firstSwitchState;
    private int secondSwitchState;
    private int lampState;
    
    public Circuit(){
        // this is the constructor
        // initialize all switches to down and light to off
        // down = off = 0, up = on = 1
        firstSwitchState = 0;
        secondSwitchState = 0;
        lampState = 0;
        
    }
    
    public void toggleFirstSwitch(){
        // this is a mutator method
        // that toggles the first switch

        if (firstSwitchState == 0){
          // if switch down, push it up
          firstSwitchState = 1;
        }
        else if (firstSwitchState == 1){
          // if switch up, push it down
          firstSwitchState = 0;
        }
        if (lampState == 0){
          // if lamp is off, turn it on
          lampState = 1;
        }
        else if (lampState == 1){
          // if lamp is on, turn it off
          lampState = 0;
        }
    }
    
    public void toggleSecondSwitch(){
        // this is a mutator method
        // that toggles the second switch
        // same mechanism as in toggleFirst Switch
        if (secondSwitchState == 0){
          secondSwitchState = 1;
        }
        else if (secondSwitchState == 1){
          secondSwitchState = 0;
        }
        if (lampState == 0){
          lampState = 1;
        }
        else if (lampState == 1){
          lampState = 0;
        }
    }
    
    public int getLampState(){
        // this is an accessor method for the lamp state
        return lampState;
    }
  
    public int getFirstSwitchState(){
        // this is an accessor method for the first switch
        return firstSwitchState;
    }    
    
    public int getSecondSwitchState(){
        // this is an accessor method for the second switch
        return secondSwitchState;
    }
}