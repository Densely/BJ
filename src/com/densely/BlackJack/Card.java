package com.densely.BlackJack;

/**
 * Created with IntelliJ IDEA.
 * User: Densely
 * Date: 26.11.13
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public class Card {

    private String suit;    // масть карты
    private int score;   // очки за карту
    private String cardName;    // имя карты


    public String getSuit() {
        return suit;
    }

    public void setSuit(int suitNum) {
        if (suitNum < 4) {
            String suit[] = {"Крести","Пики","Буби","Черви"};
            this.suit = suit[suitNum];
        }else{
            //Log.d("Ошибка масти:","значение больше 4");
        }
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(int cardNameNum) {
        String cardName[] = {"Туз","2","3","4","5","6","7","8","9","10","Валет","Дама","Король"};
        this.score = (cardNameNum+1)<=10 ? cardNameNum+1 : 10;
        this.cardName = cardName[cardNameNum];
    }

    public int getScore() {
        return score;
    }
}