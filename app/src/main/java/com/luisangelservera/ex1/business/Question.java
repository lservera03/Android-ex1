package com.luisangelservera.ex1.business;

import androidx.annotation.StringRes;

public class Question {


    @StringRes
    private int question;
    private boolean solution;


    public Question(@StringRes int question, boolean solution) {
        this.question = question;
        this.solution = solution;
    }

    public int getQuestion() {
        return question;
    }

    public boolean isTrue() {
        return this.solution;
    }
}
