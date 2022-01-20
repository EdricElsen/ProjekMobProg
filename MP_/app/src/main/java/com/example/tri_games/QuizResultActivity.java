package com.example.tri_games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {
    private Button returnTop;
    private TextView endname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        returnTop = findViewById(R.id.returnTop);
        endname = findViewById(R.id.quizendname);

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        TextView totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);

        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore",0);
        totalScore += score;


        String a1,a2;
        a1 = getIntent().getStringExtra("name");
        a2 = "Capital";
        endname.setText(a1);

        resultLabel.setText(score + " / 5");
        totalScoreLabel.setText("Total Score : " + totalScore);


        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();

        returnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("name", endname.getText().toString());
                startActivity(new Intent(getApplicationContext(), ViewScoreActivity.class));
                Cart.additem(a1,a2,totalScoreLabel.getText().toString());
                startActivity(i);
            }
        });

    }


//    public void returnTop(View view) {
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        Cart.additem(a1,a2,totalScore.getText().toString());
//        startActivity(intent);
//
//    }
}