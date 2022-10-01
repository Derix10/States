package com.example.myapplication;

public class State {
    private String name;
    private String capital;
    private String flagResource;

    public State(String name, String capital, String flagResource) {
        this.name = name;
        this.capital = capital;
        this.flagResource = flagResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlagResource() {
        return flagResource;
    }

    public void setFlagResource(String flagResource) {
        this.flagResource = flagResource;
    }
}
