package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class Joke {

    private String mJoke;

    public String getData() {
        return mJoke;
    }

    public void setData(String joke) {
        mJoke = joke;
    }
}