package com.hbm.heathbaron_morgan.reflexmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class DifficultyPage extends AppCompatActivity {

    Double screenInches = MainMenu.screenInches;
    int difficulty;

    ToggleButton diffToggle1;
    ToggleButton diffToggle2;
    ToggleButton diffToggle3;
    ToggleButton diffToggle4;
    ToggleButton diffToggle5;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setup();
        setData();

        View v = getLayoutInflater().inflate(R.layout.difficulty_page, null);
        toggleChanged(v, false);

    }

    public void setup() {
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        diffToggle1 = (ToggleButton) findViewById(R.id.diff1Toggle);
        diffToggle2 = (ToggleButton) findViewById(R.id.diff2Toggle);
        diffToggle3 = (ToggleButton) findViewById(R.id.diff3Toggle);
        diffToggle4 = (ToggleButton) findViewById(R.id.diff4Toggle);
        diffToggle5 = (ToggleButton) findViewById(R.id.diff5Toggle);

        diffToggle1.setScaleY((float) (diffToggle1.getScaleY() * 0.7));
        diffToggle2.setScaleY((float) (diffToggle2.getScaleY() * 0.7));
        diffToggle3.setScaleY((float) (diffToggle3.getScaleY() * 0.7));
        diffToggle4.setScaleY((float) (diffToggle4.getScaleY() * 0.7));
        diffToggle5.setScaleY((float) (diffToggle5.getScaleY() * 0.7));

        diffToggle1.setScaleX((float) (diffToggle1.getScaleX() * 0.7));
        diffToggle2.setScaleX((float) (diffToggle2.getScaleX() * 0.7));
        diffToggle3.setScaleX((float) (diffToggle3.getScaleX() * 0.7));
        diffToggle4.setScaleX((float) (diffToggle4.getScaleX() * 0.7));
        diffToggle5.setScaleX((float) (diffToggle5.getScaleX() * 0.7));

        Button backBtn = (Button) findViewById(R.id.diffcultyBack);
        backBtn.setScaleX((float) (backBtn.getScaleX() * 0.75));

        Button startBtn = (Button) findViewById(R.id.startGameBtn);
        startBtn.setScaleX((float) (startBtn.getScaleX() * 0.75));

        if(screenInches <= 3.95) {
            backBtn.setTextSize(26);
            backBtn.setTextScaleX(1.25f);
            startBtn.setTextSize(26);
            startBtn.setTextScaleX(1.25f);
            diffToggle1.setTextSize(30);
            diffToggle2.setTextSize(30);
            diffToggle3.setTextSize(30);
            diffToggle4.setTextSize(30);
            diffToggle5.setTextSize(30);
        } else if(screenInches <= 4.75) {
            backBtn.setTextSize(26);
            backBtn.setTextScaleX(1.25f);
            startBtn.setTextSize(26);
            startBtn.setTextScaleX(1.25f);
            diffToggle1.setTextSize(34);
            diffToggle2.setTextSize(34);
            diffToggle3.setTextSize(34);
            diffToggle4.setTextSize(34);
            diffToggle5.setTextSize(34);
        } else if(screenInches <= 5.85) {
            backBtn.setTextSize(26);
            backBtn.setTextScaleX(1.25f);
            startBtn.setTextSize(26);
            startBtn.setTextScaleX(1.25f);
            diffToggle1.setTextSize(40);
            diffToggle2.setTextSize(40);
            diffToggle3.setTextSize(40);
            diffToggle4.setTextSize(40);
            diffToggle5.setTextSize(40);
        } else if(screenInches <= 7.55) {
            backBtn.setTextSize(28);
            backBtn.setTextScaleX(1.5f);
            startBtn.setTextSize(28);
            startBtn.setTextScaleX(1.5f);
            diffToggle1.setTextSize(45);
            diffToggle2.setTextSize(45);
            diffToggle3.setTextSize(45);
            diffToggle4.setTextSize(45);
            diffToggle5.setTextSize(45);
            backBtn.setScaleY(1.3f);
            startBtn.setScaleY(1.3f);
        } else if(screenInches <= 10.5) {
            backBtn.setTextSize(30);
            backBtn.setTextScaleX(1.5f);
            startBtn.setTextSize(30);
            startBtn.setTextScaleX(1.5f);
            diffToggle1.setTextSize(50);
            diffToggle2.setTextSize(50);
            diffToggle3.setTextSize(50);
            diffToggle4.setTextSize(50);
            diffToggle5.setTextSize(50);
            backBtn.setScaleY(1.5f);
            startBtn.setScaleY(1.5f);
        } else {
            backBtn.setTextSize(26);
            backBtn.setTextScaleX(1.25f);
            startBtn.setTextSize(26);
            startBtn.setTextScaleX(1.25f);
            diffToggle1.setTextSize(40);
            diffToggle2.setTextSize(40);
            diffToggle3.setTextSize(40);
            diffToggle4.setTextSize(40);
            diffToggle5.setTextSize(40);
        }
    }

    public void setData() {
        if(pref.getInt("difficulty", 6) == 6) {
            editor.putInt("difficulty", 1);
            difficulty = 1;
        } else {
            difficulty = pref.getInt("difficulty", 6);
        }

        editor.apply();

        if(difficulty == 1) {
            diffToggle1.setChecked(true);
        } else if(difficulty == 2) {
            diffToggle2.setChecked(true);
        } else if(difficulty == 3) {
            diffToggle3.setChecked(true);
        } else if(difficulty == 4) {
            diffToggle4.setChecked(true);
        } else if(difficulty == 5) {
            diffToggle5.setChecked(true);
        }
    }

    public void changeDifficulty(View v) {
        toggleChanged(v, true);
    }

    public void toggleChanged(View v, Boolean realPress) {

        if(realPress) {
            ToggleButton currentToggle = (ToggleButton) v;
            if(diffToggle1.getText() != currentToggle.getText()) {
                diffToggle1.setChecked(false);
                diffToggle1.setBackgroundColor(Color.parseColor("#ff0099cc"));
            }
            if(diffToggle2.getText() != currentToggle.getText()) {
                diffToggle2.setChecked(false);
                diffToggle2.setBackgroundColor(Color.parseColor("#ff0099cc"));
            }
            if(diffToggle3.getText() != currentToggle.getText()) {
                diffToggle3.setChecked(false);
                diffToggle3.setBackgroundColor(Color.parseColor("#ff0099cc"));
            }
            if(diffToggle4.getText() != currentToggle.getText()) {
                diffToggle4.setChecked(false);
                diffToggle4.setBackgroundColor(Color.parseColor("#ff0099cc"));
            }
            if(diffToggle5.getText() != currentToggle.getText()) {
                diffToggle5.setChecked(false);
                diffToggle5.setBackgroundColor(Color.parseColor("#ff0099cc"));
            }
        }

        if(diffToggle1.isChecked()) {
            diffToggle1.setBackgroundColor(Color.parseColor("#ff99cc00"));
            diffToggle1.setChecked(true);
            editor.putInt("difficulty", 1);
        }

        if(diffToggle2.isChecked()) {
            diffToggle2.setBackgroundColor(Color.parseColor("#ff99cc00"));
            diffToggle2.setChecked(true);
            editor.putInt("difficulty", 2);
        }

        if(diffToggle3.isChecked()) {
            diffToggle3.setBackgroundColor(Color.parseColor("#ff99cc00"));
            diffToggle3.setChecked(true);
            editor.putInt("difficulty", 3);
        }

        if(diffToggle4.isChecked()) {
            diffToggle4.setBackgroundColor(Color.parseColor("#ff99cc00"));
            diffToggle4.setChecked(true);
            editor.putInt("difficulty", 4);
        }

        if(diffToggle5.isChecked()) {
            diffToggle5.setBackgroundColor(Color.parseColor("#ff99cc00"));
            diffToggle5.setChecked(true);
            editor.putInt("difficulty", 5);
        }

        editor.apply();
    }

    public void backToSettings(View v) {
        if(MainMenu.audio) {
            MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(DifficultyPage.this, SettingsPage.class));
    }

    public void startGame(View v) {
        if(MainMenu.audio) {
            MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(DifficultyPage.this, GamePage.class));
    }

}
