package com.jonathan.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Jonathan on 4/9/2016.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        this(UUID.randomUUID());
        // Generate unique identifier
        /*mId = UUID.randomUUID();
        mDate = new Date();*/

    }
    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }


    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }
}
