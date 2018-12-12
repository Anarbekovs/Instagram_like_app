package com.syezdsultanov.instagram_like_app.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import java.util.List;

public class ImageArrayAdapter extends ArrayAdapter<Image> {

    Context mContext;

    public ImageArrayAdapter(@NonNull Context context, int resource, @NonNull List<Image> objects) {
        super(context, resource, objects);
        this.mContext = context;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Image getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(@Nullable Image item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {

            imageView = new ImageView(getContext());
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setPadding(1, 1, 1, 1);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        } else {
            imageView = (ImageView) convertView;
        }

        Image image = getItem(position);

        if (image != null) {

            if (!image.getImage_url().isEmpty()) {
                Glide.with(getContext()).load(image.getImage_url()).into(imageView);
            }
        }

        return imageView;
    }

}





