package org.lukasowy.fitnesscalculators;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity {

    TextView resultTextView;
    Typeface textFont;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btnCalculate;
    EditText inputHeight, inputWeight;
    RelativeLayout allScreenBMI;

    double inHeight, inWeight, ans;
    String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        //Set fonts for all activity
        allScreenBMI = (RelativeLayout) findViewById(R.id.allScreenBMI);
        textFont = Typeface.createFromAsset(getAssets(), "LobsterTwo-Italic.otf");
        GeneralMethods.setFontToAllChilds(allScreenBMI, textFont);

        resultTextView = (TextView) findViewById(R.id.resultTextView);
        onClickListenerButton();

    }

    public void onClickListenerButton() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                inputHeight = (EditText) findViewById(R.id.inputHeight);
                inputWeight = (EditText) findViewById(R.id.inputWeight);

                //For Hide keyboard
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                if (radioGroup.getCheckedRadioButtonId() != -1) {
                    if (inputHeight.length() != 0 && inputWeight.length() != 0) {

                        inHeight = Double.parseDouble(inputHeight.getText().toString());
                        inWeight = Double.parseDouble(inputWeight.getText().toString());

                        ans = calculateBMI(inWeight, inHeight);
                        BMICategorization(ans);
                        resultTextView.setText(Double.toString(ans));

                    } else if (inputHeight.length() == 0 && inputWeight.length() > 0) {
                        Toast.makeText(getBaseContext(), "Please, type Height.", Toast.LENGTH_SHORT).show();
                    } else if (inputHeight.length() > 0 && inputWeight.length() == 0) {
                        Toast.makeText(getBaseContext(), "Please, type Weight.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getBaseContext(), "Please, type Weight and Height.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Please, select sex.", Toast.LENGTH_SHORT).show();
                }
            }

            private void BMICategorization(double ans) {
                if (isBetween(ans, 0, 15))
                    Toast.makeText(getBaseContext(), "Very severely underweight", Toast.LENGTH_SHORT).show();
                else if (isBetween(ans, 15, 16))
                    Toast.makeText(getBaseContext(), "Severely underweight", Toast.LENGTH_SHORT).show();
                else if (isBetween(ans, 16, 18.5))
                    Toast.makeText(getBaseContext(), "Underweight", Toast.LENGTH_SHORT).show();
                else if (isBetween(ans, 18.5, 25))
                    Toast.makeText(getBaseContext(), "Normal (healthy weight)", Toast.LENGTH_SHORT).show();
                else if (isBetween(ans, 25, 30))
                    Toast.makeText(getBaseContext(), "Overweight", Toast.LENGTH_SHORT).show();
                else if (isBetween(ans, 30, 35))
                    Toast.makeText(getBaseContext(), "Moderately obese", Toast.LENGTH_SHORT).show();
                else if (isBetween(ans, 35, 40))
                    Toast.makeText(getBaseContext(), "Severely obese", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(), "Very severely obese", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public double calculateBMI(double inWeight, double inHeight) {
        double result;
        // BMI for both sex is the same
        result = inWeight / ((inHeight / 100) * (inHeight / 100));
        return GeneralMethods.round(result, 2);
    }

    private boolean isBetween(double x, double lower, double upper) {
        return lower < x && x <= upper;
    }
}
