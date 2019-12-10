package com.udacity.gradle.builditbigger.services;

public interface OnEventListener<T> {
    void onPreExecution();
    void onPostExecution(T result);
}
