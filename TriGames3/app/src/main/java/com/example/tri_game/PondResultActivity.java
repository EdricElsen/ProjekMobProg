package com.example.tri_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PondResultActivity extends AppCompatActivity {
    private TextView usName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pond_result);

        TextView curScore = findViewById(R.id.curScore);
        TextView highScore = findViewById(R.id.highScore);

        Button tryAgain = findViewById(R.id.tryAgain);
        Button backToMenu = findViewById(R.id.BtnBackToMenu);

        usName = findViewById(R.id.namePond);

        String a1,a2;
        a1 = getIntent().getStringExtra("name");
        a2 = "Pond";

        usName.setText(a1);

//        Score
        int score = getIntent().getIntExtra("score", 0);
        curScore.setText(score + "");

        SharedPreferences sharedPreferences = getSharedPreferences("GameData", Context.MODE_PRIVATE);
        int high = sharedPreferences.getInt("HighScore",0);

        if (score > high){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("HighScore", score);
            editor.apply();

            highScore.setText("High Score: " + score);
        }
        else {
            highScore.setText("High Score: " + high);
        }

//        Button
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PondActivity.class);
                i.putExtra("name", usName.getText().toString());
                startActivity(new Intent(getApplicationContext(), ViewScoreActivity.class));
                Cart.additem(a1,a2,curScore.getText().toString());
                startActivity(i);
            }
        });


        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("name", usName.getText().toString());
                startActivity(new Intent(getApplicationContext(), ViewScoreActivity.class));
                Cart.additem(a1,a2,curScore.getText().toString());
                startActivity(i);
            }
        });
    }
}