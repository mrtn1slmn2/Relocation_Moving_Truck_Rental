package net.androidbootcamp.relocationmovingtruckrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int truckSize;
    int mileage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText truckS = (EditText)findViewById(R.id.txtSize);
        final EditText miles = (EditText)findViewById(R.id.txtMileage);

        Button estimate = (Button)findViewById(R.id.btnEstimate);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        estimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                truckSize = Integer.parseInt(truckS.getText().toString());
                mileage = Integer.parseInt(miles.getText().toString());

                SharedPreferences.Editor edtr1 = sharedPref.edit();
                edtr1.putInt("keySize", truckSize);
                edtr1.putInt("keyMiles", mileage);
                edtr1.commit();
                startActivity(new Intent(MainActivity.this, Estimate.class));
            }
        });
    }
}
