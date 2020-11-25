package jamie.itsligo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultPage extends AppCompatActivity {

    double w  = 0, h = 0,hCalc = 0,finalCalc = 0, RoundCalc = 0;
    String under = "Underweight",healthy = "Healthy",ovewrweight = "Overweight",obese = "Obese";

    TextView BMI, Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        // link the xml to the local variables
        BMI = findViewById(R.id.tvBMI);
        Result = findViewById(R.id.tvFinalBMI);


        // just woke up
        // look into the pipe
        w = getIntent().getIntExtra("WeightPassed", 0 );
        h = getIntent().getIntExtra("HeightPassed", 0);

        //formula KG / meters squared
        hCalc = h / 100;

        finalCalc = (w/(hCalc*hCalc));

        DecimalFormat f = new DecimalFormat("##.00");

        // displaying the data in the text views on the screen
        BMI.setText(String.valueOf(f.format(finalCalc)));

        if (finalCalc < 18.5){
            Result.setText(under);
            Result.setTextColor(Color.rgb(0,191,255));

        } else if(finalCalc >= 18.5 && finalCalc <= 24.9 ) {
            Result.setText(healthy);
            Result.setTextColor(Color.rgb(46,139,87));
        } else if(finalCalc >= 25 && finalCalc <= 29.9 ) {
            Result.setText(ovewrweight);
            Result.setTextColor(Color.rgb(252,165,0));
        } else {
            Result.setText(obese);
            Result.setTextColor(Color.rgb(255,44,0));
        }


    }

    public void doBack(View view) {
        Intent mainActivityIntent = new Intent(view.getContext(), MainActivity.class);
        startActivity(mainActivityIntent);
    }
}