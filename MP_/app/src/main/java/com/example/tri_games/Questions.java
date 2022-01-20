package com.example.tri_games;

import java.util.Random;

public class Questions {
    private int a;
    private int b;
    private int ans;
    private int [] ansArray;
    private int ansPosition;

    //buat pertanyaannya semakin susah
    private int upperLimit;
    //
    private String questionPhrase;
    //buat random number
    public Questions(int upperLimit) {
        this.upperLimit = upperLimit;
        Random randomNumber = new Random();
        this.a = randomNumber.nextInt(upperLimit);
        this.b = randomNumber.nextInt(upperLimit);
        this.ans = this.a + this.b;
        this.questionPhrase = a + "+" + b ;

        this.ansPosition = randomNumber.nextInt(4);
        this.ansArray = new int[]{0,1,2,3};

        this.ansArray[0] = ans + 1;
        this.ansArray[1] = ans + 10;
        this.ansArray[2] = ans - 5;
        this.ansArray[3] = ans - 2;

        this.ansArray = shuffleArray(this.ansArray);

        ansArray[ansPosition] = ans;

    }

    private int [] shuffleArray(int[] array){
        int index,temp;
        Random randomNumberGenerator = new Random();

        for(int i = array.length -1;i>0;i--){
            index = randomNumberGenerator.nextInt(i+1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public int[] getAnsArray() {
        return ansArray;
    }

    public void setAnsArray(int[] ansArray) {
        this.ansArray = ansArray;
    }

    public int getAnsPosition() {
        return ansPosition;
    }

    public void setAnsPosition(int ansPosition) {
        this.ansPosition = ansPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
