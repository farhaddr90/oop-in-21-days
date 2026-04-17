package com.dorri.week1.page381;

public class Blackjack {
    public static void main(String[] args) {

        DeckPile pile = new DeckPile();
        for (int i = 0; i < 4; i++) {
            pile.shuffle();
            Deck deck = new Deck();
            deck.addCardsToPile(pile);
            pile.shuffle();
        }


        Hand dealerHand = new Hand();
        BlackjackDealer dealer = new BlackjackDealer("Dealer", dealerHand, pile);

        Hand playerHand1 = new Hand();
        Player player1 = new HumanPlayer("Player_1", playerHand1);

        Hand playerHand2 = new Hand();
        Player player2 = new HumanPlayer("Player_2", playerHand2);

        dealer.addPlayer(player1);
        dealer.addPlayer(player2);

        Console console = Console.INSTANCE;
        dealer.addListener(console);
        player1.addListener(console);
        player2.addListener(console);

        dealer.newGame();
    }
}
