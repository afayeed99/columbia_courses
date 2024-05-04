/**
 * This class represents the Odd-Even game.
 *
 * Abdul Fayeed Abdul Kadir
 * aa5042
 * March 8th, 2024 (Friday)
 */

import java.util.Scanner;

public class Game {
    private int humanTokenBalance;  // human's cumulative token
    ComputerPlayer comp;            // computer for interactive game
    ComputerPlayer comp1;           // comp 1 for simulation
    ComputerPlayer comp2;           // comp 2 for simulation
    private int player1Token;       // comp 1 cumulative token each game
    private int player2Token;       // comp 2 cumulative token each game

    /**** The methods below are sorted according to parts of the problem ****/
    /************************************************************************/

    /************************************************************************/
    /******************** Methods for Part 1 Begins here ********************/
    /* This version of the game constructor is for part 1
     * It takes no parameters */
    public Game(){
        humanTokenBalance = 0;
        comp = new ComputerPlayer(); // instantiate the computer
        // ignore comp1, comp2, player1Token, player2Token
    }

    /* This method is for part 1
     * This method should play one complete interactive session
     * of odd-even until the user wishes to quit */
    public void playSession(){
        Scanner input = new Scanner(System.in);
        int playersChoice = welcomeMessage(input);
        int compChoice = comp.computersChoice(playersChoice); 
        // will be the opposite of the human's choice
        assignPlayers(playersChoice); // print out the role to the terminal
        String quitPlay = ""; int finalCompToken = 0; int count = 1; 
        // keep track of round and token
        while (! quitPlay.equals("q")){
            // q means quit, so if not quit, keep playing
            startRound(count);
            int humanDeclaredNum = checkValidInput(input);
            int compDeclaredNum = comp.move(); // will return 1 or 2
            System.out.println("Computer's choice: " + compDeclaredNum);
            comp.calcCompBal(humanDeclaredNum,compDeclaredNum,compChoice);
            calcHumanBal(humanDeclaredNum,compDeclaredNum,playersChoice);
            // calculate the cumulative token for human and computer
            finalCompToken = comp.getScore();
            System.out.println("Current Token: human = " + humanTokenBalance +
                                ", computer = " + finalCompToken);
            // SHOULD BE AT THE END, determine if will loop around again or not
            count++; quitPlay = endRound(count,input);
        }
        determineWinner(humanTokenBalance, finalCompToken,"interactive");
        // decide and announce winner, then reset the score for each
    }

    /* This private method is to calculate the balance 
     * in human cumulative token - PART 1 */
    private void calcHumanBal(int humanNum, int compNum, int humanChoice){
        int sum = humanNum + compNum;
        if (humanChoice == 2){
            if (sum % 2 == 0){
                humanTokenBalance += sum; // favor the human
            }
            else{
                humanTokenBalance -= sum; // favor the opponent/comp
            }
        }
        else if (humanChoice == 1){
            if (sum % 2 == 1){
                humanTokenBalance += sum; // favor the human
            }
            else{
                humanTokenBalance -= sum; // favor the opponent/comp
            }
        }
    }

    /* This private method is to print out the role of each player
     * for interactive game, considering the human's choice */
    private void assignPlayers(int user){
        // user refers to human's choice of player's
        if (user == 1){
            System.out.print("Player 1 = Human. \t");
            System.out.println("Player 2 = Computer");
        }
        else if (user == 2){
            System.out.print("Player 1 = Computer. \t");
            System.out.println("Player 2 = Human.");
        }
        System.out.println();
    }

    /* This private method is to check if the user inputs a valid
     * response based on the question asked. Will keep asking the user
     * if the input is not a 1 or 2 */
    private int checkValidInput(Scanner input){
        int usersChoice = 0; boolean keepAsking = true;
        
        while (keepAsking){
            System.out.print("Please enter an integer 1 or 2: ");
            // applicable for choosing a role as P1/2 and choose 1/2 per game
            if (input.hasNextInt()){ // if the input is an integer
                usersChoice = input.nextInt(); // only then assign

                if (usersChoice == 1 || usersChoice == 2){
                    keepAsking = false;
                    input.nextLine(); // just to consume the \n for next time
                } 
                else{
                    input.nextLine(); // to consume any input the user put
                    System.out.println("Invalid integer!");
                }
            } 
            else{
                input.nextLine(); // to consume any input the user put
                System.out.println("Invalid input!");
            }
        }
        return usersChoice;
    }

