/*
* This program implements the game of Video Poker.
*
* Abdul Fayeed Abdul Kadir
* aa5042
* March 29th, 2024 (Friday)
*/

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class Game {
	
    private Player p;
    private Deck cards;
    private ArrayList<Card> hand;
	
    /************** Constructor 1 **************/
    public Game(String[] testHand){
        hand = new ArrayList<Card>();
        for (int i = 0; i < testHand.length; i++){
            String suitLet = testHand[i].substring(0,1); // first letter

            int rank = Integer.parseInt(testHand[i].substring(1));
            int suit = convertSuitToNum(suitLet);
            Card currentCard = new Card(suit,rank);
            hand.add(currentCard);
        }			
    }

    /************** Constructor 2 **************/
    public Game(){
        cards = new Deck(); // automatically set 52 cards class Card
        p = new Player();
        hand = new ArrayList<Card>(); // arraylist of 5 cards...
        cards.shuffle(); // shuffle the deck before start playing here
    }
    /*************************** End of Constructor **************************/
    /*************************************************************************/

    /*************************************************************************/
    /******************** Interactive Play / Check Testhand ******************/

    public void play(){
        boolean keepPlaying = true; int round = 1;
        System.out.println("****************************************");
        System.out.println("Welcome to Video Poker!");

        while (keepPlaying){
            int betNow = askBet();
            if (p.getBankroll() < betNow){ // balance > 0, but balance < bet
                System.out.print("Not enough money! ");
                System.out.println("Balance left: " + p.getBankroll());
                continue; // can still play, but re-input bet
            }
            else if (p.getBankroll() >= betNow){// beginning each round
                System.out.println("****************************************");
                System.out.println("Round " + round + " begins.");
            }
            showHand(betNow);
            if (p.getBankroll() <= 0){
                System.out.println("Insufficient balance! End of Game.");
                keepPlaying = false; // Exit immediately
                continue;
            }
            else{keepPlaying = anotherRound();} round++; 
            System.out.println(); cards.shuffle(); // reshuffle, top = 0
        }
        System.out.println("Thank you for playing Video Poker!");
    }

    public void testPlay(){
        System.out.println("****************************************");
        Collections.sort(hand);
        System.out.println("Current Hand: ");
        displayCard();
        int tokenNow = checkHand();
    }

    /************************** End of Play Method ***************************/
    /*************************************************************************/

    /*************************************************************************/
    /************* Private methods below for play methods above **************/

    private int convertSuitToNum(String suitLet){
        int suit = 0;
        if (suitLet.equals("s")){suit = 4;}
        else if (suitLet.equals("h")){suit = 3;}
        else if (suitLet.equals("d")){suit = 2;}
        else if (suitLet.equals("c")){suit = 1;}
        return suit;
    }
	
    private void freshHand(){
        hand = new ArrayList<Card>(); // reinitialize everytime called
        int MAX_CARD = 5; // per hand
        for (int i = 0; i < MAX_CARD; i++){
            Card newCard = cards.deal();
            hand.add(newCard); // the hand now will have 5 cards
        }
    }

    private void displayCard(){
        for (int i = 0; i < hand.size(); i++){
            Card currentCard = hand.get(i);
            System.out.println(i + 1 + " - " + currentCard.toString());
        }
    }
    
    private int replacingCard(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many cards do you wish to replace? ");
        int numReplace = input.nextInt();
        input.nextLine(); // to consume the next line
        ArrayList<Integer> replace = new ArrayList<Integer>();
        if (numReplace > 0 && numReplace <= 5){ // replace at least 1, max 5
            System.out.print((numReplace == 1) ? 
            "Which card you wish to replace? " : // if more than 1, ask "first"
            "Which card you wish to replace first? ");
            
            for (int i = 0; i < numReplace; i++){
                if (i > 0) { // if replace more than 1 card, ask "next"
                    System.out.print("Which card to replace next? ");
                }
                replace.add(input.nextInt());
                input.nextLine();
            }
        }

        for (int j = 0; j < replace.size(); j++){
            Card replacementCard = cards.deal();
            // -1 cuz user input position 1-5 not 0-4
            hand.set(replace.get(j) - 1, replacementCard);
            // change the original position of the hand, with a new Card
            // the original position is set by the user
        }
        return numReplace;
    }

    private boolean anotherRound(){
        Scanner input = new Scanner(System.in);
        System.out.print("Keep Playing? Enter \"q\" to quit. " +
                        "Enter anything to keep playing: ");
        String response = input.nextLine();
        if (response.equals("q")){
            return false;
        }
        return true;

    }

    private int askBet(){
        Scanner input = new Scanner(System.in);
        int betNow;
        do{
            System.out.print("Enter your bet (1 - 5): ");
            while (!input.hasNextInt()) { // if not integer
                System.out.println("Invalid input! " +
                "Please enter an integer between 1 and 5 inclusive.");
                input.next(); // Consume invalid input
                System.out.print("Enter your bet (1 - 5): ");
            }
            // will escape the while loop above if it's an integer
            betNow = input.nextInt();
            input.nextLine(); // Consume newline
            if (betNow < 1 || betNow > 5) {
                System.out.println("Invalid input! " +
                "Please enter an integer between 1 and 5 inclusive.");
            }
        } 
        while (betNow < 1 || betNow > 5);
        return betNow;
    }

    private void showHand(int betNow){
        p.bets(betNow);
        System.out.print("You bet " + betNow + ". ");
        System.out.println("Current balance: " + p.getBankroll());
        freshHand(); // get fresh hand every round

        Collections.sort(hand); // sort the hand all the time
        System.out.println("Original Hand: ");
        displayCard(); int replace = replacingCard(); 
        System.out.println();
        if (replace != 0){ // if not replacement, skip this
            Collections.sort(hand); // sort again after replacement
            System.out.println("New Hand after replacement(s): ");
            displayCard();
        }
        // here will evaluate the final hand
        int tokenNow = checkHand();
        p.winnings(tokenNow); System.out.println();
        System.out.println("Your current token balance: " 
                            + p.getBankroll());
    }

    /********** End of Private methods below for play methods above **********/
    /*************************************************************************/

    /*************************************************************************/
    /*************** All codes below are for checking the hand ***************/
	public int checkHand(){
        int payoff; // for now
        if (checkRoyalFlush()){payoff = 250;}
        else if (checkStraightFlush()){payoff = 50;}
        else if (checkFourKind()){payoff = 25;}
        else if (checkFullHouse()){payoff = 6;}
        else if (checkFlush()){payoff = 5;}
        else if (checkStraight()){payoff = 4;}
        else if (checkThreeKind()){payoff = 3;}
        else if (checkTwoPairs()){payoff = 2;}
        else if (checkOnePair()){payoff = 1;}
        else{payoff = 0;} // nothing

        displayWinningMessage(payoff);
		return payoff; 
    }

    private void displayWinningMessage(int payoff){
        switch (payoff){
            case 250:
                System.out.println("Royal Flush! Payout = 250 tokens.");
                break;
            case 50:
                System.out.println("Straight Flush! Payout = 50 tokens.");
                break;
            case 25:
                System.out.println("Four of a Kind! Payout = 25 tokens.");
                break;
            case 6:
                System.out.println("Full House! Payout = 6 tokens.");
                break;
            case 5:
                System.out.println("Flush! Payout = 5 tokens.");
                break;
            case 4:
                System.out.println("Straight! Payout = 4 tokens.");
                break;
            case 3:
                System.out.println("Three of a Kind! Payout = 3 tokens.");
                break;
            case 2:
                System.out.println("Two Pairs! Payout = 2 tokens.");
                break;
            case 1:
                System.out.println("One Pair! Payout = 1 token.");
                break;
            default:
                System.out.println("No winning hand! Payout = 0 token.");
        }
    }

    private boolean checkOnePair(){
        boolean case1; // x x a b c
        boolean case2; // a x x b c
        boolean case3; // a b x x c
        boolean case4; // a b c x x

        case1 = hand.get(0).getRank() == hand.get(1).getRank();
        case2 = hand.get(1).getRank() == hand.get(2).getRank();
        case3 = hand.get(2).getRank() == hand.get(3).getRank();
        case4 = hand.get(3).getRank() == hand.get(4).getRank();

        boolean result = (case1 || case2 || case3 || case4); 
        // either case works
        return result;

    }

    private boolean checkTwoPairs(){
        boolean case1; // x x y y z
        boolean case2; // x x y z z
        boolean case3; // x y y z z 

        case1 = hand.get(0).getRank() == hand.get(1).getRank() &&
                hand.get(2).getRank() == hand.get(3).getRank();
        case2 = hand.get(0).getRank() == hand.get(1).getRank() &&
                hand.get(3).getRank() == hand.get(4).getRank();
        case3 = hand.get(1).getRank() == hand.get(2).getRank() &&
                hand.get(3).getRank() == hand.get(4).getRank();

        boolean result = (case1 || case2 || case3); // either case works
        return result;
    }

    private boolean checkThreeKind(){
        boolean case1; // x x x y z, x < y < z
        boolean case2; // x y y y z, x < y < z
        boolean case3; // x y z z z, x < y < z

        case1 = hand.get(0).getRank() == hand.get(2).getRank();
        case2 = hand.get(1).getRank() == hand.get(3).getRank();
        case3 = hand.get(2).getRank() == hand.get(4).getRank();

        boolean result = (case1 || case2 || case3); // either case works
        return result;

    }

    private boolean checkFullHouse(){
        boolean case1; // x x x y y, x < y
        boolean case2; // x x y y y, x < y

        case1 = hand.get(0).getRank() == hand.get(2).getRank() &&
                hand.get(3).getRank() == hand.get(4).getRank();
        // return true if 1st == 3rd card AND 4th card == 5th
        // automatically means three x, two y
        case2 = hand.get(0).getRank() == hand.get(1).getRank() &&
                hand.get(2).getRank() == hand.get(4).getRank();
        // return true if 1st == 2nd card AND 3rd card == 5th
        // automatically means two x, three y
        boolean result = (case1 || case2); // either case works
        return result;
    }

    private boolean checkFourKind(){
        boolean case1; // x x x x y, x < y
        boolean case2; // x y y y y, x < y

        case1 = hand.get(0).getRank() == hand.get(3).getRank();
        // return true if first card == 4th card
        // automatically means there is a 4-of-kind
        case2 = hand.get(1).getRank() == hand.get(4).getRank();
        // return true if 2nd card == 5th card
        // // automatically means there is a 4-of-kind
        boolean result = (case1 || case2); // either case works
        return result;
    }
	

    private boolean checkStraightAceExists(){
        int[] case1 = {2,3,4,5}; // A 2 3 4 5
        int[] case2 = {10,11,12,13}; //  10 J Q K A
        Card firstCard = hand.get(0);
        int firstRank = firstCard.getRank();
        for (int i = 0; i < hand.size() - 1; i++){ // ignore last card
            Card currentCard = hand.get(i);
            int currentRank = currentCard.getRank();
            if (firstRank == 2){ // check for case 1
                if (currentRank != case1[i]){
                    return false;
                }
            }
            else if (firstRank == 10){ // check for case 2
                if (currentRank != case2[i]){
                    return false;
                }
            }
            else{ // not either case
                return false;
            }
        }
        // didnt obey any of the above, automatically a straight
        return true;
    }

    private boolean checkStraightFlush(){
        if (checkFlush() && checkStraight()){
            // only if both true
            return true;
        }
        return false;
    }

    private boolean checkRoyalFlush(){
        Card firstCard = hand.get(0);
        int firstRank = firstCard.getRank();
        if (firstRank == 10 && checkStraightFlush()){
            return true;
        }
        return false;
    }

    private boolean checkFlush(){
        Card firstCard = hand.get(0);
        int firstSuit = firstCard.getSuit();
        for (int i = 1; i < hand.size(); i++){
            Card currentCard = hand.get(i);
            int currentSuit = currentCard.getSuit();

            if (firstSuit != currentSuit){
                return false;
            }
        }
        return true;
    }

    private boolean checkStraight(){
        // first check if there is any ace;
        // if none, do normal straight check

        Card currentCard = hand.get(0);
        int currentRank = currentCard.getRank(); // 2

        Card lastCard = hand.get(hand.size() - 1);
        int lastRank = lastCard.getRank();

        if (lastRank == 1){ // if last card is an Ace
            return checkStraightAceExists();
        }
        else{
            for (int i = 1; i < hand.size(); i++){
                currentCard = hand.get(i); // get the next card 
                if (currentCard.getRank() != currentRank + 1){ 
                    return false; 
                    // return immediately, 
                    // don't care to evaluate the rest of card
                }
                currentRank++;                                  
                // will increment if the if statement 
                // above never been entered
            }
            return true; 
            // will return true if the if statement never been entered
            // indicating that the hand is a straight
        }
    }
}
