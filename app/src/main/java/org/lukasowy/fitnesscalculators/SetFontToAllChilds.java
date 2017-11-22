package org.lukasowy.fitnesscalculators;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Łukasz on 2017-11-22.
 */

public class SetFontToAllChilds {

    //Set fonts for all activity
    public static void setFontToAllChilds(ViewGroup myMostParentLayout, Typeface tf) {
        int childCount = myMostParentLayout.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            View child = myMostParentLayout.getChildAt(i);

            if (child instanceof ViewGroup)
                setFontToAllChilds((ViewGroup) child, tf);
            else if (child instanceof TextView)
                ((TextView) child).setTypeface(tf);
        }
    }
}
