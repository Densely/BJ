package com.densely.BlackJack;

import android.util.Log;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Densely
 * Date: 26.11.13
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 */
public class Koloda {

    private List<Card> cards = new LinkedList(Arrays.asList());

    public Koloda(){

        for (int cardName = 0; cardName < 13; cardName++){
            for (int suit = 0; suit < 4; suit++){

                Card card = new Card();

                card.setCardName(cardName);
                Log.d("Koloda", " No Done!");
                card.setSuit(suit);
                Log.d("Koloda", " No Done!");
                cards.add(card);
                Log.d("Koloda", " No Done!");
            }
        }

        Log.d("Koloda", " Done!" + cards.size());
    }

    public Card getRundomCard(){

        int randomIndex = new Random().nextInt(cards.size()-1);
        Card card = this.cards.get(randomIndex);
        this.cards.remove(randomIndex);

        return card;
    }



}
