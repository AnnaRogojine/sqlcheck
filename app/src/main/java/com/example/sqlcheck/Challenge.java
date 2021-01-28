package com.example.sqlcheck;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class Challenge {
    private int id;
    private String name;
    private byte[] image;
    private String days;
    private String disc;

    public Challenge(String name,  byte[] image,String days,String disc, int id) {
        this.name = name;
        this.days = days;
        this.image = image;
        this.disc = disc;
        this.id = id;
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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
