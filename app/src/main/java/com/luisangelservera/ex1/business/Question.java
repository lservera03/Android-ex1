package com.luisangelservera.ex1.business;

public class Question {


    private int question;
    private boolean solution;


    public Question(int question, boolean solution) {
        this.question = question;
        this.solution = solution;
    }

    public int getQuestion() {
        return question;
    }

    public boolean isTrue(){
        return this.solution;
    }
}
