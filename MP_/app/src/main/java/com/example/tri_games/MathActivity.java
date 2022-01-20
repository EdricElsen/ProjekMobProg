package com.example.tri_games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MathActivity extends AppCompatActivity {

    Button btn_start,btn_ans1,btn_ans2,btn_ans3,btn_ans4,btn_menu;
    TextView tx_score, tx_timer, tx_question, tx_mes,userMath;
    ProgressBar prog_timer;

    Game g = new Game();

    int secondRemaining = 30;

    CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondRemaining--;
            tx_timer.setText(Integer.toString(secondRemaining) + " Sec");
            prog_timer.setProgress(30-secondRemaining);

            userMath = findViewById(R.id.userMath);

            String user = getIntent().getStringExtra("name");
            userMath.setText(user);

            String a1,a2;
            a1 = getIntent().getStringExtra("name");
            a2 = "Math";

            btn_menu.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("name", userMath.getText().toString());
                    startActivity(new Intent(getApplicationContext(), ViewScoreActivity.class));
                    Cart.additem(a1,a2,tx_score.getText().toString());
                    startActivity(i);
                }
            });
        }

        @Override
        public void onFinish() {
            btn_ans1.setEnabled(false);
            btn_ans2.setEnabled(false);
            btn_ans3.setEnabled(false);
            btn_ans4.setEnabled(false);
            tx_mes.setText("Times Out " + g.getNumCor() + "/" + (g.getTotalQuestion()-1));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                }

            },4000);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        btn_start = findViewById(R.id.btn_start);
        btn_ans1 = findViewById(R.id.btn_ans1);
        btn_ans2 = findViewById(R.id.btn_ans2);
        btn_ans3 = findViewById(R.id.btn_ans3);
        btn_ans4  = findViewById(R.id.btn_ans4);
        btn_menu = findViewById(R.id.btnMenu);

        tx_mes = findViewById(R.id.tx_mes);
        tx_score = findViewById(R.id.tx_score);
        tx_question = findViewById(R.id.tx_question);
        tx_timer = findViewById(R.id.tx_timer);
        prog_timer = findViewById(R.id.prog_timer);
        tx_timer.setText("0sec");
        tx_question.setText("");
        tx_mes.setText("Press Start");
        tx_score.setText("0Point");

        View.OnClickListener startButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button start_button =(Button) v;
                start_button.setVisibility(View.INVISIBLE);

                secondRemaining = 30;
                g = new Game();
                nextTurn();
                timer.start();
            }
        };

        View.OnClickListener answerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked =(Button) v;

                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());

                g.checkAnswer(answerSelected);
                tx_score.setText(Integer.toString(g.getScore()) + " Point");
                nextTurn();

            }
        };



        btn_start.setOnClickListener(startButton);
        btn_ans1.setOnClickListener(answerButton);
        btn_ans2.setOnClickListener(answerButton);
        btn_ans3.setOnClickListener(answerButton);
        btn_ans4.setOnClickListener(answerButton);
    }

    private void nextTurn() {
        g.makeNewQuestion();
        int [] answer = g.getCurrentQuestions().getAnsArray();
        btn_ans1.setText(Integer.toString(answer[0]));
        btn_ans2.setText(Integer.toString(answer[1]));
        btn_ans3.setText(Integer.toString(answer[2]));
        btn_ans4.setText(Integer.toString(answer[3]));
        btn_ans1.setEnabled(true);
        btn_ans2.setEnabled(true);
        btn_ans3.setEnabled(true);
        btn_ans4.setEnabled(true);

        tx_question.setText(g.getCurrentQuestions().getQuestionPhrase());

        tx_mes.setText(g.getNumCor()+"/"+g.getTotalQuestion());
    }
}