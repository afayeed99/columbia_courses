/**
 * This class should run simulations to determine
 * whether or not the Odd-Even game is fair and if
 * not who has the advantage and what is a strategy
 * that will realize that advantage
 *
 * Abdul Fayeed Abdul Kadir
 * aa5042
 * March 8th, 2024 (Friday)
 */

import java.text.DecimalFormat;

public class Simulation {
    public static void main(String[] args){
        final int NUM_SIMULATIONS = 100000; // let's do 100k simulations
        final double START_T = 0.0;
        final double END_T = 1.01;
        final double INCREMENT = 0.01;

        boolean fairP1 = true; // assume fair game for now
        boolean fairP2 = true;

        DecimalFormat df = new DecimalFormat("0.000");
        // This specify at least 1 digit before the decimal
        // and only 2 decimal places
        
        /************************** FOR PLAYER 1 NOW *************************/
        System.out.println("SIMULATION FOR FINDING THE BEST OPTION FOR P1");
        for (double t1 = START_T; t1 < END_T; t1 += INCREMENT){
            double t1min = -1.0; double t2min = -1.0; 
            double t1max = 10.0; double t2max = 10.0; 
            int p1min = Integer.MAX_VALUE; int p2min = p1min; 
            // Initialize to maximum possible value

            int p1max = Integer.MIN_VALUE; int p2max = p1max;
            // Initialize to minimum possible value

            for (double t2 = START_T; t2 < END_T; t2 += INCREMENT){
                Game g = new Game(t1,t2);
                // System.out.println(""+countTotal+","+g.getP1Score()); 
                // always 0 at the beginning so it's fine
                g.play(NUM_SIMULATIONS);
                int p1Score = g.getP1Score();
                int p2Score = g.getP2Score();

                // Check if the current score is less than the minimum so far
                if (p1Score < p1min){
                    p1min = p1Score; // Update minimum score for player 1
                    t2min = t2;
                }
                if (p1Score > p1max){
                    p1max = p1Score;
                    t2max = t2;
                }
            }
            if (!(p1min < 0)){ // if it's positive, then we print!!!!
                double avgWin = p1min * 1.0 / NUM_SIMULATIONS;
                System.out.println("For t1 = " + df.format(t1) + 
                ", P1 min score = " + p1min + " @ t2 = " + df.format(t2min) +
                ", P1 max score = " + p1max + " @ t2 = " + df.format(t2max) +
                ", Average winnings = " + df.format(avgWin));
                fairP1 = false;
            }
            
        }
        if (fairP1){ // if still true
            System.out.println("No best threshold for Player 1");
        }

        /************************** END OF PLAYER 1 **************************/
        /*********************************************************************/

        System.out.println();
        System.out.println();
        // indenting for another print out statements

        /*********************************************************************/
        /************************** FOR PLAYER 2 NOW *************************/
        
        System.out.println("SIMULATION FOR FINDING THE BEST OPTION FOR P2");
        for (double t2 = START_T; t2 < END_T; t2 += INCREMENT){
            double t1min = -1.0; double t2min = -1.0;
            double t1max = 10.0; double t2max = 10.0;

            int p1min = Integer.MAX_VALUE; int p2min = p1min; 
            // Initialize to maximum possible value

            int p1max = Integer.MIN_VALUE; int p2max = p1max;
            // Initialize to minimum possible value

            for (double t1 = START_T; t1 < END_T; t1 += INCREMENT){
                Game g = new Game(t1,t2);
                // System.out.println(""+countTotal+","+g.getP1Score()); 
                // always 0 at the beginning so it's fine
                g.play(NUM_SIMULATIONS);
                int p1Score = g.getP1Score();
                int p2Score = g.getP2Score();

                // Check if the current score is less than the minimum
                if (p2Score < p2min){
                    p2min = p2Score; // Update minimum score for player 2
                    t1min = t1;
                }
                if (p2Score > p2max){
                    p2max = p2Score;
                    t1max = t1;
                }
            }
            if (!(p2min < 0)){ // if it's positive, then we print!!!!
                double avgWin = p2min * 1.0 / NUM_SIMULATIONS;
                System.out.println("For t2 = " + df.format(t2) +
                ", P2 min score = " + p2min + " @ t1 = " + df.format(t1min) +
                ", P2 max score = " + p2max + " @ t1 = " + df.format(t2max) +
                ", Average winnings = " + df.format(avgWin));

                fairP2 = false;
            }
        }

        if (fairP2){
            System.out.println("No best threshold for Player 2");
        }
        /************************** END OF PLAYER 2 **************************/
        /*********************************************************************/
    }
    
}
