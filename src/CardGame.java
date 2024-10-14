
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

public class CardGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Card[] hand = generateHand(7);  // Generate a hand of 7 cards
        Random random = new Random();

        // Display the generated hand
        System.out.println("Here are the cards in the hand:");
        for (Card card : hand) {
            System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
        }

        // Ask user to pick a suit
        System.out.println("Pick a suit for your card:");
        for (int i = 0; i < Card.Suit.values().length; i++) {
            System.out.println((i + 1) + ": " + Card.Suit.values()[i]);
        }
        int suitPosition = input.nextInt() - 1;

        // Ask user to pick a value
        System.out.println("Enter a value:");
        for (int i = 0; i < Card.Value.values().length; i++) {
            System.out.println((i + 1) + ": " + Card.Value.values()[i]);
        }
        int valuePosition = input.nextInt() - 1;

        // Create the user's guessed card
        Card userGuess = new Card(Card.Value.values()[valuePosition], Card.Suit.values()[suitPosition]);

        // Check if the guessed card matches any card in the hand
        boolean match = false;
        for (Card card : hand) {
            if (card.getValue() == userGuess.getValue() && card.getSuit() == userGuess.getSuit()) {
                match = true;
                break;
            }
        }

        // Display result
        String response = match ? "You guessed it right!" : "Sorry, no match...";
        System.out.println(response);
    }

    // Method to generate a hand of random cards
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
