package com.hbm.heathbaron_morgan.reflexmath;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;

public class MainMenu extends AppCompatActivity {

    TextView highScoreLbl;
    TextView lvlLbl;
    ImageButton audioBtn;
    ProgressBar xpBar;
    static Double screenInches = 0.0;
    static Boolean audio = true;

    SharedPreferences pref;
    Editor editor;

    public static SoundPool soundPool;
    HashMap<Integer, Integer> soundPoolMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setup();
        updateMenu();
        lastSetup();
    }

    public void setup() {
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        highScoreLbl = (TextView) findViewById(R.id.highScoreLbl);
        lvlLbl = (TextView) findViewById(R.id.lvlLbl);
        xpBar = (ProgressBar) findViewById(R.id.xpBar);
        audioBtn = (ImageButton) findViewById(R.id.audioBtn);

        if(pref.getBoolean("audio", true) == true) {
            audioBtn.setImageResource(R.drawable.audioon);
            audio = true;
        } else {
            audioBtn.setImageResource(R.drawable.audiooff);
            audio = false;
        }

        if(screenInches == 0.0) {
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            double x = Math.pow(dm.widthPixels / dm.xdpi, 2);
            double y = Math.pow(dm.heightPixels / dm.ydpi, 2);
            screenInches = Math.sqrt(x + y);
            screenInches = (double) Math.round(screenInches * 10) / 10;
        }

        if(screenInches <= 3.95) {
            lvlLbl.setTextSize(28);
            highScoreLbl.setTextSize(26);
            xpBar.setScaleY(xpBar.getScaleY() * 2.5f);
        } else if(screenInches <= 4.75) {
            xpBar.setScaleY(xpBar.getScaleY() * 3);
            lvlLbl.setTextSize(31);
            highScoreLbl.setTextSize(30);
        } else if(screenInches <= 5.85) {
            xpBar.setScaleY(xpBar.getScaleY() * 3);
            lvlLbl.setTextSize(32);
            highScoreLbl.setTextSize(30);
        } else if(screenInches <= 7.55) {
            xpBar.setScaleY(xpBar.getScaleY() * 4);
            lvlLbl.setTextSize(38);
            highScoreLbl.setTextSize(38);
        } else if(screenInches <= 10.5) {
            xpBar.setScaleY(xpBar.getScaleY() * 5);
            lvlLbl.setTextSize(55);
            highScoreLbl.setTextSize(52);
        } else {
            xpBar.setScaleY(xpBar.getScaleY() * 5);
            lvlLbl.setTextSize(55);
            highScoreLbl.setTextSize(52);
        }

    }

    public void updateMenu() {
        highScoreLbl.setText("HIGH SCORE " + pref.getInt("hs", 0));
        xpBar.setProgress(pref.getInt("xp",0));
        int level = pref.getInt("level",0);
        if(level == 0) {
            editor.putInt("level",1);
            level = 1;
        }
        lvlLbl.setText(Integer.toString(level));
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        updateMenu();
    }

    public void lastSetup() {
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap<Integer, Integer>();
        soundPoolMap.put(1, soundPool.load(this, R.raw.touch, 1));
        soundPoolMap.put(2, soundPool.load(this, R.raw.error, 1));
    }

    public void audioFunc(View v) {
        if(pref.getBoolean("audio",true)) {
            editor.putBoolean("audio", false);
            audioBtn.setImageResource(R.drawable.audiooff);
            audio = false;
        } else {
            editor.putBoolean("audio", true);
            audioBtn.setImageResource(R.drawable.audioon);
            audio = true;
        }
        editor.apply();
    }



    public void openStats(View v) {
        if(audio) {
            soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(MainMenu.this, StatsPage.class));
    }

    public void startGame(View v) {
        if(audio) {
            soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(MainMenu.this, GameType.class));
    }


}
