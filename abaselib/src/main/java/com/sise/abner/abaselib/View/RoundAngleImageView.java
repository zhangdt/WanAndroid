package com.sise.abner.abaselib.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * @author zhangduntai
 * @date 2019/3/11
 */
public class RoundAngleImageView extends AppCompatImageView {

    float width, height;
    private final int r = 5;
    public RoundAngleImageView(Context context) {
        this(context,null);
    }

    public RoundAngleImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RoundAngleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    private void init()
//    {
//        if (Build.VERSION.SDK_INT < 18) {
//            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        }
//    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (width >= r && height > r) {
            Path path = new Path();
            //四个圆角
            path.moveTo(r, 0);
            path.lineTo(width - r, 0);
            path.quadTo(width, 0, width, r);
            path.lineTo(width, height - r);
            path.quadTo(width, height, width - r, height);
            path.lineTo(r, height);
            path.quadTo(0, height, 0, height - r);
            path.lineTo(0, r);
            path.quadTo(0, 0, r, 0);

            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }
}
