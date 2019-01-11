package com.sise.abner.abaselib.util;

;
import android.graphics.Canvas;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import android.text.Html.ImageGetter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.sise.abner.abaselib.SDKBaseLib;


/**
 * Created by Abner on 2017/11/15.
 */

public class MyImageGetter implements ImageGetter {
    private TextView textView;

    public MyImageGetter(TextView textView) {
        this.textView = textView;
    }


    public Drawable getDrawable(String source) {
        final UrlDrawable urlDrawable = new UrlDrawable();
        Glide.with(SDKBaseLib.application)
                .load(source)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        float s = getScale(resource);
                        resource.setBounds(0, 0, (int) (resource.getIntrinsicWidth() * s), (int) (resource.getIntrinsicHeight() * s));
                        urlDrawable.setBounds(0, 0, (int) (resource.getIntrinsicWidth() * s), (int) (resource.getIntrinsicHeight() * s));
                        urlDrawable.drawable = resource;
                        MyImageGetter.this.textView.invalidate();
                        MyImageGetter.this.textView.setText(textView.getText());
                    }
                });

        return urlDrawable;
    }


    @SuppressWarnings("deprecation")
    public class UrlDrawable extends BitmapDrawable {
        protected Drawable drawable;

        @Override
        public void draw(Canvas canvas) {
            // override the draw to facilitate refresh function later
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    private float getScale(Drawable drawable) {
        View container = textView;
        float maxWidth = container.getWidth();
        float originalDrawableWidth = drawable.getIntrinsicWidth();
        return maxWidth / originalDrawableWidth;
    }


}