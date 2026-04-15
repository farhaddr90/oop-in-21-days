package com.dorri.week1.page381;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckPile {
    private int index;

    public DeckPile() {
    }

    private List<Card> cards = new ArrayList<Card>();

    public void addCard(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealUp() {
        Card card = cards.get(index);
        card.faceUp();
        index++;
        return card;
    }

    public Card dealDown() {
        Card card = cards.get(index);
        card.faceDown();
        index++;
        return card;
    }
}
