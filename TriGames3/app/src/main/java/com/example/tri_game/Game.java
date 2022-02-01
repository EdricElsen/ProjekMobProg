package com.example.tri_game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Questions> questions;
    private int numCor;
    private int numInc;
    private int totalQuestion;
    private int score;
    private Questions currentQuestions;

    public  Game() {
        numCor = 0;
        numInc = 0;
        totalQuestion = 0;
        score = 0;
        currentQuestions = new Questions(50);
        questions = new ArrayList<Questions>();
    }

    public void makeNewQuestion() {
        currentQuestions = new Questions(totalQuestion * 2 + 5);
        totalQuestion++;
        questions.add(currentQuestions);
    }

    public boolean checkAnswer(int submittedAnswer) {
        boolean isCorrect;
        if (currentQuestions.getAns() == submittedAnswer) {
            numCor++;
            isCorrect=true;
        }
        else {
            numInc++;
            isCorrect=false;
        }
        score = numCor * 10 - numInc * 10;
        return isCorrect;
    }
    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public int getNumCor() {
        return numCor;
    }

    public void setNumCor(int numCor) {
        this.numCor = numCor;
    }

    public int getNumInc() {
        return numInc;
    }

    public void setNumInc(int numInc) {
        this.numInc = numInc;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Questions getCurrentQuestions() {
        return currentQuestions;
    }

    public void setCurrentQuestions(Questions currentQuestions) {
        this.currentQuestions = currentQuestions;
    }
}
