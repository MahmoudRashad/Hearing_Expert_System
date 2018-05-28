package com.hearing.hearingsys.model;

public class SIGNAL {
    public   String SIGNALS_ID = "signals_id";
    public   String SIGNALS_TEXT = "signals_text";
    public   String SIGNALS_TEST_ID = "signals_test_id";
    public   String SIGNALS_IMAGE_ID = "signals_Image_id";

    public SIGNAL(String SIGNALS_ID, String SIGNALS_TEXT, String SIGNALS_TEST_ID, String SIGNALS_IMAGE_ID) {
        this.SIGNALS_ID = SIGNALS_ID;
        this.SIGNALS_TEXT = SIGNALS_TEXT;
        this.SIGNALS_TEST_ID = SIGNALS_TEST_ID;
        this.SIGNALS_IMAGE_ID = SIGNALS_IMAGE_ID;
    }

    public String getSIGNALS_ID() {
        return SIGNALS_ID;
    }

    public void setSIGNALS_ID(String SIGNALS_ID) {
        this.SIGNALS_ID = SIGNALS_ID;
    }

    public String getSIGNALS_TEXT() {
        return SIGNALS_TEXT;
    }

    public void setSIGNALS_TEXT(String SIGNALS_TEXT) {
        this.SIGNALS_TEXT = SIGNALS_TEXT;
    }

    public String getSIGNALS_TEST_ID() {
        return SIGNALS_TEST_ID;
    }

    public void setSIGNALS_TEST_ID(String SIGNALS_TEST_ID) {
        this.SIGNALS_TEST_ID = SIGNALS_TEST_ID;
    }

    public String getSIGNALS_IMAGE_ID() {
        return SIGNALS_IMAGE_ID;
    }

    public void setSIGNALS_IMAGE_ID(String SIGNALS_IMAGE_ID) {
        this.SIGNALS_IMAGE_ID = SIGNALS_IMAGE_ID;
    }
}
