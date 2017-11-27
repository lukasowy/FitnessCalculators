package org.lukasowy.fitnesscalculators;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class WaterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Typeface textFont;
    RelativeLayout allScreenWater;
    Spinner spinnerActivity, spinnerClimate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        //Set fonts for all activity
        allScreenWater = (RelativeLayout) findViewById(R.id.allScreenWater);
        textFont = Typeface.createFromAsset(getAssets(), "LobsterTwo-Italic.otf");
        GeneralMethods.setFontToAllChilds(allScreenWater, textFont);

        //Find spinners
        spinnerActivity = (Spinner) findViewById(R.id.spinnerActivity);
        spinnerClimate = (Spinner) findViewById(R.id.spinnerClimate);

        //Set adapter to spinner
        ArrayAdapter<CharSequence> adapterActivity = ArrayAdapter.createFromResource(this, R.array.itemsSpActivity, android.R.layout.simple_list_item_activated_1);
        spinnerActivity.setAdapter(adapterActivity);
        ArrayAdapter<CharSequence> adapterClimate = ArrayAdapter.createFromResource(this, R.array.itemsSpClimate, android.R.layout.simple_list_item_activated_1);
        spinnerClimate.setAdapter(adapterClimate);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
