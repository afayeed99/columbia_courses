Abdul Fayeed Abdul Kadir
aa5042
March 22nd, 2024 (Friday)

Resources: Some of the codes were inspired from the following
websites - 
a) https://stackoverflow.com/questions/3911966/
    how-to-convert-number-to-words-in-java
b) https://stackoverflow.com/questions/39557701/
    shuffle-a-deck-of-cards-in-java

Card.java
This program implements a card with a suit and a rank.
A card object can be instantiated by calling the class
Card(int suit, int rank). The suit ranges from 1-4 for 
Clubs, Diamonds, Hearts, and Spades respectively, and rank
ranges from 1-13, with 1 - Ace, 11 - Jack, 12 - Queen, and
13 - King. 

The Card class has multiple methods that can be accessed by user.
1) compareTo(Card c) - compare the card in reference to another 
                    Card c, and will return 0, 1, or -1, if
                    the reference card is the same, bigger, or
                    smaller than card c respectively.
2) toString() - return the name of the card in String.
3) getSuit() - return the int of the card's suit.
4) getRank() - return the int of the card's rank.

Deck.java
This program creates a deck of 52 cards.
The Deck class has multiple methods that can be accessed by user.
1) shuffle() - this shuffle the cards in the deck of 52 cards
2) deal() - this return the top most card on the deck. If the last
            card in the deck has been reached, the whole deck will
            be shuffled and will return the top most card again. 
3) toString() - returns the name of cards in the whole deck when
                the object is called and printed.

DeckTest.java
This is a tester class for Deck.java and Card.java class.
Firstly, it tests if the whole deck can be printed as String names.
Secondly, the deck is shuffled and the whole deck is again printed as
String names. If the shuffle works, the returned deck should be different.
Lastly, two cards were dealt, and should expect two different cards,
based on the algorithms that have been implemented. Then, the two cards
will be compared.

