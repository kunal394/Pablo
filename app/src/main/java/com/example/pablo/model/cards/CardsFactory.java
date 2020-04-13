package com.example.pablo.model.cards;

import com.example.pablo.R;
import com.example.pablo.model.game.PlayerHand;
import com.example.pablo.model.hands.Suite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("DanglingJavadoc")
public class CardsFactory {

    private static final int NO_OF_CARDS = 52;
    private static final int NO_OF_CARDS_IN_A_SUITE = 13;

    private static CardsFactory INSTANCE = null;

    private CardsFactory() {
    }

    public static CardsFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (CardsFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CardsFactory();
                }
            }
        }
        return INSTANCE;
    }

    private static ArrayList<Integer> cardsDrawableIds = new ArrayList<>(
            Arrays.asList(
                    R.drawable.ace_of_spades,
                    R.drawable.two_of_spades,
                    R.drawable.three_of_spades,
                    R.drawable.four_of_spades,
                    R.drawable.five_of_spades,
                    R.drawable.six_of_spades,
                    R.drawable.seven_of_spades,
                    R.drawable.eight_of_spades,
                    R.drawable.nine_of_spades,
                    R.drawable.ten_of_spades,
                    R.drawable.jack_of_spades,
                    R.drawable.queen_of_spades,
                    R.drawable.king_of_spades,
                    R.drawable.ace_of_clubs,
                    R.drawable.two_of_clubs,
                    R.drawable.three_of_clubs,
                    R.drawable.four_of_clubs,
                    R.drawable.five_of_clubs,
                    R.drawable.six_of_clubs,
                    R.drawable.seven_of_clubs,
                    R.drawable.eight_of_clubs,
                    R.drawable.nine_of_clubs,
                    R.drawable.ten_of_clubs,
                    R.drawable.jack_of_clubs,
                    R.drawable.queen_of_clubs,
                    R.drawable.king_of_clubs,
                    R.drawable.ace_of_hearts,
                    R.drawable.two_of_hearts,
                    R.drawable.three_of_hearts,
                    R.drawable.four_of_hearts,
                    R.drawable.five_of_hearts,
                    R.drawable.six_of_hearts,
                    R.drawable.seven_of_hearts,
                    R.drawable.eight_of_hearts,
                    R.drawable.nine_of_hearts,
                    R.drawable.ten_of_hearts,
                    R.drawable.jack_of_hearts,
                    R.drawable.queen_of_hearts,
                    R.drawable.king_of_hearts,
                    R.drawable.ace_of_diamonds,
                    R.drawable.two_of_diamonds,
                    R.drawable.three_of_diamonds,
                    R.drawable.four_of_diamonds,
                    R.drawable.five_of_diamonds,
                    R.drawable.six_of_diamonds,
                    R.drawable.seven_of_diamonds,
                    R.drawable.eight_of_diamonds,
                    R.drawable.nine_of_diamonds,
                    R.drawable.ten_of_diamonds,
                    R.drawable.jack_of_diamonds,
                    R.drawable.queen_of_diamonds,
                    R.drawable.king_of_diamonds));

    public ArrayList<Integer> getRandomCardIds(int numOfCards) {
        ArrayList<Integer> cardIds = new ArrayList<>(NO_OF_CARDS);
        for (int i = 0; i < NO_OF_CARDS; i++) {
            cardIds.add(i);
        }
        Collections.shuffle(cardIds);
        return new ArrayList<>(cardIds.subList(0, numOfCards));
    }

    public PlayerHand getPlayerHand(List<Integer> cardNumbers) {
        ArrayList<Card> cards = new ArrayList<>();
        for (Integer cardNumber : cardNumbers) {
            cards.add(getCard(cardNumber));
        }
        return new PlayerHand(cards);
    }

    public int getCardIconResId(int cardId) {
        return cardsDrawableIds.get(cardId);
    }

    /********************************Private***************************************/
    /******************************^^^^^^^^^***************************************/
    /********************************Methods***************************************/

    private Card getCard(int cardNumber) {
        int suiteId = cardNumber / (NO_OF_CARDS_IN_A_SUITE);
        int cardValue = cardNumber % 13;
        return new Card(cardNumber, getSuite(suiteId), cardValue);
    }

    private Suite getSuite(int suiteId) {
        switch (suiteId) {
            case 0:
                return Suite.SPADES;
            case 1:
                return Suite.CLUBS;
            case 2:
                return Suite.HEARTS;
            case 3:
                return Suite.DIAMONDS;
        }
        return null;
    }
}
