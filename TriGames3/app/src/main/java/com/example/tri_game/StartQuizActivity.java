package com.example.tri_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartQuizActivity extends AppCompatActivity {
        private TextView tes;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_start_quiz);
            tes = findViewById(R.id.tesquiz);


            String user = getIntent().getStringExtra("name");
            tes.setText(user);
        }



        public void startQuiz(View view) {
            int quizCategory = 0;


            Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
            intent.putExtra("name", tes.getText().toString());
            intent.putExtra("QUIZ_CATEGORY", quizCategory);
            startActivity(intent);


        }
}