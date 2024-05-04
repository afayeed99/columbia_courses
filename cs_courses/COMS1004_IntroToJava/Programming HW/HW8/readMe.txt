Abdul Fayeed Abdul Kadir
aa5042
March 29th, 2024

*******************************************************************************
Resources: Some of the codes were inspired from the following:
a) https://stackoverflow.com/questions/3911966/
    how-to-convert-number-to-words-in-java
b) https://stackoverflow.com/questions/39557701/
    shuffle-a-deck-of-cards-in-java
c) https://www.cs.emory.edu/~cheung/Courses/170/Syllabus/10/pokerCheck.html
d) do while loop - read in Zybook, but not covered in lecture
e) continue statement - similar to Python, figured should be the same in Java
f) case switch - similar to for loop, in Zybook, but not covered in lecture
g) conditional operator ? (similar to an if-else statement, but looks better)
    https://stackoverflow.com/questions/798545/
    what-is-the-java-operator-called-and-what-does-it-do

*******************************************************************************
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
                    smaller than card c respectively. This compareTo()
                    method assumes Ace as the largest rank, and 2
                    as the smallest rank. 
2) toString() - return the name of the card in String.
3) getSuit() - return the int of the card's suit.
4) getRank() - return the int of the card's rank.

*******************************************************************************
Deck.java
This program creates a deck of 52 cards.
The Deck class has multiple methods that can be accessed by user.
1) shuffle() - shuffle the cards in the deck of 52 cards. It
                will also reinitialize the position of the top card,
                which will be relevant when dealing the card,
                in deal() method.
2) deal() - return the top most card on the deck. When the method is called
            again, it will return the next card in the deck. If the last
            card in the deck has been reached, the whole deck will
            be shuffled (will only happen if the entire deck has been
            reached per session, which might not happen, but good to have).
3) toString() - returns the name of cards in the whole deck when
                the object is called and printed.

*******************************************************************************
Player.java
This program implements the player role of the Video Poker game.
When a Player class is instantiated, the player object will start with
a balance of 50 in the bankroll. The bet is set to 0 at the beginning
of each game. 
The Player class has several methods that can be accessed by user.
1) bets(int amt) - the int amt will be the bet set by the user, and
            the same amount will be deducted from the bankroll, at the
            beginning of each round before the hand is shown.
2) winnings(int odds) - the int odds will be multiplied with the bet
            that was set prior, and will be added to the bankroll.
            The int odds will depend on whatever hand card the user has
            for each round (can range from 0 to 250).
3) getBankroll() - when called, this will return the current balance
                    in the bankroll.

*******************************************************************************
Game.java
This program implements the game of Video Poker.
The game has two constructors, where one will be an Interactive
game with the user, and the other will be for checking purposes; 
to check if the Game class is implemented correctly.

To check if the Game class is implemented correctly,
when the class PokerTest is compiled, a list of 5 cards should
be supplied together in the form: "s3 s4 d2 h9 c1", where the letter 
represents suit of each card (s - spade, d - diamond, c - club, h - hearts),
and the number represents the rank of each card.

A method accompanies this constructor is the testPlay() method.
This method will sort the hand provided, and the sorted hand
will be displayed on the terminal. It will also display the
type of hand (if any) and the payout associated with the hand.

The play() method is responsible for the interactive portion 
of the game. It first welcomes the user to the game, and will ask
for the amount of bet the user wants to place for the particular
round. If the user has a positive balance in the bank, but not enough
to place the desired bet, the program will ask the user to replace
a smaller bet. If there is an insufficient balance in the bank,
the game will end immediately. If invalid user input, the program
will ask for user to reinput a valid bet.

The bet has to be between int 1 and 5 (inclusive) and with enough
balance in the bank, the game begins. A sorted hand consisting
of 5 cards will be displayed to the user, and user will have a 
choice to replace the hand, and if so, by how many cards and which. 
After replacing the cards (if any), a new sorted set of hand 
will be displayed to the user. The hand will be evaluated and
the type of hand will be displayed to the user, with the amount
of payoff associated with the hand (if any). Then, the balance
in the user's bank will be adjusted accordingly. 

At the end of the round, the program will ask if the user wish
to play again (type anything for another round, or "q" to quit).
The entire deck will be shuffled, and the game will resume/end,
according to user's choice. The balance will also be displayed to user.
If the user wish to quit, a thank you statement will be displayed 
to the screen, marks the end of the game.

*******************************************************************************
PokerTest.java
This program is a test class for the Game class.
It tests the class in two ways: 
1) by inputting directly a set of hand,
    to check if the hand can be evaluated properly. 
2) by employing an interactive game with the user 