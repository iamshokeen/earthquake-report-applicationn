package com.whyshoudi.earthquakereporter;

/**
 * Created by Saksham Raj Shokeen on 1/9/2018.
 */

public class extendedView {
  private   Double mMagnitude;
  private String mLocation;
  private long mTime;
  private String mUrl;


    public extendedView(Double Magnitude, String Location, long Time, String Url){
        mMagnitude=Magnitude;
        mLocation=Location;
        mTime=Time;
        mUrl=Url;
    }

    public Double getMagnitude(){
        return mMagnitude;
    }
    public String getLocation(){
        return mLocation;
    }
    public long getTime(){
        return mTime;
    }
    public String getUrl(){return mUrl;}
}
