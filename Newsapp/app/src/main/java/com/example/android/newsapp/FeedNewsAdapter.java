package com.example.android.newsapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newsapp.FeedNews;
import com.example.android.newsapp.R;

import java.util.Date;
import java.util.List;

public class FeedNewsAdapter extends ArrayAdapter<FeedNews> {
    public FeedNewsAdapter(Context context, List<FeedNews> earthquakes) {
        super(context, 0, earthquakes);
    }
    // Create class ViewHolder for efficient memory usage
    static class ViewHolder {
        private TextView mTitleTextView;
        private TextView mAuthorTextView;
        private TextView mDataTextView;
        private TextView mSectionTextView;
        private int mPosition;
    }

    /**
     * Returns a list item view that displays information about the feed news at the given position
     * in the list of feeds news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.feed_news_list_item, parent, false);
            holder = new ViewHolder();
            holder.mTitleTextView = convertView.findViewById(R.id.title);
            holder.mAuthorTextView = convertView.findViewById(R.id.author);
            holder.mDataTextView = convertView.findViewById(R.id.date);
            holder.mSectionTextView = convertView.findViewById(R.id.section);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // Find the feed news at the given position in the list of feed news
        FeedNews currentFeedNews = getItem(position);

        // Display the INFO of the current feed news in that all TextView
        holder.mTitleTextView.setText(currentFeedNews.getTitle());
        holder.mAuthorTextView.setText(currentFeedNews.getAuthor());
        holder.mDataTextView.setText(currentFeedNews.getDate());
        holder.mSectionTextView.setText(currentFeedNews.getSectionName());

        // Return the list item view that is now showing the appropriate data
        return convertView;
    }
}
