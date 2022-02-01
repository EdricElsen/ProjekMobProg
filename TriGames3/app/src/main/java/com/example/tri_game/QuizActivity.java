package com.example.tri_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private TextView countLabel, userna;
    private TextView questionLabel;
    private Button answerbutton1;
    private Button answerbutton2;
    private Button answerbutton3;
    private Button answerbutton4;


    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {

            {"Eiffel","France","Germany","Spain","Russia"},
            {"Borobudur","Indonesia","Thailand","Italy","England"},
            {"Colloseum","Italy","USA","Japan","Russia"},
            {"Pyramid","Egypt","Belarus","Swiss","Malaysia"},
            {"Eiffel","France","Germany","Spain","Russia"},
            {"Lady Liberty","USA","England","Hunggaria","Romania"},
            {"Taj Mahal","India","Vietnam","Laos","Singapore"},
            {"Pisa","Italy","France","Yugoslavia","Denmark"},
            {"Burj Khalifa","Dubai","China","USA","Malaysia"},
            {"Great Wall","China","Uni Emirates Arab","Egypt","Poland"},
            {"Kremlin","Russia","England","Germany","Colombia"},
            {"Opera House","Australia","Germany","Swiss","Portugal"},
            {"Moai","Chile","Norwegia","Ukraine","Monaco"},
            {"Machu Picchu","Peru","China","France","Lebanon"},
            {"Mount Fuji","Japan","China","Mongolia","South Korea"}

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        answerbutton1 = (Button)findViewById(R.id.answerbutton1);
        answerbutton2 = (Button)findViewById(R.id.answerbutton2);
        answerbutton3 = (Button)findViewById(R.id.answerbutton3);
        answerbutton4 = (Button)findViewById(R.id.answerbutton4);

        userna = findViewById(R.id.quizName);

        String user = getIntent().getStringExtra("name");
        userna.setText(user);

        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY",0);

        Log.v("CATEGORY_TAG", quizCategory + "");



        for (int i = 0; i < quizData.length; i++){

            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            quizArray.add(tmpArray);

        }

        showNextQuiz();
    }

    public void showNextQuiz(){
        countLabel.setText("Question" + quizCount);

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);

        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);


        quiz.remove(0);
        Collections.shuffle(quiz);

        answerbutton1.setText(quiz.get(0));
        answerbutton2.setText(quiz.get(1));
        answerbutton3.setText(quiz.get(2));
        answerbutton4.setText(quiz.get(3));

        quizArray.remove(randomNum);

    }



    public void checkAnswer(View view) {

        Button answerButton = (Button) findViewById(view.getId());
        String buttonText = answerButton.getText().toString();

        String allertTitle;

        if (buttonText.equals(rightAnswer)){

            allertTitle = "Correct!!!";
            rightAnswerCount++;

        }else {

            allertTitle = "Wrong Answer!!!";

        }


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(allertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (quizCount == QUIZ_COUNT){

                    Intent intent = new Intent(getApplicationContext(),QuizResultActivity.class);
                    intent.putExtra("name", userna.getText().toString());
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                }else {

                    quizCount++;
                    showNextQuiz();

                }
            }
        });

        builder.setCancelable(false);
        builder.show();

    }
}