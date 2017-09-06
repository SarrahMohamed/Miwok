package com.example.hp.miwok;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hp on 8/29/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> arraylist,int colorResourceId) {
        super(context, 0, arraylist);
        mColorResourceId=colorResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview = convertView;
        if (listitemview == null) {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentword = getItem(position);
        TextView nameTextView = (TextView) listitemview.findViewById(R.id.mikow_name);
        nameTextView.setText(currentword.w1);
        TextView name2TextView = (TextView) listitemview.findViewById(R.id.english_name);
        name2TextView.setText(currentword.w2);

        ImageView iconView = (ImageView) listitemview.findViewById(R.id.list_item_icon);
        if (currentword.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            iconView.setImageResource(currentword.getImageResourceId());
            // Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);
        } else {

            // Otherwise hide the ImageView (set visibility to GONE)
            iconView.setVisibility(View.GONE);
        }
        View textContainer = listitemview.findViewById(R.id.text_container);
               // Find the color that the resource ID maps to
                       int color = ContextCompat.getColor(getContext(), mColorResourceId);
               // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        return listitemview;
    }
}
