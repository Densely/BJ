package com.densely.BlackJack;


import android.util.Log;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

enum Operation {
    kStop,
    kGrab,
    kDefault
}

enum Status {
    kLoose,
    kBlackJack,
    kStay,
    kDefault
}

/**
 * Created with IntelliJ IDEA.
 * User: Densely
 * Date: 26.11.13
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */

public abstract class AbstractPlayer {

    protected Operation operation = Operation.kDefault;
    private int score;
    private List<Card> cards = new LinkedList(Arrays.asList());
    private int numberOfAce;
    private Status status = Status.kDefault;
    private String playerName;

    public AbstractPlayer(String name) {
        playerName = name;
    }

    public abstract Operation play();   // logic of the game

    public int getScore() {
        return score;
    }

    public void tagBlackJack() {

        if (((cards.get(0).getScore() == 1) && ((cards.get(1).getScore() == 10) && cards.get(1).getCardName() != "10")) || ((cards.get(1).getScore() == 1) && ((cards.get(0).getScore() == 10) && cards.get(0).getCardName() != "10")))
            Log.d("Game winners", "tagBlackJack");
            this.status = Status.kBlackJack;

    }

    public void grabCard(Card card) {
        this.score = 0;
        this.cards.add(card);
        if (card.getScore() == 1)
            numberOfAce += 1;
        for (Card card1 : cards) {
            if (card1.getScore() != 1)
                score += card1.getScore();
        }
        for (int i = 0; i < numberOfAce; i++) {
            if (score < 11)
                score += 11;
            else score += 1;
        }
        if (this.score >= 22)
            this.status = Status.kLoose;
        else if (this.score <= 21)
            this.status = Status.kStay;

        Log.d("Game winners", getPlayerName() + " взял карту " + card.getCardName() + " " + card.getSuit() + " сумма очков " + score + " статус " + getStatus());

    }

    public Status getStatus() {
        return status;
    }

    public String getPlayerName() {
        return playerName;
    }
}



