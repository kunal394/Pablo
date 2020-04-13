package com.example.pablo.model.game;

import android.util.SparseArray;
import android.util.SparseIntArray;

import com.example.pablo.model.cards.CardsFactory;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("DanglingJavadoc")
public class GameState {

    private static GameState INSTANCE;

    private GameState() {

    }

    public static GameState getInstance() {
        if (INSTANCE == null) {
            synchronized (GameState.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GameState();
                }
            }
        }
        return INSTANCE;
    }

    private static boolean initDone = false;

    private SparseArray<Player> playersInGameMap = new SparseArray<>();

    private int dealerPlayerId;

    private int selfId;

    private int roundsPlayed;

    private SparseIntArray playerIdVsPlayerCardCount = new SparseIntArray();

    private SparseArray<Player> playerIdVsPlayers = new SparseArray<>();

    private ArrayList<Integer> randomCardIds;

    private ArrayList<Integer> playerIds;

    public void init(ArrayList<Player> players, int dealerPlayerId, int selfId) {
        initDone = true;
        this.dealerPlayerId = dealerPlayerId;
        this.selfId = selfId;
        setPlayerIds(players);
        initPlayersMap(players);
        roundsPlayed = 0;
        for (int i = 0; i < playerIds.size(); i++) {
            playerIdVsPlayerCardCount.put(playerIds.get(i), 2);
        }
    }

    public int getDealerPlayerId() {
        return dealerPlayerId;
    }

    public ArrayList<Integer> getPlayerIds() {
        return playerIds;
    }

    public void startGame() {
        if (!initDone) {
            throw new UnsupportedOperationException("Without initialization, startGame not allowed!");
        }
        distributeCards();
    }

    public PlayerHand getRandomCardIds(int playerId) {
        return playersInGameMap.get(playerId).getHand();
    }


    // TODO: 13-04-2020 only for single device mode testing
    public int getCurrentMovePlayerId() {
        int dealerIndex = playerIds.indexOf(dealerPlayerId);
        int index = (dealerIndex + roundsPlayed) % playerIds.size();
        return playerIds.get(index);
    }

    public Player getPlayer(int playerId) {
        return playersInGameMap.get(playerId);
    }

    public int getPlayerCardCount(int playerId) {
        return playerIdVsPlayerCardCount.get(playerId);
    }

    /********************************Private***************************************/
    /******************************^^^^^^^^^***************************************/
    /********************************Methods***************************************/

    private void setPlayerIds(ArrayList<Player> players) {
        // TODO IMPORTANT: players list should be in same order for all players, can be
        // maintained by sorting by game joining time of each player
        playerIds = new ArrayList<>();
        for (Player player : players) {
            int id = player.getId();
            playersInGameMap.put(id, player);
            playerIds.add(id);
        }
        int currentIndex = playerIds.indexOf(selfId);
        // circularly rotate the list to get the selfId on the 0th index
        Collections.rotate(playerIds, playerIds.size() - currentIndex);
    }

    private void initPlayersMap(ArrayList<Player> players) {
        for (Player player : players) {
            playerIdVsPlayers.put(player.getId(), player);
        }
    }

    private void updateCardCountForPlayer(int playerId) {
        int count = playerIdVsPlayerCardCount.get(playerId);
        playerIdVsPlayerCardCount.put(playerId, count + 1);
    }

    private void setDealerPlayerId(int dealerPlayerId) {
        this.dealerPlayerId = dealerPlayerId;
    }

    private void distributeCards() {
        randomCardIds = getRandomCardIdsForDistribution();
        divideCards();
    }

    private ArrayList<Integer> getRandomCardIdsForDistribution() {
        return CardsFactory.getInstance().getRandomCardIds(getNumOfCardsForCurrentRound());
    }

    private void divideCards() {
        for (int i = 0; i < playerIds.size(); i += playerIdVsPlayerCardCount.get(playerIds.get(i))) {
            Integer playerId = playerIds.get(i);
            Player player = playersInGameMap.get(playerId);
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
