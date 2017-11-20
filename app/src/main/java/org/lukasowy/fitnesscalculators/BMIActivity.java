package org.lukasowy.fitnesscalculators;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    TextView titleViewBMI;
    Typeface titleFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        titleViewBMI = (TextView) findViewById(R.id.titleViewBMI);
        titleFont = Typeface.createFromAsset(getAssets(), "LobsterTwo-Italic.otf");
        titleViewBMI.setTypeface(titleFont);
    }
}
