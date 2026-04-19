package com.dorri;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private final String name;
    private final Hand hand;
    private final List<PlayerListener> listeners = new ArrayList<>();

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    protected abstract boolean hit();

    protected void notifyListeners() {
        for (PlayerListener listener : listeners) {
            listener.handChanged(this);
        }
    }

    public void addCard(Card card) {
        hand.addCard(card);
        notifyListeners();
    }

    public void addListener(PlayerListener listener) {
        listeners.add(listener);
    }

    public boolean isBusted() {
        return hand.bust();
    }

    public boolean isBlackjack() {
        return hand.blackjack();
    }

    protected String getName() {
        return name;
    }

    protected Hand getHand() {
        return hand;
    }

    public void play(Dealer dealer) {
        while (!isBusted() && !isBlackjack() && hit()) {
            dealer.hit(this);
        }
        stopPlay(dealer);
    }

    protected void stopPlay(Dealer dealer) {
        dealer.passTurn();
    }

    @Override
    public String toString() {
        return name + " " + hand;
    }
}
