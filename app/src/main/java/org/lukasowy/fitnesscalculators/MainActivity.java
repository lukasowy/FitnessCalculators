package org.lukasowy.fitnesscalculators;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;
    LinearLayout allScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        allScreen = (LinearLayout) findViewById(R.id.allScreen);

        //Set fonts for all activity
        Typeface textFont = Typeface.createFromAsset(this.getAssets(), "LobsterTwo-Italic.otf");
        setFontToAllChilds(allScreen, textFont);

        //Set Event
        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(final GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = null;
                    if (cardView == mainGrid.getChildAt(0)) {
                        intent = new Intent(MainActivity.this, BMIActivity.class);
                    } else if (cardView == mainGrid.getChildAt(1)) {
                        intent = new Intent(MainActivity.this, WaterActivity.class);
                    } else if (cardView == mainGrid.getChildAt(2)) {
                        intent = new Intent(MainActivity.this, MaxHeartRateActivity.class);
                    } else if (cardView == mainGrid.getChildAt(3)) {
                        intent = new Intent(MainActivity.this, MetabolicActivity.class);
                    } else if (cardView == mainGrid.getChildAt(4)) {
                        intent = new Intent(MainActivity.this, ProteinActivity.class);
                    } else {
                        intent = new Intent(MainActivity.this, CreatineActivity.class);
                    }
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    //Set fonts for all activity
    private void setFontToAllChilds(ViewGroup myMostParentLayout, Typeface tf) {
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