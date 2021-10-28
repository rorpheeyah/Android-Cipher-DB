package com.rorpheeyah.androidcipherdb.db_pets;

public class Pet {
    public long mID;
    public String mName;
    public int mRanking;
    public double mTime;

    public Pet() {
    }

    public Pet(long id, String name, int ranking, float time) {
        mID = id;
        mName = name;
        mRanking = ranking;
        mTime = time;
    }
}
