package com.example.thrymr.newexpensesapp.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;

import com.example.thrymr.newexpensesapp.R;


/**
 * Created by SHRIKANT on 29/6/17.
 */
public class CustomTextInputLayout extends TextInputLayout {
    public CustomTextInputLayout(Context context) {
        super(context);

    }

    public CustomTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextInputLayout);

            String fontName = a.getString(R.styleable.CustomTextInputLayout_ctifont);

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
