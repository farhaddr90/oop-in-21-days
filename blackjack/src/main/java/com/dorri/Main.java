package com.dorri;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Console console = Console.INSTANCE;

        //######### Farhad the human player
        Hand farhadHand = new Hand();
        Player farhad = new HumanPlayer("Farhad", farhadHand);
        farhad.addListener(console);

        //######### Bob the human player
        Hand bobHand = new Hand();
        Player bob = new HumanPlayer("Bob", bobHand);
        bob.addListener(console);

        //######### Dealer
        DeckPile deckPile = new DeckPile();
        deckPile.reset();
        Deck deck = new Deck();
        for (int i = 0; i < 4; i++) {
            deckPile.shuffle(new Random());
            deck.addCardsToStack(deckPile);
            deckPile.shuffle(new Random());
        }
        Hand dealerHand = new Hand();
        BlackjackDealer dealer = new BlackjackDealer("Dealer", dealerHand, deckPile);
        dealer.addListener(console);
        dealer.addPlayer(farhad);
        dealer.addPlayer(bob);

        dealer.newGame();
    }
}