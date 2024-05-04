/**
 * This is a sample tester for Part 2
 * We will use something similar to this to test your work
 * Your program must work with this tester
 * 
 * @author Cannon 
 */

public class SimTest{
    public static void main(String[] args){
        // instantiate a game with two computer players
        Game g = new Game(0.58,0.3); 
        g.play(1000); // play 1000 games. Please, no print statements.
        System.out.println("Player 1 now has "+ g.getP1Score()+" tokens.");
        System.out.println("Player 2 now has "+ g.getP2Score()+" tokens.");
        // int count = 0;
        // for (int k = 0; k < 1000; k++){
        //     g.play(1000); // play 1000 games. Please, no print statements.
        //     // System.out.println("Player 1 now has "+ g.getP1Score()+" tokens.");
        //     // System.out.println("Player 2 now has "+ g.getP2Score()+" tokens.");
        //     if (g.getP1Score() > 0){
        //         count++;
        //     }
        // }
        // System.out.println(count/1000.0);

        // Game g = new Game(x,y)
        // when x = y = 0 or 1, Player 2 will ALWAYS wins
        // why? because at threshold 1 (0), each player will always choose 1 (2),
        // in which the sum always lead to an even number = 2 (4)
        // when x = 0 (1) and y = 1 (0), one player will choose 1 and other will choose 2 ALWAYS
        // leads to sum of odd number = 3, and player 1 will win obviously

        // so now we have to simulate the middle number and for so many games, to see which is 
        // fair for anyone if there is any
        
    }
}