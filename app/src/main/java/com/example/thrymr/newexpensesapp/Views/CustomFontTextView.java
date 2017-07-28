package com.example.thrymr.newexpensesapp.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.example.thrymr.newexpensesapp.R;


/**
 * Created by SHRIKANT on 29/6/17.
 */

public class CustomFontTextView extends android.support.v7.widget.AppCompatTextView {

    String fontName;

    public CustomFontTextView(Context context) {
        super(context);
    }


    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);

    }


    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);

            fontName = a.getString(R.styleable.CustomFontTextView_font);

            try {
                if (fontName != null) {
                    Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName);
                    setTypeface(myTypeface);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            a.recycle();
        }
    }

}
