package com.dorri;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean bust() {
        return total() > 21;
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

        while (total > 21 && aceCount > 0) {
            total -= 10; // converts one Ace from 11 to 1
            aceCount--;
        }

        return total;
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
