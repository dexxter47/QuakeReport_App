package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private String mUrl;
    public EarthquakeLoader(Context context,String url) {
        super(context);
        mUrl= url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
    @Override
    public List<Earthquake> loadInBackground() {
        // TODO: Implement this method
        if(mUrl == null){
            return null;
        }
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
