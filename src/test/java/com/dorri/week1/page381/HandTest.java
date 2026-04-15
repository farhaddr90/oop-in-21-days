package com.dorri.week1.page381;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class HandTest {

    Card card1 = new Card(Card.Suit.CLUB, Card.Rank.Ace);
    Card card8 = new Card(Card.Suit.CLUB, Card.Rank.Eight);
    Card card9 = new Card(Card.Suit.CLUB, Card.Rank.Nine);
    Card card5 = new Card(Card.Suit.CLUB, Card.Rank.Five);
    Card cardJ = new Card(Card.Suit.CLUB, Card.Rank.Jack);

    Hand busted = new Hand();
    Hand hand = new Hand();

    @BeforeEach
    void setup() {
        busted.addCard(cardJ);
        busted.addCard(card9);
        busted.addCard(card8);

        hand.addCard(card1);
        hand.addCard(card5);
        hand.addCard(card8);
    }

    @Test
    void addCard() {
        Assertions.assertEquals(3, busted.size());
    }

    @Test
    void total() {
        Assertions.assertEquals(27, busted.total());
        Assertions.assertEquals(14, hand.total());
    }

    @Test
    void busted() {
        Assertions.assertTrue(busted.busted());
        Assertions.assertFalse(hand.busted());
    }
}