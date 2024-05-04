/*
* This program implements a card with suit and rank.
*
* Abdul Fayeed Abdul Kadir
* aa5042
* March 22nd, 2024 (Friday)
*/

public class Card implements Comparable<Card>{
	
    private int suit; // use integers 1-4 to encode the suit
    private int rank; //use integers 1-13 to encode the rank

    // An array to convert rank numbers to string numbers
    private String rankName[] = {
        "",
        "Ace",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Jack",
        "Queen",
        "King"
    };

    // An array to convert suits to string suits
    private String suitName[] = {
        "",
        "Clubs",
        "Diamonds",
        "Hearts",
        "Spades"
    };
	
    public Card(int s, int r){
        // make a card with suit s and rank r
        suit = s;
        rank = r;
    }
	
    public int compareTo(Card c){
        // use this method to compare cards so they 
        // may be easily sorted
        int returnVal; // for now
        if (this.rank == 1 || c.getRank() == 1){ // if card is an Ace
            returnVal = compareToAceExists(c);
        }
        else{
            returnVal = compareToOtherCards(c);
        }
        return returnVal;
    }

    private int compareToOtherCards(Card c){ // other cards than ace
        int val = 0; // default (if same card)
        if (this.rank > c.getRank()){
            val = 1;
        }
        else if (this.rank < c.getRank()){
            val = -1;
        }
        else if (this.rank == c.getRank()){
            if (this.suit > c.getSuit()){
                val = 1;
            }
            else if (this.suit < c.getSuit()){
                val = -1;
            }
        }
        return val;
    }
        
    private int compareToAceExists(Card c){
        int val = -10; // any number for now
        if (this.rank == 1 && c.getRank() == 1){ // if both Ace
            if (this.suit > c.getSuit()){
                val = 1;
            }
            else if (this.suit < c.getSuit()){
                val = -1;
            }
            else{
                val = 0; // same card (so won't go to other else)
            }
        }
        else if (this.rank == 1){ // if this card is Ace
            val = 1;
        }
        else if (c.getRank() == 1){ // if other card is Ace
            val = -1;
        }
        return val;
    }
    
    public String toString(){
        String name = "";

        name = rankName[rank] + " of " + suitName[suit];
        return name;
    }

	// Leave this method alone, it's to help us test your work
    public int getSuit(){
        return suit;
    }

    // Leave this method alone, it's to help us test your work
    public int getRank(){
        return rank;
    }
}
