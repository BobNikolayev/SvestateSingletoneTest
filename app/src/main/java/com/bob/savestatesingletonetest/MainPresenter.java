package com.bob.savestatesingletonetest;

import java.io.Serializable;

public final class MainPresenter {

    private static final MainPresenter instance = new MainPresenter();

    private int counter;

    private MainPresenter(){
        counter = 0;
    }

    public void incrementCounter(){
        counter++;
    }

    public void setCounter(String count){
        counter = Integer.parseInt(count);
    }

    public int getCounter() {
        return counter;
    }

    public static MainPresenter getInstance() {
        return instance;
    }
}
