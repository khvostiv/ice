package cardgame;

public class Card {

    // Enum for Suit
    public enum Suit {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    // Enum for Value
    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private Value value;
    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {return this.value;}

    public void setValue(Value value) {this.value = value;}

    public Suit getSuit() {return this.suit;}

    public void setSuit(Suit suit) {this.suit = suit;}

//    @Override
//    public abstract String toString();

}

