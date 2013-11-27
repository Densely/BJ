package com.densely.BlackJack;


import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Densely
 * Date: 26.11.13
 * Time: 17:32
 * To change this template use File | Settings | File Templates.
 */

public class Game {

    private Koloda koloda;
    private int numbersOfPlayer;    // колличество игроков
    private int numbersOfBot;       // колличество ботов
    private List<AbstractPlayer> playersOnTable = new ArrayList<AbstractPlayer>();   // содержит игроков за столом
    private List<AbstractPlayer> winners = new ArrayList<AbstractPlayer>();   // содержит игроков победивших раунд
    private List<AbstractPlayer> WithScore = new ArrayList<AbstractPlayer>();   // содержит игроков которые остановились, у которых небыло перебора

    //public static void main(String[] args){   }

    public void newGame() {

        this.koloda = new Koloda();
        this.numbersOfPlayer = 1;
        this.numbersOfBot = 2;
        playersOnTable.removeAll(new ArrayList<AbstractPlayer>());
        winners.removeAll(new ArrayList<AbstractPlayer>());
        WithScore.removeAll(new ArrayList<AbstractPlayer>());

        if (numbersOfPlayer > 0) {
            for (int i = 0; i < numbersOfPlayer; i++) {
                PlayerHuman human = new PlayerHuman("Player " + String.valueOf(i));
                Card card = this.koloda.getRundomCard();
                human.grabCard(card);
                card = this.koloda.getRundomCard();
                human.grabCard(card);
                human.tagBlackJack();
                this.playersOnTable.add(human);

            }
        }
        if (numbersOfBot > 0) {
            for (int i = 0; i < numbersOfBot; i++) {
                PlayerBot bot = new PlayerBot("Bot " + String.valueOf(i));
                Card card = this.koloda.getRundomCard();
                bot.grabCard(card);
                card = this.koloda.getRundomCard();
                bot.grabCard(card);
                bot.tagBlackJack();
                this.playersOnTable.add(bot);
            }
        }
        PlayerDiller diller = new PlayerDiller("Diller");
        Card card = this.koloda.getRundomCard();
        diller.grabCard(card);
        card = this.koloda.getRundomCard();
        diller.grabCard(card);
        diller.tagBlackJack();
        this.playersOnTable.add(diller);

    }

    public void checkBlackJack() {


        for (int i = 0; i < playersOnTable.size() - 1; i++) {
            if (playersOnTable.get(i).getStatus() == Status.kBlackJack) {
                winners.add(playersOnTable.get(i));
                Log.d("THisss", playersOnTable.get(i).getPlayerName());
                Log.d("THissssss", winners.get(0).getPlayerName());
            }
        }
        if (winners.size() == 0)
            if (playersOnTable.get(playersOnTable.size() - 1).getStatus() == Status.kBlackJack) {
                winners.add(playersOnTable.get(playersOnTable.size() - 1));
                Log.d("THisssssssss", playersOnTable.get(playersOnTable.size() - 1).getPlayerName());
                Log.d("THissssssssssss", winners.get(0).getPlayerName());
            }
        if (winners.size() > 0) {
            Log.d("THisssssssssssss", "This");

        } // else whileTheGame();

    }

    private void whileTheGame() {

        boolean diller_is_playing = true;
        boolean players_is_playing = true;
        while (players_is_playing) {
            players_is_playing = false;
            for (int cnt = 0; cnt < (playersOnTable.size() - 1); cnt++) {
                AbstractPlayer player = this.playersOnTable.get(cnt);
                if (player.getStatus() == Status.kStay) {
                    switch (player.play()) {
                        case kGrab:
                            player.grabCard(koloda.getRundomCard());
                            players_is_playing = true;
                            break;
                        case kStop:
                            Log.d("Игра: ", "Игрок" + player.getPlayerName() + "to Stop");
                            WithScore.add(player);
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        if (WithScore.size() == 0) {
            winners.add(playersOnTable.get(playersOnTable.size() - 1));
            win();
        } else {
            while (diller_is_playing) {
                diller_is_playing = false;
                AbstractPlayer player = this.playersOnTable.get(playersOnTable.size() - 1);
                if (player.getStatus() == Status.kStay) {
                    switch (player.play()) {
                        case kGrab:
                            player.grabCard(koloda.getRundomCard());
                            diller_is_playing = true;
                            break;
                        case kStop:
                            Log.d("Игра: ", "Игрок" + player.getPlayerName() + "to Stop");
                                WithScore.add(player);
                            break;
                        default:
                            break;
                    }
                }
            }
            determineTheWinners();
        }
    }

    private void determineTheWinners() {
        Log.d("Game winners", String.valueOf(WithScore.size()));
        int maxScore = 0;
        for (AbstractPlayer player : WithScore) {
            if (player.getScore() > maxScore)
                maxScore = player.getScore();
        }
        for (AbstractPlayer player : WithScore) {
            if (player.getScore() == maxScore)
                winners.add(player);
        }
        win();
    }

    private void win() {

        for (int i = 0; i < winners.size(); i++) {
            Log.d("Game winners", "Win " + winners.get(i).getPlayerName() + " score= " + winners.get(i).getScore() + " " + winners.size());
        }
    }

    private void updateTable() {
        // ---- метод обновляющий стол ----
    }

}


