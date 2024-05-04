/********************************************
* DeckTest class
* This class is meant to test that the features
* of the Deck and Card classes are implemented
* correctly
**********************************************/

public class DeckTest{
	
    public static void main(String[] args){
        Deck d = new Deck();
        System.out.println("The Deck:");
        System.out.println(d);
        // This simply means print(d.toString())

        System.out.println("************************\n\n");
        System.out.println("************************\n\n");

        d.shuffle();

        System.out.println("The Deck Shuffled:");
        System.out.println(d);

        System.out.println("************************\n\n");
        System.out.println("************************\n\n");

        Card c1 = d.deal();
        Card c2 = d.deal();
        System.out.println("First two cards:");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("CompareTo returns: " + c1.compareTo(c2));

        /* To test the rest of the compareTo methods
            // Card as = new Card(4,1); // ace spade (suit,rank)
            // Card ac = new Card(1,1); // ace Clubs
            // Card d2 = new Card(2,2); // diamond 2
            // Card c2 = new Card(1,2); // club 2
            // Card c3 = new Card(1,3); // club 3
            // System.out.println("CompareTo returns: " + as.compareTo(ac));
        */
   }

}
