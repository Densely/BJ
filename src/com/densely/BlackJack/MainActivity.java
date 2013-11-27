package com.densely.BlackJack;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    Button btnStart;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Game game = new Game();
        game.newGame();
        game.checkBlackJack();


    }
}
