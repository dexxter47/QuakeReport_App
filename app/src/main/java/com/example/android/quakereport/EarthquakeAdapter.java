package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String separator = " of ";
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list, parent, false);
        }
        Earthquake currentEarthquake = getItem(position);

        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(formattedMagnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String location = currentEarthquake.getLocation();
        String proximity;
        String exactLocation;

        if(location.contains("of")) {
            String[] parts = location.split(separator);
            proximity = parts[0] + separator;
            exactLocation = parts[1];
        }
        else{
            proximity="Near the";
            exactLocation = location;
        }
        Log.i("EarthQuakeActivity",proximity);
        Log.i("EarthQuakeActivity",exactLocation);

        TextView exactLocationTextView = (TextView) listItemView.findViewById(R.id.location_second_line);
        exactLocationTextView.setText(exactLocation);

        TextView proximityTextView = (TextView) listItemView.findViewById(R.id.location_first_line);
        proximityTextView.setText(proximity);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        Date dateObject = new Date(currentEarthquake.getTimeinMilliseconds());
        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private int getMagnitudeColor(Double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor =(int) Math.floor(magnitude);
        switch(magnitudeFloor){
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
