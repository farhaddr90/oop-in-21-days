package com.dorri;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    @Test
    void emptyHandShouldHaveTotalZeroAndNotBust() {
        Hand hand = new Hand();

        assertEquals(0, hand.total());
        assertFalse(hand.bust());
    }

    @Test
    void shouldSumNormalCardsCorrectly() {
        Hand hand = new Hand();

        hand.addCard(new Card(Card.Rank.TEN, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Rank.SEVEN, Card.Suit.HEARTS));

        assertEquals(17, hand.total());
        assertFalse(hand.bust());
    }

    @Test
    void blackjackShouldEqual21() {
        Hand hand = new Hand();

        hand.addCard(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Rank.KING, Card.Suit.HEARTS));

        assertEquals(21, hand.total());
        assertFalse(hand.bust());
    }

    @Test
    void shouldBustWhenOver21WithoutAce() {
        Hand hand = new Hand();

        hand.addCard(new Card(Card.Rank.KING, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Rank.QUEEN, Card.Suit.HEARTS));
        hand.addCard(new Card(Card.Rank.TWO, Card.Suit.CLUBS));

        assertEquals(22, hand.total());
        assertTrue(hand.bust());
    }

    @Test
    void aceShouldAdjustFrom11To1WhenNeeded() {
        Hand hand = new Hand();

        hand.addCard(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Rank.KING, Card.Suit.HEARTS));
        hand.addCard(new Card(Card.Rank.NINE, Card.Suit.CLUBS));

        // 11 + 10 + 9 = 30 → Ace becomes 1 → 20
        assertEquals(20, hand.total());
        assertFalse(hand.bust());
    }

    @Test
    void multipleAcesShouldAdjustCorrectly() {
        Hand hand = new Hand();

        hand.addCard(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Rank.ACE, Card.Suit.HEARTS));
        hand.addCard(new Card(Card.Rank.NINE, Card.Suit.CLUBS));

        // 11 + 11 + 9 = 31 → adjust one Ace → 21
        assertEquals(21, hand.total());
        assertFalse(hand.bust());
    }

    @Test
    void manyAcesShouldStillWorkCorrectly() {
        Hand hand = new Hand();

        hand.addCard(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        hand.addCard(new Card(Card.Rank.ACE, Card.Suit.HEARTS));
        hand.addCard(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        hand.addCard(new Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS));

        // 11+11+11+8 = 41 → adjust two Aces → 21
        assertEquals(21, hand.total());
        assertFalse(hand.bust());
    }

}
