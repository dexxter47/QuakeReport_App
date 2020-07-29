package com.example.android.quakereport;

public class Earthquake {
    private Double mMagnitude;
    private Long mTimeinMilliseconds;
    private String mLocation;
    private String mUrl;
    public Earthquake(Double magnitude,String location,Long timeinMilliseconds,String url){
        mMagnitude=magnitude;
        mTimeinMilliseconds=timeinMilliseconds;
        mLocation=location;
        mUrl = url;
    }

    public String getmUrl() {
        return mUrl;
    }

    public Double getMagnitude() {
        return mMagnitude;
    }

    public Long getTimeinMilliseconds() {
        return mTimeinMilliseconds;
    }

    public String getLocation() {
        return mLocation;
    }
}
