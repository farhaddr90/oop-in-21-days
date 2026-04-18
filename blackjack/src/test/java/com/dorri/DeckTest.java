package com.dorri;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeckTest {

    @Test
    void addCardsToStack() {
        Deck deck = new Deck();
        DeckPile pile = new DeckPile();

        deck.addCardsToStack(pile);

        Set<String> seenCards = new HashSet<>();

        // deal all 52 cards
        for (int i = 0; i < 52; i++) {
            Card card = pile.dealUp();

            String key = card.getRank() + "-" + card.getSuit();

            // ensure no duplicates
            assertTrue(seenCards.add(key), "Duplicate card: " + key);
        }

        // ensure we got exactly 52 unique cards
        assertEquals(52, seenCards.size());
    }
}