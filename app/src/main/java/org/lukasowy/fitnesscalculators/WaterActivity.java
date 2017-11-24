package org.lukasowy.fitnesscalculators;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class WaterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView titleViewWater;
    Typeface titleFont;

    Spinner spinnerActivity, spinnerClimate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        titleViewWater = (TextView) findViewById(R.id.titleViewWater);
        titleFont = Typeface.createFromAsset(getAssets(), "LobsterTwo-Italic.otf");
        titleViewWater.setTypeface(titleFont);

        spinnerActivity = (Spinner)findViewById(R.id.spinnerActivity);
        spinnerClimate = (Spinner)findViewById(R.id.spinnerClimate);

        //set adapter to spinner
        ArrayAdapter<CharSequence> adapterActivity = ArrayAdapter.createFromResource(this, R.array.itemsSpActivity, android.R.layout.simple_spinner_item);
        spinnerActivity.setAdapter(adapterActivity);
        ArrayAdapter<CharSequence> adapterClimate = ArrayAdapter.createFromResource(this, R.array.itemsSpClimate, android.R.layout.simple_spinner_item);
        spinnerClimate.setAdapter(adapterClimate);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
