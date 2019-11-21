package com.example.currencyconvert;

public class Spinner {
    private String name;
    private int image;
    private double rate;
    private String currency;

    public Spinner(String name, int image, double rate, String currency) {
        this.name = name;
        this.image = image;
        this.rate = rate;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
