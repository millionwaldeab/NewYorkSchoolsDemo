package com.example.data_layer;

public class Schools {

    private String mDbn, mName, mBoro, mOverview, mTenthSeats, mAcademicOpportunists1, mAcademicOpportunists2;

    public Schools(){}

    public Schools(String mDbn, String mName, String mBoro, String mOverview, String mTenthSeats, String mAcademicOpportunists1, String mAcademicOpportunists2) {
        this.mDbn = mDbn;
        this.mName = mName;
        this.mBoro = mBoro;
        this.mOverview = mOverview;
        this.mTenthSeats = mTenthSeats;
        this.mAcademicOpportunists1 = mAcademicOpportunists1;
        this.mAcademicOpportunists2 = mAcademicOpportunists2;
    }

    public String getmDbn() {
        return mDbn;
    }

    public void setmDbn(String mDbn) {
        this.mDbn = mDbn;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmBoro() {
        return mBoro;
    }

    public void setmBoro(String mBoro) {
        this.mBoro = mBoro;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public String getmTenthSeats() {
        return mTenthSeats;
    }

    public void setmTenthSeats(String mTenthSeats) {
        this.mTenthSeats = mTenthSeats;
    }

    public String getmAcademicOpportunists1() {
        return mAcademicOpportunists1;
    }

    public void setmAcademicOpportunists1(String mAcademicOpportunists1) {
        this.mAcademicOpportunists1 = mAcademicOpportunists1;
    }

    public String getmAcademicOpportunists2() {
        return mAcademicOpportunists2;
    }

    public void setmAcademicOpportunists2(String mAcademicOpportunists2) {
        this.mAcademicOpportunists2 = mAcademicOpportunists2;
    }
}
