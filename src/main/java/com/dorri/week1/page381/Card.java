package com.dorri.week1.page381;

public class Card {

    private boolean faceUp;
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public enum Suit {
        DIAMOND("♦"),
        HEART("♥"),
        CLUB("♣"),
        SPADE("♠");

        private final String symbol;

        Suit(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public enum Rank {
        Ace("Ace", 1),
        Two("2", 2),
        Three("3", 3),
        Four("4", 4),
        Five("5", 5),
        Six("6", 6),
        Seven("7", 7),
        Eight("8", 8),
        Nine("9", 9),
        Ten("10", 10),
        Jack("Jack", 10),
        Queen("Queen", 10),
        King("King", 10);

        private final String rank;
        private final int value;

        Rank(String rank, int value) {
            this.rank = rank;
            this.value = value;
        }

        public String getRank() {
            return rank;
        }

        public int getValue() {
            return value;
        }
    }

    public void faceUp() {
        this.faceUp = true;
    }

    public void faceDown() {
        this.faceUp = false;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        String result;
        if (isFaceUp()) {
            result = "(%s%s)".formatted(getRank().getRank(), getSuit().getSymbol());
        } else {
            result = "(card)";
        }
        return result;
    }
}
