package com.dorri;

import java.util.ArrayList;
import java.util.List;

public class BlackjackDealer extends Player implements Dealer {

    private final DeckPile cards;
    private final List<Player> players = new ArrayList<>();
    private int playerIndex = 0;

    public BlackjackDealer(String name, Hand hand, DeckPile cards) {
        super(name, hand);
        this.cards = cards;
    }

    @Override
    protected boolean hit() {
        return getHand().total() < 17;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void hit(Player player) {
        player.addCard(cards.dealUp());
    }

    @Override
    public void passTurn() {
        if (playerIndex < players.size()) {
            Player player = players.get(playerIndex);
            playerIndex++;
            player.play(this);
        } else {
            this.play(this);
        }
    }

    private void deal() {
        for (Player player : players) {
            player.addCard(cards.dealUp());
        }
        addCard(cards.dealUp());
        for (Player player : players) {
            player.addCard(cards.dealUp());
        }
        addCard(cards.dealDown());
    }

    @Override
    protected void stopPlay(Dealer dealer) {
    }

    @Override
    public void play(Dealer dealer) {
        exposeCards();
        super.play(dealer);
    }

    private void exposeCards() {
        getHand().turnOver();
        notifyListeners();
    }

    public void newGame() {
        deal();
        passTurn();
    }
}
