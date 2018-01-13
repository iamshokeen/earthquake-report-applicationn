package com.whyshoudi.earthquakereporter;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Saksham Raj Shokeen on 1/9/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<extendedView> {


    public EarthquakeAdapter (Activity context , ArrayList<extendedView> numbers){
        super (context,0,numbers);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //   Called in case there are no recycled view left

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        extendedView Counter = getItem(position);

        TextView Magnitude = (TextView) listItemView.findViewById(R.id.Magnitude);
        TextView PLocation = (TextView) listItemView.findViewById(R.id.PrimaryLoction);
        TextView SLocation = (TextView) listItemView.findViewById(R.id.SeconadryLoction);
        TextView Date = (TextView) listItemView.findViewById(R.id.Date);
        TextView Time = (TextView) listItemView.findViewById(R.id.time);

//      Magnitude display code
        Double mag = Counter.getMagnitude();

        DecimalFormat formatter = new DecimalFormat("0.0");

        GradientDrawable magnitudeCircle = (GradientDrawable) Magnitude.getBackground();

        int magnitudeColor = getMagnitudeColor(Counter.getMagnitude());

        magnitudeCircle.setColor(magnitudeColor);

        Magnitude.setText(formatter.format(mag));

//      Location Display Code
        String Location = Counter.getLocation();

        if (Location.contains("of")==false){

            PLocation.setText(Location);
            SLocation.setText("near");

        }
        else {
            int ofIndex = Location.indexOf("of") + 3;
            String secondary = Location.substring(0, ofIndex);
            String primary = Location.substring(ofIndex, Location.length());

            PLocation.setText(primary);
            SLocation.setText(secondary);

        }

//      Time and Date Display code
        long dateInMS = Counter.getTime();
        Date dateObject = new Date(dateInMS);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss a");
        String dateToDisplay = dateFormatter.format(dateObject);
        String timeToDisplay = timeFormatter.format(dateObject);

        Date.setText(dateToDisplay);
        Time.setText(timeToDisplay);

        return listItemView;
    }

    private int getMagnitudeColor(double Magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(Magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
