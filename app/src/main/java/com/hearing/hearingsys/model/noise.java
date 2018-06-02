package com.hearing.hearingsys.model;

public class   noise {
int id ;
String path ,Name ;
int test_id ;

    public noise() {
    }

    public noise(int id, String path, String name) {
        this.id = id;
        this.path = path;
        Name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return "/hearingsystem/noise/"+getName()+".mp3";

    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
