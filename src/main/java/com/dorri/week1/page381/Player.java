package com.dorri.week1.page381;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private final String name;
    private final Hand hand;
    private final List<PlayerListener> listeners = new ArrayList<PlayerListener>();

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    protected abstract boolean hit();

    public void addListener(PlayerListener listener) {
        listeners.add(listener);
    }

    public void addCard(Card card) {
        hand.addCard(card);
        notifyListeners();
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    protected void notifyListeners() {
        for (PlayerListener listener : listeners) {
            listener.handChanged(this);
        }
    }

    public void play(Dealer dealer) {
        while (!isBusted() && hit()) {
            dealer.hit(this);
        }
        stopPlay(dealer);
    }

    protected void stopPlay(Dealer dealer) {
        dealer.passTurn();
    }

    public boolean isBusted() {
        return getHand().busted();
    }

    public void reset() {
        getHand().reset();
    }

    @Override
    public String toString() {
        return
                "name: '" + name + '\'' +
                ", hand: " + hand
                ;
    }
}
