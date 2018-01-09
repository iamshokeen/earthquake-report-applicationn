package com.whyshoudi.earthquakereporter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Earthquake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);


        // Create a fake list of earthquake locations.
        ArrayList<extendedView> earthquakes = new ArrayList<extendedView>();
        earthquakes.add(new extendedView(6.7, "San Francisco", "24 october"));
        earthquakes.add(new extendedView(6.7, "San Francisco", "24 october"));
        earthquakes.add(new extendedView(6.7, "San Francisco", "24 october"));
        earthquakes.add(new extendedView(6.7, "San Francisco", "24 october"));
        earthquakes.add(new extendedView(6.7, "San Francisco", "24 october"));
        earthquakes.add(new extendedView(6.7, "San Francisco", "24 october"));
        earthquakes.add(new extendedView(6.7, "San Francisco", "24 october"));
        earthquakes.add(new extendedView(6.7, "San Francisco", "24 october"));
        earthquakes.add(new extendedView(6.7, "San Francisco", "24 october"));



        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(this,earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
