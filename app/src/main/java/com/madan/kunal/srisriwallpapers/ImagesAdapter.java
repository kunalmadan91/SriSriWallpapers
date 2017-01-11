package com.madan.kunal.srisriwallpapers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by KUNAL on 08-10-2016.
 */


public class ImagesAdapter extends ArrayAdapter<Image> {

    Context mContext;

    public ImagesAdapter(Context context, List<Image> im) {
        super(context,0, im);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Image im = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.wallpaper, parent, false);
        }

        ImageView view = (ImageView) convertView.findViewById(R.id.poster_image);

        //Picasso.with(mContext).load(im.getImageId()).into(view);
        //view.setImageResource(im.getImageId());
        Glide.with(mContext).load(im.getImageId()).into(view);

        return convertView;
    }
}
