package com.hbm.heathbaron_morgan.reflexmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class GameOverPage extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    Double screenInches = MainMenu.screenInches;

    Button forwardFromGameOver;
    TextView titleLbl;
    TextView messageLbl;
    TextView scoreLbl;
    TextView correctLbl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setup();
        populateFields();
        calculateValues();
    }

    public void setup() {
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        forwardFromGameOver = (Button) findViewById(R.id.fowardFromGameOver);
        messageLbl = (TextView) findViewById(R.id.gameOverMsg);
        titleLbl = (TextView) findViewById(R.id.gameOverTitle);
        scoreLbl = (TextView) findViewById(R.id.gameOverScore);
        correctLbl = (TextView) findViewById(R.id.gameOverCorrect);

        forwardFromGameOver.setScaleX((float) (forwardFromGameOver.getScaleX() * 0.75));

        if(screenInches <= 3.95) {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.3f);
            titleLbl.setTextSize(45);
            messageLbl.setTextSize(20);
            scoreLbl.setTextSize(28);
            correctLbl.setTextSize(25);
        } else if(screenInches <= 4.75) {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.3f);
            titleLbl.setTextSize(48);
            messageLbl.setTextSize(25);
            scoreLbl.setTextSize(30);
            correctLbl.setTextSize(27);
        } else if(screenInches <= 5.85) {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.3f);
            titleLbl.setTextSize(49);
            messageLbl.setTextSize(23);
            scoreLbl.setTextSize(29);
            correctLbl.setTextSize(27);
        } else if(screenInches <= 7.55) {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.3f);
            titleLbl.setTextSize(55);
            messageLbl.setTextSize(32);
            scoreLbl.setTextSize(33);
            correctLbl.setTextSize(31);
        } else if(screenInches <= 10.5) {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.7f);
            forwardFromGameOver.setScaleY(1.5f);
            titleLbl.setTextSize(75);
            messageLbl.setTextSize(40);
            scoreLbl.setTextSize(40);
            correctLbl.setTextSize(40);
        } else {
            forwardFromGameOver.setTextSize(30);
            forwardFromGameOver.setTextScaleX(1.3f);
            titleLbl.setTextSize(25);
            messageLbl.setTextSize(25);
            scoreLbl.setTextSize(22);
            correctLbl.setTextSize(22);
        }
    }

    public void populateFields() {

        int lastScore = pref.getInt("tempscore", 0);

        if(lastScore > pref.getInt("hs", 0)) {
            messageLbl.setText("NEW HIGHSCORE!");
        } else {
            if (lastScore == 0) {
                if(pref.getBoolean("practice",false)) {
                    editor.putBoolean("practice", false);
                    messageLbl.setText("READY FOR A REAL RUN?");
                } else {
                    messageLbl.setText("WHAT HAPPENED THERE?");
                }
            } else {
                String tempMsg = "";
                Random random = new Random();
                switch (random.nextInt(3)) {
                    case 0:
                        tempMsg = "WELL DONE, KEEP PRACTICING!";
                        break;
                    case 1:
                        tempMsg = "GOOD, BUT YOU CAN DO BETTER!";
                        break;
                    case 2:
                        tempMsg = "GOOD EFFORT, KEEP GOING!";
                        break;
                }
                messageLbl.setText(tempMsg);
            }
        }

        scoreLbl.setText("SCORE  " + lastScore);
        correctLbl.setText("CORRECT ANSWERS  " + pref.getInt("correct", 0));
    }

    public void calculateValues() {
        int temp = pref.getInt("tempscore", 0);

        if(pref.getInt("hs", 0) < temp) {
            editor.putInt("hs", temp);
        }

        temp = pref.getInt("totalcorrect",0);
        temp += pref.getInt("correct",0);
        editor.putInt("totalcorrect", temp);

        temp = pref.getInt("totalscore", 0);
        temp += pref.getInt("tempscore", 0);
        editor.putInt("totalscore", temp);

        temp = pref.getInt("games", 0);
        temp += 1;
        editor.putInt("games", temp);

        /// calc XP and level

        temp = pref.getInt("xp", 0);
        temp += pref.getInt("tempscore",0);

        int level = 0;
        while(temp > 100) {
            level += 1;
            temp -= 100;
        }
        editor.putInt("xp", temp);

        if (level > 0) {
            temp = pref.getInt("level", 1);
            temp += level;
            editor.putInt("level", temp);
        }

        editor.putInt("tempscore",0);
        editor.putInt("correct",0);

        editor.apply();
    }

    public void returnToMain(View v) {
        if(MainMenu.audio) {
            MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(GameOverPage.this, MainMenu.class));
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
        if(MainMenu.audio) {
            MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(GameOverPage.this, MainMenu.class));
    }

}
