package com.whyshoudi.earthquakereporter;

/**
 * Created by Saksham Raj Shokeen on 1/9/2018.
 */

public class extendedView {
  private   Double mMagnitude;
  private String mLocation;
  private String mDate;


    public extendedView(Double Magnitude, String Location, String Date){
        mMagnitude=Magnitude;
        mLocation=Location;
        mDate=Date;
    }

    public Double getMagnitude(){
        return mMagnitude;
    }
    public String getLocation(){
        return mLocation;
    }
    public String getDate(){
        return mDate;
    }
}
