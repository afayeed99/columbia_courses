/**
 * This class represents a computer
 * player in the Odd-Even game
 *
 * Abdul Fayeed Abdul Kadir
 * aa5042
 * March 8th, 2024 (Friday)
 */

public class ComputerPlayer {
    private double t;           // 0 <= t <= 1
    private int tokenBalance;   // only place you should track computer tokens

    /* no argument constructor for the ComputerPlayer
     * This is meant for Part 1 */
    public ComputerPlayer(){
        t = 0.5;
        tokenBalance = 0;
    }

    /* specify the desired strategy in this constructor
     * This is meant for Part 2 */
    public ComputerPlayer(double threshold){
        t = threshold;
        tokenBalance = 0;
    }

    /* This public method is to randomly decide between
     * 1 or 2 for the computer for every round */
    public int move(){
        double randomNum = Math.random();
        int returnVal = 0;
        if (randomNum >= t){
            returnVal = 2;
        }
        else if (randomNum < t){
            returnVal = 1;
        }
        return returnVal;
    }

    /* This public method is Part 1 where computer's role
     * will be the opposite of what the human's role is */
    public int computersChoice(int opponentChoice){
        int compChoice = 0;
        if (opponentChoice == 1){
            compChoice = 2;
        }
        else if (opponentChoice == 2){
            compChoice = 1;
        }
        return compChoice;
    }

    /* This public method is to calculate the cumulative token balance
     * for the computer for each session of multiple games */
    public void calcCompBal(int opponentNum, int compNum, int compChoice){
        int sum = opponentNum + compNum;
        if (compChoice == 2){
            if (sum % 2 == 0){
                tokenBalance += sum; // favor the computer
            }
            else{
                tokenBalance -= sum; // favor the opponent
            }
        }
        else if (compChoice == 1){
            if (sum % 2 == 1){
                tokenBalance += sum; // favor the computer
            }
            else{
                tokenBalance -= sum; // favor the opponent
            }
        }
    }

    /* This public method is to return the cumulative token balance
     * of the computer so far in one game session of multiple games */
    public int getScore(){
        return tokenBalance;
    }

    /* This public method is to reset the cumulative token balance
     * of the computer back to 0 */
    public void computerReset(){
        tokenBalance = 0;
    }
    
}



