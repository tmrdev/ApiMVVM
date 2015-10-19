package org.timreynolds.apimvvm.util;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import android.databinding.ObservableField;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * BindableFieldTarget
 */
public class BindableFieldTarget implements Target {

    private ObservableField<Drawable> observableField;
    private Resources resources;

    public BindableFieldTarget(ObservableField<Drawable> observableField, Resources resources) {
        this.observableField = observableField;
        this.resources = resources;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        observableField.set(new BitmapDrawable(resources, bitmap));
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {
        observableField.set(errorDrawable);
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {
        observableField.set(placeHolderDrawable);
    }
}
