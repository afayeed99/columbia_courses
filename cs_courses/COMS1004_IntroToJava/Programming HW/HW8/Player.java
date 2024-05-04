/*
* This program implements the player role of Video Poker game.
*
* Abdul Fayeed Abdul Kadir
* aa5042
* March 29th, 2024 (Friday)
*/

public class Player {
	
    private int bankroll;
    private int bet;
		
    public Player(){		
        bankroll = 50; // starting tokens
        bet = 0; // for now
    }
		
    public void bets(int amt){
        bet = amt;
        bankroll -= bet; // reduce the amount bet for now
    }

    public void winnings(int odds){
        bet *= odds; // bet * payout
        bankroll += bet; // add to bankroll
    }

    public int getBankroll(){
        return bankroll;
    }

}


