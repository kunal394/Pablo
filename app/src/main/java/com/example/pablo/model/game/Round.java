package com.example.pablo.model.game;

import android.util.SparseArray;
import android.util.SparseIntArray;

import com.example.pablo.model.cards.CardsFactory;
import com.example.pablo.model.hands.PokerHand;

import java.util.ArrayList;

public class Round {

    private int dealerPlayerId;

    private int roundsPlayed;

    private SparseIntArray playerIdVsPlayerCardCount = new SparseIntArray();

    private SparseArray<Player> playerIdVsPlayers = new SparseArray<>();

    private PokerHand latestCalledPokerHand;

    private ArrayList<Integer> randomCardIds;

    private ArrayList<Integer> playerIds;

    public Round(ArrayList<Integer> playerIds, int dealerId) {
        this.playerIds = playerIds;
        this.dealerPlayerId = dealerId;
    }

    public void init() {
        roundsPlayed = 0;

        // 1. Get cards to distribute
        randomCardIds = CardsFactory.getInstance().getRandomCardIds(getNumOfCardsForCurrentRound());

        // 2. Divide the cards to players
        for (int i = 0; i < playerIds.size(); i += 2) {
            playerIdVsPlayerCardCount.put(playerIds.get(i), 2);
        }
        divideCards();
    }

    public void setLatestCalledPokerHand(PokerHand latestCalledPokerHand) {
        this.latestCalledPokerHand = latestCalledPokerHand;
    }

    public void updateCardCountForPlayer(int playerId) {
        int count = playerIdVsPlayerCardCount.get(playerId);
        playerIdVsPlayerCardCount.put(playerId, count + 1);
    }

    public void setDealerPlayerId(int dealerPlayerId) {
        this.dealerPlayerId = dealerPlayerId;
    }

    private void divideCards() {
        for (int i = 0; i < playerIds.size(); i += playerIdVsPlayerCardCount.get(playerIds.get(i))) {
            Integer playerId = playerIds.get(i);
            Player player = new Player(playerId);
            int countOfCurrentPlayer = playerIdVsPlayerCardCount.get(playerId);
            PlayerHand playerHand = CardsFactory.getInstance().getPlayerHand(
                    randomCardIds.subList(i, countOfCurrentPlayer));
            player.setHand(playerHand);
            playerIdVsPlayers.put(playerId, player);
        }
    }

    private int getNumOfCardsForCurrentRound() {
        return playerIds.size() * 2 + roundsPlayed;
    }
}
