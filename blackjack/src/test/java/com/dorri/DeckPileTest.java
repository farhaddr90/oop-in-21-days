package com.dorri;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DeckPileTest {

    @Test
    void addCards() {
    }

    @Test
    void dealUp() {
    }

    @Test
    void dealDown() {
    }

    @Test
    void shuffle() {

        Deck deck = new Deck();
        DeckPile pile = new DeckPile();

        deck.addCardsToStack(pile);

        pile.shuffle(new Random(42));

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            Card c = pile.dealUp();
            String key = c.toString();
            result.add(key);
        }

        // expected order based on seed
        List<String> expected = List.of(
                "4♦",
                "2♠",
                "10♣",
                "J♣",
                "8♣",
                "3♥",
                "10♦",
                "6♥",
                "10♠",
                "A♦",
                "5♥",
                "6♦",
                "5♦",
                "3♣",
                "2♦",
                "4♥",
                "9♣",
                "J♦",
                "3♦",
                "Q♥",
                "4♠",
                "Q♠",
                "K♥",
                "4♣",
                "3♠",
                "A♥",
                "2♥",
                "9♥",
                "8♦",
                "K♣",
                "10♥",
                "5♣",
                "9♠",
                "Q♦",
                "K♠",
                "K♦",
                "J♥",
                "A♠",
                "8♥",
                "Q♣",
                "6♣",
                "5♠",
                "7♠",
                "6♠",
                "A♣",
                "7♥",
                "9♦",
                "7♦",
                "7♣",
                "J♠",
                "8♠",
                "2♣"
        );

        assertEquals(expected, result);

    }

    @Test
    void reset() {
    }
}