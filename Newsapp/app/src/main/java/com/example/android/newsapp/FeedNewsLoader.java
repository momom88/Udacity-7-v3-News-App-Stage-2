package com.example.android.newsapp;

import android.content.Context;

import java.util.List;

import android.content.AsyncTaskLoader;

public class FeedNewsLoader extends AsyncTaskLoader<List<FeedNews>> {
    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link FeedNewsLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public FeedNewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<FeedNews> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<FeedNews> result = QueryUtils.fetchFeeedNewsData(mUrl);
        return result;
    }
}
