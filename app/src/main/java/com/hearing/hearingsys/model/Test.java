package com.hearing.hearingsys.model;

/**
 * Created by Ahmed on 5/26/2018.
 */

public class Test {

    // test table name
    public static final String TABLE_TEST = "test";

    // patient Table Columns names
    String test_id;
    String patient_id;
    String doctor_id;
    String noise_type;
    String patient_degree;

    public static String getTableTest() {
        return TABLE_TEST;
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getNoise_type() {
        return noise_type;
    }

    public void setNoise_type(String noise_type) {
        this.noise_type = noise_type;
    }

    public String getPatient_degree() {
        return patient_degree;
    }

    public void setPatient_degree(String patient_degree) {
        this.patient_degree = patient_degree;
    }
}
