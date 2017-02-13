package com.hbm.heathbaron_morgan.reflexmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StatsPage extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    Double screenInches = MainMenu.screenInches;

    TextView titleLbl;
    TextView highScoreLbl;
    TextView totalScoreLbl;
    TextView totalCorrectLbl;
    TextView totalGamesLbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setup();
        populateFields();
    }

    public void setup() {
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        titleLbl = (TextView) findViewById(R.id.statsTitle);
        highScoreLbl = (TextView) findViewById(R.id.statsHS);
        totalScoreLbl = (TextView) findViewById(R.id.statsTotalScore);
        totalCorrectLbl = (TextView) findViewById(R.id.statsTotalCorrect);
        totalGamesLbl = (TextView) findViewById(R.id.statsGames);

        Button toMainBtn = (Button) findViewById(R.id.toMainBtn);
        toMainBtn.setScaleX((float) (toMainBtn.getScaleX() * 0.75));

        if(screenInches <= 3.95) {
            toMainBtn.setTextSize(28);
            toMainBtn.setTextScaleX(1.28f);
            titleLbl.setTextSize(28);
            highScoreLbl.setTextSize(22);
            totalScoreLbl.setTextSize(22);
            totalCorrectLbl.setTextSize(22);
            totalGamesLbl.setTextSize(22);
        } else if(screenInches <= 4.75) {
            toMainBtn.setTextSize(32);
            toMainBtn.setTextScaleX(1.3f);
            titleLbl.setTextSize(32);
            highScoreLbl.setTextSize(25);
            totalScoreLbl.setTextSize(22);
            totalCorrectLbl.setTextSize(22);
            totalGamesLbl.setTextSize(24);
        } else if(screenInches <= 5.85) {
            toMainBtn.setTextSize(36);
            toMainBtn.setTextScaleX(1.3f);
            titleLbl.setTextSize(34);
            highScoreLbl.setTextSize(25);
            totalScoreLbl.setTextSize(22);
            totalCorrectLbl.setTextSize(22);
            totalGamesLbl.setTextSize(24);
        } else if(screenInches <= 7.55) {
            toMainBtn.setTextSize(36);
            toMainBtn.setTextScaleX(1.3f);
            titleLbl.setTextSize(40);
            highScoreLbl.setTextSize(29);
            totalScoreLbl.setTextSize(27);
            totalCorrectLbl.setTextSize(27);
            totalGamesLbl.setTextSize(29);
        } else if(screenInches <= 10.5) {
            toMainBtn.setTextSize(36);
            toMainBtn.setTextScaleX(1.3f);
            titleLbl.setTextSize(50);
            highScoreLbl.setTextSize(40);
            totalScoreLbl.setTextSize(38);
            totalCorrectLbl.setTextSize(38);
            totalGamesLbl.setTextSize(40);
        } else {
            toMainBtn.setTextSize(30);
            toMainBtn.setTextScaleX(1.3f);
            titleLbl.setTextSize(12);
            highScoreLbl.setTextSize(12);
            totalScoreLbl.setTextSize(12);
            totalCorrectLbl.setTextSize(12);
            totalGamesLbl.setTextSize(12);
        }
    }

    public void populateFields() {
        highScoreLbl.setText("HIGHEST SCORE  " + pref.getInt("hs",0));
        totalScoreLbl.setText("COMBINED TOTAL SCORE  " + pref.getInt("totalscore",0));
        totalCorrectLbl.setText("TOTAL CORRECT ANSWERS  " + pref.getInt("totalcorrect",0));
        totalGamesLbl.setText("TOTAL PLAYED GAMES  " + pref.getInt("games",0));
    }

    public void toMain(View v) {
        if(MainMenu.audio) {
            MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(StatsPage.this, MainMenu.class));
    }

}
