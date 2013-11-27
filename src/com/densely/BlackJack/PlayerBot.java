package com.densely.BlackJack;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Densely
 * Date: 26.11.13
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public class PlayerBot extends AbstractPlayer {


    public PlayerBot(String name) {
        super(name);
    }

    @Override
    public Operation play() {
        // logic of the game
        int localScore = super.getScore();
        if (localScore < 10)
            return super.operation = Operation.kGrab;
        else if ((localScore > 9 && localScore < 17) && (new Random().nextBoolean()))
            return super.operation = Operation.kGrab;
        else return super.operation = Operation.kStop;
    }
}
