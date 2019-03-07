package ir.parsapp.apptest;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewIranSans extends android.support.v7.widget.AppCompatTextView {


    public TextViewIranSans(Context context, AttributeSet attrs) {
        super(context, attrs);


        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/IranSansLight.ttf"));
    }
}
