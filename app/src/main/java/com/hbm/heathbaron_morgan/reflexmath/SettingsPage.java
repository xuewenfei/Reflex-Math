package com.hbm.heathbaron_morgan.reflexmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class SettingsPage extends AppCompatActivity {

    Double screenInches = MainMenu.screenInches;

    ToggleButton additionBtn;
    ToggleButton subtractionBtn;
    ToggleButton multiplicationBtn;
    ToggleButton divisionBtn;
    Button backBtn;
    Button forwardButton;
    TextView title1;
    TextView title2;
    TextView title3;
    TextView title4;

    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setup();
        setData();

        View view = getLayoutInflater().inflate(R.layout.settings_page, null);
        isToggleActive(view);
    }

    public void setup() {
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        additionBtn = (ToggleButton) findViewById(R.id.additionToggle);
        subtractionBtn = (ToggleButton) findViewById(R.id.subtractionToggle);
        multiplicationBtn = (ToggleButton) findViewById(R.id.multiplicationToggle);
        divisionBtn = (ToggleButton) findViewById(R.id.divisionToggle);
        backBtn = (Button) findViewById(R.id.settingsCancel);
        forwardButton = (Button) findViewById(R.id.settingsStart);
        title1 = (TextView) findViewById(R.id.additionsLbl);
        title2 = (TextView) findViewById(R.id.subtractionLbl);
        title3 = (TextView) findViewById(R.id.multiplicationsLbl);
        title4 = (TextView) findViewById(R.id.divisionsLbl);

        Button cancelBtn = (Button) findViewById(R.id.settingsCancel);
        cancelBtn.setScaleX((float) (cancelBtn.getScaleX() * 0.75));

        Button startBtn = (Button) findViewById(R.id.settingsStart);
        startBtn.setScaleX((float) (startBtn.getScaleX() * 0.75));

        if(screenInches <= 3.95) {
            backBtn.setTextSize(26);
            backBtn.setTextScaleX(1.26f);
            forwardButton.setTextSize(26);
            forwardButton.setTextScaleX(1.26f);
            title1.setTextSize(17);
            title2.setTextSize(17);
            title3.setTextSize(17);
            title4.setTextSize(17);
            additionBtn.setTextSize(18);
            subtractionBtn.setTextSize(18);
            multiplicationBtn.setTextSize(18);
            divisionBtn.setTextSize(18);
        } else if(screenInches <= 4.75) {
            backBtn.setTextSize(28);
            backBtn.setTextScaleX(1.25f);
            forwardButton.setTextSize(28);
            forwardButton.setTextScaleX(1.25f);
            title1.setTextSize(19);
            title2.setTextSize(19);
            title3.setTextSize(19);
            title4.setTextSize(19);
            additionBtn.setTextSize(19);
            subtractionBtn.setTextSize(19);
            multiplicationBtn.setTextSize(19);
            divisionBtn.setTextSize(19);
        } else if(screenInches <= 5.85) {
            backBtn.setTextSize(26);
            backBtn.setTextScaleX(1.25f);
            forwardButton.setTextSize(26);
            forwardButton.setTextScaleX(1.25f);
            title1.setTextSize(17);
            title2.setTextSize(17);
            title3.setTextSize(17);
            title4.setTextSize(17);
            additionBtn.setTextSize(16);
            subtractionBtn.setTextSize(16);
            multiplicationBtn.setTextSize(16);
            divisionBtn.setTextSize(16);
        } else if(screenInches <= 7.55) {
            backBtn.setTextSize(28);
            backBtn.setTextScaleX(1.5f);
            forwardButton.setTextSize(28);
            forwardButton.setTextScaleX(1.5f);
            title1.setTextSize(25);
            title2.setTextSize(25);
            title3.setTextSize(25);
            title4.setTextSize(25);
            additionBtn.setTextSize(24);
            subtractionBtn.setTextSize(24);
            multiplicationBtn.setTextSize(24);
            divisionBtn.setTextSize(24);
            forwardButton.setScaleY(1.3f);
            backBtn.setScaleY(1.3f);
        } else if(screenInches <= 10.5) {
            backBtn.setTextSize(30);
            backBtn.setTextScaleX(1.5f);
            forwardButton.setTextSize(30);
            forwardButton.setTextScaleX(1.5f);
            title1.setTextSize(30);
            title2.setTextSize(30);
            title3.setTextSize(30);
            title4.setTextSize(30);
            additionBtn.setTextSize(28);
            subtractionBtn.setTextSize(28);
            multiplicationBtn.setTextSize(28);
            divisionBtn.setTextSize(28);
            forwardButton.setScaleY(1.5f);
            backBtn.setScaleY(1.5f);

        } else {
            backBtn.setTextSize(30);
            backBtn.setTextScaleX(1.3f);
            forwardButton.setTextSize(30);
            forwardButton.setTextScaleX(1.3f);
            title1.setTextSize(20);
            title2.setTextSize(20);
            title3.setTextSize(20);
            title4.setTextSize(20);
            additionBtn.setTextSize(20);
            subtractionBtn.setTextSize(20);
            multiplicationBtn.setTextSize(20);
            divisionBtn.setTextSize(20);
        }
    }

    public void setData() {
        if(pref.getInt("firstSettings", 0) == 0) {
            editor.putInt("firstSettings", 1);
            editor.putBoolean("addition", true);
            editor.putBoolean("subtraction", false);
            editor.putBoolean("multiplication", false);
            editor.putBoolean("division", false);
            editor.apply();
            additionBtn.setChecked(true);
        }

        if(pref.getBoolean("addition", true)) {
            additionBtn.setChecked(true);
        }
        if(pref.getBoolean("subtraction", true)) {
            subtractionBtn.setChecked(true);
        }
        if(pref.getBoolean("multiplication", true)) {
            multiplicationBtn.setChecked(true);
        }
        if(pref.getBoolean("division", true)) {
            divisionBtn.setChecked(true);
        }

    }

    public void isToggleActive(View v) {

        if(additionBtn.isChecked()) {
            additionBtn.setBackgroundColor(Color.parseColor("#ff99cc00"));
            additionBtn.setChecked(true);
            editor.putBoolean("addition", true);
        } else if(!additionBtn.isChecked()) {
            additionBtn.setBackgroundColor(Color.parseColor("#ff0099cc"));
            additionBtn.setChecked(false);
            editor.putBoolean("addition", false);
        }

        if(subtractionBtn.isChecked()) {
            subtractionBtn.setBackgroundColor(Color.parseColor("#ff99cc00"));
            subtractionBtn.setChecked(true);
            editor.putBoolean("subtraction", true);
        } else if(!subtractionBtn.isChecked()) {
            subtractionBtn.setBackgroundColor(Color.parseColor("#ff0099cc"));
            subtractionBtn.setChecked(false);
            editor.putBoolean("subtraction", false);
        }

        if(multiplicationBtn.isChecked()) {
            multiplicationBtn.setBackgroundColor(Color.parseColor("#ff99cc00"));
            multiplicationBtn.setChecked(true);
            editor.putBoolean("multiplication", true);
        } else if(!multiplicationBtn.isChecked()) {
            multiplicationBtn.setBackgroundColor(Color.parseColor("#ff0099cc"));
            multiplicationBtn.setChecked(false);
            editor.putBoolean("multiplication", false);
        }

        if(divisionBtn.isChecked()) {
            divisionBtn.setBackgroundColor(Color.parseColor("#ff99cc00"));
            divisionBtn.setChecked(true);
            editor.putBoolean("division", true);
        } else if(!divisionBtn.isChecked()) {
            divisionBtn.setBackgroundColor(Color.parseColor("#ff0099cc"));
            divisionBtn.setChecked(false);
            editor.putBoolean("division", false);
        }

        editor.apply();
    }


    public void toMain(View v) {
        if(MainMenu.audio) {
            MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
        }
        startActivity(new Intent(SettingsPage.this, GameType.class));
    }

    public void toDifficultyPage(View v) {
        int temp = 0;
        if(pref.getBoolean("addition", false)) {
            temp += 1;
        }
        if(pref.getBoolean("subtraction", false)) {
            temp += 1;
        }
        if(pref.getBoolean("multiplication", false)) {
            temp += 1;
        }
        if(pref.getBoolean("division", false)) {
            temp += 1;
        }

        if(temp > 0) { // proceed
            if(MainMenu.audio) {
                MainMenu.soundPool.play(1, 1, 1, 1, 0, 1f);
            }
            startActivity(new Intent(SettingsPage.this, DifficultyPage.class));
        } else { // none selected
            AlertDialog alertDialog = new AlertDialog.Builder(SettingsPage.this).create();
            alertDialog.setTitle("NO MATH TYPE SELECTED");
            alertDialog.setMessage("PLEASE SELECT AT LEAST ONE MATH TYPE");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

}
