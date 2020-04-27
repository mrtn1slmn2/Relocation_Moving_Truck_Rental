package net.androidbootcamp.relocationmovingtruckrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Estimate extends AppCompatActivity {
    float totalCost, mileCost;
    double rate10 = 19.95;
    double rate17 = 29.95;
    double rate26 = 39.95;
    double pricePerMile = 0.99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate);
        TextView total = (TextView)findViewById(R.id.txtDailyCost);
        ImageView pic = (ImageView)findViewById(R.id.imgSize);
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        int tSize = shared.getInt("keySize",0);
        int tMiles = shared.getInt("keyMiles", 0);
        mileCost = (float) (tMiles * pricePerMile);
        DecimalFormat currency = new DecimalFormat("$##,###.##");

        if(tSize == 10){
            totalCost = (float) (rate10 + mileCost);
            pic.setImageResource(R.drawable.ten);
            total.setText("The total moving cost per day is: " + currency.format(totalCost));
        }
        else if (tSize == 17){
            totalCost = (float) (rate17 + mileCost);
            pic.setImageResource(R.drawable.seventeen);
            total.setText("The total moving cost per day is: " + currency.format(totalCost));
        }
        else if(tSize == 26){
            totalCost = (float) (rate26 + mileCost);
            pic.setImageResource(R.drawable.twentysix);
            total.setText("The total moving cost per day is: " + currency.format(totalCost));
        }
        else
            total.setText("Please enter 10, 17 or 26 as Truck Size");

    }
}
