package com.example.covidtracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class country_details extends AppCompatActivity {
     public int countryPosition;
     TextView tvCountry,tvCases,tvRecovered,tvActive,tvTodayCases,tvTodayDeaths,tvTotalDeaths,tvCritical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        Intent intent=getIntent();
        countryPosition=intent.getIntExtra("position",0);
        getSupportActionBar().setTitle(affectedCountries.countryModelList.get(countryPosition).getCountryName());
        tvActive=findViewById(R.id.tvactive);
        tvCountry=findViewById(R.id.tvcountryname);
        tvCases=findViewById(R.id.tvcases);
        tvRecovered=findViewById(R.id.tvrecovered);
        tvTodayCases=findViewById(R.id.tvtodaycases);
        tvTodayDeaths=findViewById(R.id.tvtodaydeaths);
        tvTotalDeaths=findViewById(R.id.tvtotaldeaths);
        tvCritical=findViewById(R.id.tvcritical);
        tvCountry.setText(affectedCountries.countryModelList.get(countryPosition).getCountryName());
        tvActive.setText(affectedCountries.countryModelList.get(countryPosition).getActive());
        tvCases.setText(affectedCountries.countryModelList.get(countryPosition).getCases());
        tvTodayDeaths.setText(affectedCountries.countryModelList.get(countryPosition).getTodayDeaths());
        tvTodayCases.setText(affectedCountries.countryModelList.get(countryPosition).getTodayCases());
        tvTotalDeaths.setText(affectedCountries.countryModelList.get(countryPosition).getDeaths());
        tvCritical.setText(affectedCountries.countryModelList.get(countryPosition).getCritical());
        tvRecovered.setText(affectedCountries.countryModelList.get(countryPosition).getRecovered());
    }
}