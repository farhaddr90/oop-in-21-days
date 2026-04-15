package com.dorri.week1.page381;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards = new ArrayList<>();

    public Deck() {
    }

    public void buildCards() {
        Card.Suit[] suits = Card.Suit.values();
        Card.Rank[] ranks = Card.Rank.values();
        for (Card.Suit suit : suits) {
            for (Card.Rank rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addCardsToPile(DeckPile pile) {
        pile.addCard(cards);
    }
}
