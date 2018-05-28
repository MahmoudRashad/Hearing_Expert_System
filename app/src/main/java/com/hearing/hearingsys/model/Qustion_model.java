package com.hearing.hearingsys.model;

import java.util.ArrayList;

public class Qustion_model {
SIGNAL signal;
noise noise;
ArrayList<Image> choices;
int corr_img_id;

    public Qustion_model(SIGNAL signal, com.hearing.hearingsys.model.noise noise) {
        this.signal = signal;
        this.noise = noise;
     load_random_image();
    }

    private void load_random_image() {
        //TODO load image randomly
        // contian correct image
        //set corr_img_id
    }

    public SIGNAL getSignal() {
        return signal;
    }

    public void setSignal(SIGNAL signal) {
        this.signal = signal;
    }

    public com.hearing.hearingsys.model.noise getNoise() {
        return noise;
    }

    public void setNoise(com.hearing.hearingsys.model.noise noise) {
        this.noise = noise;
    }

    public ArrayList<Image> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Image> choices) {
        this.choices = choices;
    }

    public int getCorr_img_id() {
        return corr_img_id;
    }

    public void setCorr_img_id(int corr_img_id) {
        this.corr_img_id = corr_img_id;
    }
}
