package com.dorri;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> cards = new ArrayList<>();
    private static final int BLACKJACK = 21;

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean bust() {
        return total() > BLACKJACK;
    }

    public boolean blackjack() {
        return total() == BLACKJACK;
    }

    public int total() {
        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            total += card.getPoints();

            if (card.getRank() == Card.Rank.ACE) {
                aceCount++;
            }
        }

        while (total > BLACKJACK && aceCount > 0) {
            total -= 10; // converts one Ace from 11 to 1
            aceCount--;
        }

        return total;
    }

    public void turnOver() {
        for (Card card : cards) {
            card.faceUp();
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("{");
        for (Card card : cards) {
            sb.append(card).append(",");
        }
        sb.delete(sb.length() - 1, sb.length()).append("}");
        return sb.toString();
    }
}
