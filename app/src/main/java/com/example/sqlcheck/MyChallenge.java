package com.example.sqlcheck;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class MyChallenge {
    private int Cid;
    private int MyCid;
    private String name;
    private byte[] image;
    private String days;
    private String disc;
    private boolean is_Done;
    private String start_date;


    public MyChallenge(String name,  byte[] image,String days,String disc, int Cid,int MyCid) {
        this.name = name;
        this.days = days;
        this.image = image;
        this.disc = disc;
        this.Cid = Cid;
        this.MyCid=MyCid;
        this.is_Done=false;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.start_date=df.format(new Date());
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public int getMyCid() {
        return MyCid;
    }

    public void setMyCid(int myCid) {
        MyCid = myCid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public boolean getIs_Done() {
        return is_Done;
    }

    public void setIs_Done(boolean is_Done) {
        this.is_Done = is_Done;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
}
