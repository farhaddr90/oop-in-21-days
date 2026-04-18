package com.dorri;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        buildCards();
    }

    private void buildCards() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void addCardsToStack(DeckPile deckPile) {
        deckPile.addCards(cards);
    }
}
