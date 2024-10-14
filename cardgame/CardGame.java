/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
package cardgame;
import durakcardgame.Card;
import java.util.Random;
import java.util.Scanner;

public class CardGame {

    /**
     * @param args the command line arguments
     */
        // TODO code application logic here
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Card[] hand = generateHand(7);
            Random random = new Random();

            for (int i = 0; i < hand.length; i++) {

              // Get a random value
              Value value = Card.Value.values()[random.nextInt(13)];

              // Get a random suit
              Suit suit = Card.Suit.values()[random.nextInt(4)];

              // Create a new Card and add it to the hand
              Card card = new Card(value, suit);
              hand[i] = card;
            }
            
            System.out.println("Here are the cards in the hand");
            for (Card card : hand) {
                System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
            }

            System.out.println("Pick a suit for your card:");
            for (int i = 0; i < Card.Suit.values().length; i++) {
                System.out.println((i + 1) + ": " + Card.Suit.values()[i]);
            }
            int suitPosition = input.nextInt() - 1;

            
            System.out.println("Enter a value:");
            for (int i = 0; i < Card.Value.values().length; i++) {
                System.out.println((i + 1) + ": " + Card.Value.values()[i]);
            }
            int valuePosition = input.nextInt() - 1;

            Card userGuess = new Card(Card.Value.values()[valuePosition], Card.Suit.values()[suitPosition]);

            // Now check for a match
            boolean match = false;
            for (Card card : hand) {
                if (card.getValue() == userGuess.getValue()
                    && card.getSuit() == userGuess.getSuit()) {
                    match = true;
                    break;
                }
            }

            // Use ternary operator
            String response = match ? "You guessed it right!" : "Sorry no match...";
            System.out.println(response);



            // Print each card so we can see what was generated
            for (Card card : hand) {
                System.out.println(card.getValue() + " of " + card.getSuit());
            }

            // Ask user for a Card
            System.out.println("Please choose a suit for your lucky card:");
            for (int i = 0; i < Card.SUITS.length; i++) {
                System.out.println((i + 1) + ": " + Card.SUITS[i]);
            }

            int suit = input.nextInt();
            System.out.println("Enter a value (1 to 13)");
            int value = input.nextInt();

            // Create new Card with the two values chosen
            Card userGuess = new Card(value, Card.SUITS[suit - 1]);

            // Optionally print the user's chosen card
            System.out.println("You chose: " + userGuess.getValue() + " of " + userGuess.getSuit());

            // Check if it matches
            boolean match = false;
            for (Card card : hand) {
                if (card.getValue() == userGuess.getValue() &&
                    card.getSuit().equals(userGuess.getSuit())) {
                    match = true;
                    break;  // Exit loop once a match is found
                }
            }

            System.out.println("Did you guess it? " + match);



        }
        public static Card[] generateHand(int numCards) {
            Card[] hand = new Card[numCards];
            Random random = new Random();

            for (int i = 0; i < hand.length; i++) {
                int numValues = Card.Value.values().length;
                Card.Value value = Card.Value.values()[random.nextInt(numValues)];

                int numSuits = Card.Suit.values().length;
                Card.Suit suit = Card.Suit.values()[random.nextInt(numSuits)];

                Card card = new Card(value, suit);
                hand[i] = card;
            }

            return hand;
        }

    
}


//Christian made