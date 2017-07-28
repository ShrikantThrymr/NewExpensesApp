package com.example.thrymr.newexpensesapp.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.util.AttributeSet;

import com.example.thrymr.newexpensesapp.R;


/**
 * Created by SHRIKANT on 29/6/17.
 */

public class CustomInputEditText extends TextInputEditText {
    public CustomInputEditText(Context context) {
        super(context);
    }

    public CustomInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomInputEditText);

            String fontName = a.getString(R.styleable.CustomInputEditText_ciefont);

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
