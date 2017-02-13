package com.hbm.heathbaron_morgan.reflexmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameType extends AppCompatActivity {

    Double screenInches = MainMenu.screenInches;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    Button backFromType;
    Button forwardFromType;
    Button forwardFromType1;
    Button forwardFromType2;
    TextView titleLbl;
    TextView desc1;
    TextView desc2;
    TextView desc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_type);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setup();
    }

    public void setup() {
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        backFromType = (Button) findViewById(R.id.backFromType);
        forwardFromType = (Button) findViewById(R.id.fowardFromType);
        forwardFromType1 = (Button) findViewById(R.id.fowardFromType1);
        forwardFromType2 = (Button) findViewById(R.id.fowardFromType2);

        titleLbl = (TextView) findViewById(R.id.typeLbl);
        desc1 = (TextView) findViewById(R.id.descLbl1);
        desc2 = (TextView) findViewById(R.id.descLbl2);
        desc3 = (TextView) findViewById(R.id.descLbl3);

        backFromType.setScaleX((float) (backFromType.getScaleX() * 0.75));
        forwardFromType.setScaleX((float) (forwardFromType.getScaleX() * 0.75));
        forwardFromType1.setScaleX((float) (forwardFromType1.getScaleX() * 0.75));
        forwardFromType2.setScaleX((float) (forwardFromType2.getScaleX() * 0.75));

        if(screenInches <= 3.95) {
            titleLbl.setTextSize(26);
            desc1.setTextSize(12);
            desc2.setTextSize(12);
            desc3.setTextSize(12);
            backFromType.setTextSize(28);
            backFromType.setTextScaleX(1.3f);
            forwardFromType.setTextSize(28);
            forwardFromType.setTextScaleX(1.3f);
            forwardFromType1.setTextSize(28);
            forwardFromType1.setTextScaleX(1.3f);
            forwardFromType2.setTextSize(28);
            forwardFromType2.setTextScaleX(1.3f);
        } else if(screenInches <= 4.75) {
            titleLbl.setTextSize(32);
            desc1.setTextSize(16);
            desc2.setTextSize(16);
            desc3.setTextSize(16);
            backFromType.setTextSize(30);
            backFromType.setTextScaleX(1.3f);
            forwardFromType.setTextSize(30);
            forwardFromType.setTextScaleX(1.3f);
            forwardFromType1.setTextSize(30);
            forwardFromType1.setTextScaleX(1.3f);
            forwardFromType2.setTextSize(30);
            forwardFromType2.setTextScaleX(1.3f);
        } else if(screenInches <= 5.85) {
            titleLbl.setTextSize(31);
            desc1.setTextSize(15);
            desc2.setTextSize(15);
            desc3.setTextSize(15);
            backFromType.setTextSize(30);
            backFromType.setTextScaleX(1.3f);
            forwardFromType.setTextSize(30);
            forwardFromType.setTextScaleX(1.3f);
            forwardFromType1.setTextSize(30);
            forwardFromType1.setTextScaleX(1.3f);
            forwardFromType2.setTextSize(30);
            forwardFromType2.setTextScaleX(1.3f);
        } else if(screenInches <= 7.55) {
            titleLbl.setTextSize(42);
            desc1.setTextSize(22);
            desc2.setTextSize(22);
            desc3.setTextSize(22);
            backFromType.setTextSize(30);
            backFromType.setTextScaleX(1.5f);
            forwardFromType.setTextSize(30);
            forwardFromType.setTextScaleX(1.5f);
            forwardFromType1.setTextSize(30);
            forwardFromType1.setTextScaleX(1.5f);
            forwardFromType2.setTextSize(30);
            forwardFromType2.setTextScaleX(1.5f);
            forwardFromType.setScaleY(1.3f);
            forwardFromType1.setScaleY(1.3f);
            forwardFromType2.setScaleY(1.3f);
            backFromType.setScaleY(1.3f);
        } else if(screenInches <= 10.5) {
            titleLbl.setTextSize(55);
            desc1.setTextSize(30);
            desc2.setTextSize(30);
            desc3.setTextSize(30);
            backFromType.setTextSize(30);
            backFromType.setTextScaleX(1.5f);
            forwardFromType.setTextSize(30);
            forwardFromType.setTextScaleX(1.5f);
            forwardFromType1.setTextSize(30);
            forwardFromType1.setTextScaleX(1.5f);
            forwardFromType2.setTextSize(30);
            forwardFromType2.setTextScaleX(1.5f);
            forwardFromType.setScaleY(1.3f);
            forwardFromType1.setScaleY(1.3f);
            forwardFromType2.setScaleY(1.3f);
            backFromType.setScaleY(1.3f);
        } else {
            titleLbl.setTextSize(20);
            desc1.setTextSize(20);
            desc2.setTextSize(20);
            desc3.setTextSize(20);
            backFromType.setTextSize(30);
            backFromType.setTextScaleX(1.3f);
            forwardFromType.setTextSize(30);
            forwardFromType.setTextScaleX(1.3f);
            forwardFromType1.setTextSize(30);
            forwardFromType1.setTextScaleX(1.3f);
            forwardFromType2.setTextSize(30);
            forwardFromType2.setTextScaleX(1.3f);
        }
    }


    public void toSettings(View v) {
        Button btn = (Button) v;

        if (btn.getText().equals("CHALLENGE")) {
            System.out.println("TYPE SET TO 0");
            editor.putInt("type", 0);
        } else if (btn.getText().equals("CASUAL")) {
            editor.putInt("type", 1);
        } else if (btn.getText().equals("PRACTICE")) {
            editor.putInt("type", 2);
        }
        editor.apply();

        if(MainMenu.audio) {
            MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(GameType.this, SettingsPage.class));
    }

    public void backToStart(View v) {
        if(MainMenu.audio) {
            MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(GameType.this, MainMenu.class));
    }

}
