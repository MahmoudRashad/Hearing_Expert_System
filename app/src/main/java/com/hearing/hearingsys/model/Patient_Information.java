package com.hearing.hearingsys.model;

/**
 * Created by Ahmed on 5/26/2018.
 */

public class Patient_Information {
    public static final String TABLE_PATIENT = "patient";


    int patient_id;
    String patient_name ;
    String patient_age ;
    String mender_doctor ;
    String PHONE ;


    public static String getTablePatient() {
        return TABLE_PATIENT;
    }
    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(String patient_age) {
        this.patient_age = patient_age;
    }

    public String getMender_doctor() {
        return mender_doctor;
    }

    public void setMender_doctor(String mender_doctor) {
        this.mender_doctor = mender_doctor;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }
}
