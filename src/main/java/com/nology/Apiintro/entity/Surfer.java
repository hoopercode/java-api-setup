package com.nology.Apiintro.entity;

import java.io.Serializable;

public class Surfer implements Serializable {
    private int id;
    private String name;
    private int gnarliness;

    public Surfer(int id, String name, int gnarliness) {
        this.id = id;
        this.name = name;
        this.gnarliness = gnarliness;
    }

    public Surfer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGnarliness() {
        return gnarliness;
    }

    public void setGnarliness(int gnarliness) {
        this.gnarliness = gnarliness;
    }
}
