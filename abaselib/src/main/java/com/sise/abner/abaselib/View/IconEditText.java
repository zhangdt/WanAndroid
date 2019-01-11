    package com.sise.abner.abaselib.View;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sise.abner.abaselib.R;


    /**
 * Created by Abner on 2017/5/26.
 */

public class IconEditText extends LinearLayout implements View.OnClickListener, View.OnFocusChangeListener {
    private ImageView mIconImageView;
    private EditText mEditText;
    private Button mButton;
    private TextView mLeftTextView;

    private String edittextString;


    public IconEditText(Context context) {
        super(context);
    }

    public IconEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.iconedittext_layout, this, true);
        mIconImageView = (ImageView) findViewById(R.id.iconedittext_imageview);
        mButton = (Button) findViewById(R.id.iconedittext_button);
        mEditText = (EditText) findViewById(R.id.iconedittext_edittext);
        mLeftTextView = (TextView) findViewById(R.id.iconedittext_left_textview);


        disposeAttrs(context, attrs);
        mButton.setBackgroundResource(R.drawable.ic_cancel_black_24dp);
        mButton.setVisibility(View.INVISIBLE);
        mButton.setOnClickListener(this);
        mEditText.setOnFocusChangeListener(this);

    }

    public IconEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //处理属性值
    private void disposeAttrs(Context context, AttributeSet attrs) {
        Resources r = getResources();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.iconEditTextAttrs);
        if (typedArray != null) {
            String type = typedArray.getString(R.styleable.iconEditTextAttrs_type);
            int iconSrc = typedArray.getResourceId(R.styleable.iconEditTextAttrs_icon_src, Color.WHITE);

            if (iconSrc == Color.WHITE)mIconImageView.setVisibility(View.GONE);
            else mIconImageView.setBackgroundResource(iconSrc);

            edittextString = typedArray.getString(R.styleable.iconEditTextAttrs_edit_string);
            mEditText.setHint(edittextString);
            if (type!=null) {
                if (type.equals("phone")) {
                    mEditText.setInputType(InputType.TYPE_CLASS_PHONE);
                } else if (type.equals("password")) {
                    mEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }

            float editWidth = typedArray.getDimension(R.styleable.iconEditTextAttrs_edit_width,586);
            mEditText.setWidth((int) editWidth);

            float editTextSize = typedArray.getDimensionPixelSize(R.styleable.iconEditTextAttrs_edit_textsize,15);
            mEditText.setTextSize(editTextSize);

            int leftTextViewSize = typedArray.getDimensionPixelSize(R.styleable.iconEditTextAttrs_left_textsize,15);
            mLeftTextView.setTextSize(leftTextViewSize);

            String leftTvString = typedArray.getString(R.styleable.iconEditTextAttrs_left_text);
            mLeftTextView.setText(leftTvString);

        }
        typedArray.recycle();
    }

    public TextView getmLeftTextView() {
        return mLeftTextView;
    }

    public Button getmButton() {
        return mButton;
    }

    public EditText getmEditText() {
        return mEditText;
    }

    public ImageView getmIconImageView() {
        return mIconImageView;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.iconedittext_button) {
            mEditText.setText("");
            mEditText.setFocusable(true);
            mEditText.setFocusableInTouchMode(true);
            mEditText.requestFocus();
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int i = v.getId();
        if (i == R.id.iconedittext_edittext) {
            //如果失去焦点隐藏clear按钮，获得着焦点显示
            if (hasFocus) {
                mButton.setVisibility(View.VISIBLE);
            } else {
                mButton.setVisibility(View.INVISIBLE);
            }
        }
    }
}
