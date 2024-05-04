/*
* This program implements a deck of 52 cards.
*
* Abdul Fayeed Abdul Kadir
* aa5042
* March 22nd, 2024 (Friday)
*/

public class Deck {
	
    private Card[] cards;
    private int top; // the index of the top of the deck
	
    public Deck(){ // this is a constructor
        cards = new Card[52]; // empty array for now
        top = 0; // for now, idx top of card

        int index = 0; // index of the deck
        for (int rank = 1; rank <= 13; rank++){ // ranks
            for (int suit = 1; suit <= 4; suit++){ // suits
                Card oneCard = new Card(suit,rank);
                cards[index] = oneCard;
                index++;
            }
        }
    }
	
    public void shuffle(){
        for (int k = 0; k < 1000; k++){ 
            // we can do this thousand of times
            // j will not depend on i, but, just 52
            int j = (int) (Math.random() * (52));//[0,52)
            int i = (int) (Math.random() * (52));//[0,52)
            // generate random idx b/n 0 and i (inclusive)
            Card temp = cards[i]; // keep card i
            cards[i] = cards[j]; // replace card i with card j
            cards[j] = temp; // put ori card i to old card j pos
        }
    }
    
    public Card deal(){
        Card topCard = cards[top];
        top++; // if top = 52, will go into if statement
        if (top > 52){ // reached end of card
            shuffle(); // restart game, reshuffle
            top = 0; // back to start
        }
        return topCard;
    }
	
    public String toString(){
        // this method is automatically invoked when the object is printed
        // See DeckTest.java for more
        Card checkCard;
        String wholeDeck = "";
        String name = "";

        for (int i = 0; i < cards.length; i++){
            // will loop through entire deck
            checkCard = cards[i];
            name = checkCard.toString();
            wholeDeck += name + "\n";
        }
        return wholeDeck;
    }
}
