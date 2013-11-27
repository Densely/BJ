package com.densely.BlackJack;

/**
 * Created with IntelliJ IDEA.
 * User: Densely
 * Date: 26.11.13
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
public class PlayerDiller extends AbstractPlayer {

    public PlayerDiller(String name) {
        super(name);
    }

    @Override
    public Operation play() {
        // logic of the game
        int localScore = super.getScore();
        if (localScore < 17)
            return super.operation = Operation.kGrab;
        else return super.operation = Operation.kStop;
    }
}
