package com.dorri;

public class Card {
    private final Rank rank;
    private final Suit suit;
    private boolean faceUp;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void faceUp() {
        this.faceUp = true;
    }

    public void faceDown() {
        this.faceUp = false;
    }

    public enum Rank {
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 10),
        QUEEN("Q", 10),
        KING("K", 10),
        ACE("A", 11);

        private final String symbol;
        private final int points;

        Rank(String symbol, int points) {
            this.points = points;
            this.symbol = symbol;
        }
    }

    public enum Suit {
        HEARTS("♥"),
        DIAMONDS("♦"),
        CLUBS("♣"),
        SPADES("♠");
        private final String symbol;

        Suit(String symbol) {
            this.symbol = symbol;
        }
    }

    public int getPoints() {
        return rank.points;
    }

    public String toString() {
        if (isFaceUp()) {
            return this.rank.symbol + this.suit.symbol;
        }
        return "card";
    }
}