    /* This private method is to welcome the user 
     * and to ask which role they want to play */
    private int welcomeMessage(Scanner input){
        System.out.println("Welcome to the Odd-Even game!!");
        System.out.println("Which Player do you wish to be?");
        int playersChoice = checkValidInput(input);
        return playersChoice;
    }

    /* This private method is to keep track of number of rounds */
    private void startRound(int count){
        System.out.println("Round " + count + " begins.");
        System.out.println("Choose a number.");
    }
    /* This private method is to end/continue the round */
    private String endRound(int count, Scanner input){
        System.out.print("Round " + count + " ended. ");
        System.out.print("To continue, enter anything. " +
                            "To quit, enter \"q\": ");
        String quitPlay = input.nextLine();
        System.out.println();
        return quitPlay;
    }

    /* This private method is to reset human token balance */
    private void humanReset(){
        humanTokenBalance = 0;
    }
    
    /******************** END OF Methods for Part 1 here ********************/
    /************************************************************************/

    /************************************************************************/
    /******************** Methods for Part 2 Begins here ********************/

    /* this version of the game constructor is for part 2
     * It requires two doubles as parameters. You will use
     * these to set the initial thresholds for you computer players */
    public Game(double t1, double t2){
        comp1 = new ComputerPlayer(t1);
        comp2 = new ComputerPlayer(t2);
        player1Token = comp1.getScore();
        player2Token = comp2.getScore(); 
        // player's token should be 0 here at the beginning of each game
        // ignore comp and humanTokenBalance
    }

    /* This method is for part 2
     * It takes a single int as a parameter which is the
     * number of computer vs. computer games that should be played */
    public void play(int games){
        int player1Role = 1; // odd player
        int player2Role = 2; // even player
        for (int i = 0; i < games; i++){
            int comp1Num = comp1.move();
            int comp2Num = comp2.move();
            comp1.calcCompBal(comp2Num,comp1Num,player1Role);
            comp2.calcCompBal(comp1Num,comp2Num,player2Role);
            // calculate each player's cumulative token balance
            // calcCompBal(opponent's,itself,its role)
        }
        player1Token = comp1.getScore();
        player2Token = comp2.getScore();
        determineWinner(player1Token,player2Token,"simulation");
        comp1.computerReset(); comp2.computerReset();
        // System.out.println(comp1.getScore());
        // player1Token and player2Token = 0 automatically
        // when the game is called again, since computerReset()
        // has been called and the instructor will call the tokenBalance
        // for each computer again which will already be a 0
    }
    /******************** END OF Methods for Part 2 here ********************/
    /************************************************************************/

    /************************************************************************/
    /*************** Shared Methods for Both Parts Begins here **************/
    /* This private method is to determine the winner for each round,
     * where it will print out at terminal the results and remaining tokens
     * if the game is interactive, and remain unprint if simulation */ 
    private void determineWinner(int p1, int p2, String style){
        if (!style.equals("simulation")){
            // if not simulation, meaning it is interactive 
            // then will print out the remaining token's here
            // for simulation, the tokens will be called in its the main class
            if (p1 > p2){
                System.out.println("Player 1 wins!");
            }
            else if (p2 > p1){
                System.out.println("Player 2 wins!");
            }
            else if (p1 == p2){
                System.out.println("It's a tie!");
            }
            System.out.println("Player 1's Remaining Token: " + p1 + ".");
            System.out.println("Player 2's Remaining Token: " + p2 + ".");
            comp.computerReset(); humanReset(); // reset both tokens to 0
        }
    }

    /* This method should return the current score (number of tokens)
     * that player 1 has */
    public int getP1Score(){
        return player1Token;
    }

    /* This method should return the current score (number of tokens)
     * that player 2 has */
    public int getP2Score(){
        return player2Token;
    }
    /*************** END OF Shared Methods for Both Parts here **************/
    /************************************************************************/
}
