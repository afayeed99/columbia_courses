/*
* This program is a test class for the Video Poker Game.
*
* Abdul Fayeed Abdul Kadir
* aa5042
* March 29th, 2024 (Friday)
*/

public class PokerTest{

    // this class must remain unchanged
    // your code must work with this test class
 
    public static void main(String[] args){
        if (args.length<1){
            Game g = new Game();
            g.play();
        }
        else{
            Game g = new Game(args);
            g.testPlay();
        }
    }

    /* Testing all possible scenarios (all checked out):
        javac PokerTest.java && java PokerTest
        ROYAL FLUSH: s1 s13 s12 s11 s10
        STRAIGHT FLUSH: 1) d7 d4 d3 d5 d6 (other straight)
                        2) c5 c4 c3 c2 c1 (A 2 3 4 5)
                        3) h10 h12 h13 h11 h1 (10 J Q K A)
                        4) h2 h12 h13 h11 h1 (flush, not straight)
        4 OF A KIND: 1) c3 d3 s3 h3 s1
                     2) d2 c3 d3 s3 h3
        FULL HOUSE: 1) d5 h5 c5 h9 s9
                    2) c10 d10 d13 h13 c13

        FLUSH: d1 d5 d12 d10 d1
        STRAIGHT: 1) s3 d5 c4 c6 h7 (no Ace)
                  2) s1 s3 c4 d2 c5 (Ace in front)
                  3) d1 c13 s12 h11 d10 (Ace last)
                  4) d1 c13 s12 s3 d2 (check if it's not rollover)
        3 OF A KIND: 1) d5 h5 c5 h9 s10 (x x x y z)
                     2) d5 h5 c5 h3 s10 (x y y y z)
                     3) d5 h5 c5 h4 s2 (x y z z z)
        2 PAIRS: 1) d5 h5 c8 h8 s10 (x x y y z)
                 2) d5 h5 c8 h10 s10 (x x y z z)
                 3) d5 h8 c8 h10 s10 (x y y z z)
        1 PAIR: 1) d5 h5 c8 h13 s10 (x x a b c)
                2) d5 h5 c2 h13 s10 (a x x b c)
                3) d5 h5 c2 h3 s10 (a b x x c)
                4) d8 h8 c2 h3 s5 (a b c x x)
        NO PAIR: d5 h3 c8 h13 s10 

    */
}
