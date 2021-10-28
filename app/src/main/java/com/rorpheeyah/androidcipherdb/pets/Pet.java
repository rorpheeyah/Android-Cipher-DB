package com.rorpheeyah.androidcipherdb.pets;

public class Pet {
    private int id;
    private String name;
    private boolean gender;
    private double distance;
    private long createdDate;
    private String behavior;
    private String imgUrl;
    private int dob;

    public Pet(int id, String name, boolean gender, double distance, long createdDate, String behavior, String imgUrl) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.distance = distance;
        this.createdDate = createdDate;
        this.behavior = behavior;
        this.imgUrl = imgUrl;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }
}
