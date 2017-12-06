package org.lukasowy.fitnesscalculators;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class ProteinActivity extends AppCompatActivity {
    TextView resultTextView;
    Typeface textFont;
    RelativeLayout allScreenProtein;
    Spinner spinnerGoal;
    Button btnCalculate;
    EditText inputWeight, inputAge;

    int posGoal;
    String itemGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein);


        //Set fonts for all activity
        allScreenProtein = (RelativeLayout) findViewById(R.id.allScreenProtein);
        textFont = Typeface.createFromAsset(getAssets(), "LobsterTwo-Italic.otf");
        GeneralMethods.setFontToAllChilds(allScreenProtein, textFont);

        resultTextView = (TextView) findViewById(R.id.resultTextView);
        onSelectedListenerSpinners();
        onClickListenerButton();
    }

    private void onClickListenerButton() {
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

    }

    private void onSelectedListenerSpinners(){
        //Find spinners
        spinnerGoal = (Spinner) findViewById(R.id.spinnerGoal);

        //Set adapter to spinner
        ArrayAdapter<CharSequence> adapterActivity = ArrayAdapter.createFromResource(this, R.array.itemsSpGoalProtein, android.R.layout.simple_list_item_activated_1);
        spinnerGoal.setAdapter(adapterActivity);

        //For first spinner
        spinnerGoal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemGoal = adapterView.getItemAtPosition(i).toString();
                posGoal = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
