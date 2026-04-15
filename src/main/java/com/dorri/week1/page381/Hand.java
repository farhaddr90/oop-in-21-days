package com.dorri.week1.page381;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<Card>();
    private static final int BLACKJACK = 21;

    public void addCard(Card card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public int total() {
        int total = 0;
        for (Card card : cards) {
            total += card.getRank().getValue();
        }
        return total;
    }

    public boolean busted() {
        return total() > BLACKJACK;
    }

    public void turnOver() {
        for (Card card : cards) {
            card.faceUp();
        }
    }
}
