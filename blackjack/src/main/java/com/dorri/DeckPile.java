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
        Card card = cards.get(index++);
        card.faceUp();
        return card;
    }

    public Card dealDown() {
        Card card = cards.get(index++);
        card.faceDown();
        return card;
    }

    public void shuffle(Random random) {
        Collections.shuffle(cards, random);
    }

    public void reset(){
        cards.clear();
        index = 0;
    }
}
