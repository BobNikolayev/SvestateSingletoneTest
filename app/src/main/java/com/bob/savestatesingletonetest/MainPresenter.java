package com.bob.savestatesingletonetest;

public final class MainPresenter {

    private static final MainPresenter instance = new MainPresenter();

    private int counter;

    private MainPresenter(){
        counter = 0;
    }

    public void incrementCounter(){
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public static MainPresenter getInstance() {
        return instance;
    }
}
