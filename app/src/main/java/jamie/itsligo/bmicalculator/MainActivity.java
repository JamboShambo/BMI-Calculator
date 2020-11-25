package jamie.itsligo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.etWeight);
        height = findViewById(R.id.etHeight);

    }

    public void doReset(View view) {
        weight.setText(null);
        height.setText(null);
    }

    public void doCalculate(View view) {

            Intent resultPageIntent = new Intent(view.getContext(), ResultPage.class);

            int heightCalc = Integer.valueOf(height.getText().toString());
            int weightCalc = Integer.valueOf(weight.getText().toString());


            resultPageIntent.putExtra("WeightPassed", weightCalc);
            resultPageIntent.putExtra("HeightPassed", heightCalc);


            if (weightCalc >= 20 && weightCalc <= 200 && heightCalc >= 80 && heightCalc <= 300) {
                startActivity(resultPageIntent);
            } else {
                Toast.makeText(getApplicationContext(), "Please enter a usable weight and height", Toast.LENGTH_LONG).show();
                weight.setText(null);
                height.setText(null);
            }




    }
}