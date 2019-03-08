package com.sise.abner.abaselib.Glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

import androidx.annotation.RequiresApi;

/**
 * Created by Abner on 2017/12/18.
 */

public class GlideCircleTransform extends BitmapTransformation {
    int radius = 0;

    public GlideCircleTransform(Context context) {
        super();
    }

    public GlideCircleTransform(Context context, int radius) {
        super();
        this.radius = radius;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return circleCrop(pool, toTransform);
    }

    private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;
        int size = Math.min(source.getWidth(), source.getHeight());
        Bitmap result = null;

        if (radius == 0) {
            result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }
        } else {
            result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(source.getWidth(),  source.getHeight(), Bitmap.Config.ARGB_8888);
            }
        }

        BitmapShader shader = new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        if (radius!=0)
//        {
//            int width = (source.getWidth()) / 2;
//            int height = (source.getHeight()) / 2;
//            if (width != 0 || height != 0) {
//                Matrix matrix = new Matrix();
//                matrix.setTranslate((float) (-width), (float) (-height));
//                shader.setLocalMatrix(matrix);
//            }
//        }



        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(shader);
        paint.setAntiAlias(true);
        float r = size / 2f;
        if (radius == 0) {
            canvas.drawCircle(r, r, r - 4, paint);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                canvas.drawRoundRect(0, 0, canvas.getWidth(), canvas.getHeight(), radius, radius, paint);
            }
        }
//        paint = new Paint();
//        paint.setColor(Color.WHITE);
//        paint.setStrokeWidth(4);
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawCircle(r, r, r-4, paint);
        return result;
    }


    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {

    }
}
