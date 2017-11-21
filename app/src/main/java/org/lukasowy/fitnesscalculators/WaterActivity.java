package org.lukasowy.fitnesscalculators;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WaterActivity extends AppCompatActivity {
    TextView titleViewWater;
    Typeface titleFont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        titleViewWater = (TextView) findViewById(R.id.titleViewWater);
        titleFont = Typeface.createFromAsset(getAssets(), "LobsterTwo-Italic.otf");
        titleViewWater.setTypeface(titleFont);
    }
}
