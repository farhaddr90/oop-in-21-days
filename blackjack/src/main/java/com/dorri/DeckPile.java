package com.dorri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckPile {

    private final List<Card> cards = new ArrayList<>();
    private int index = 0;

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public Card dealUp() {
        Card card = deal();
        if (card != null) {
            card.faceUp();
        }
        return card;
    }

    public Card dealDown() {
        Card card = deal();
        if (card != null) {
            card.faceDown();
        }
        return card;
    }

    private Card deal() {
        if (index < cards.size()) {
            return cards.get(index++);
        }
        return null;
    }

    public void shuffle(Random random) {
        Collections.shuffle(cards, random);
    }

    public void reset() {
        cards.clear();
        index = 0;
    }
}
