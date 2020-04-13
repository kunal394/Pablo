package com.example.pablo.model.game;

import com.example.pablo.model.hands.PokerHand;

import java.util.ArrayList;

public class Player {

    private int id;

    private PlayerHand hand;

    private PlayerProfile profile;

    private ArrayList<PokerHand> previouslyCalledPokerHands;

    public Player(int id) {
        this.id = id;
    }

    public Player(PlayerProfile profile) {
        this.id = profile.getId();
        this.profile = profile;
    }

    public void addToCallStack(PokerHand pokerHand) {
        if (previouslyCalledPokerHands == null) {
            previouslyCalledPokerHands = new ArrayList<>();
        }
        previouslyCalledPokerHands.add(pokerHand);
    }

    public int getId() {
        return id;
    }

    public PlayerHand getHand() {
        return hand;
    }

    public void setHand(PlayerHand hand) {
        this.hand = hand;
    }

    public PlayerProfile getProfile() {
        return profile;
    }

    public ArrayList<PokerHand> getPreviouslyCalledPokerHands() {
        return previouslyCalledPokerHands;
    }
}
