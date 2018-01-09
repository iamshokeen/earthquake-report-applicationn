package com.whyshoudi.earthquakereporter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        TextView Location = (TextView) listItemView.findViewById(R.id.Loction);
        TextView Date = (TextView) listItemView.findViewById(R.id.Date);

        Location.setText(Counter.getLocation());
        Date.setText(Counter.getDate());
        Magnitude.setText(String.valueOf(Counter.getMagnitude()));

        return listItemView;
    }
}
