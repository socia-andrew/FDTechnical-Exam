package com.example.fortydegreeste;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.fortydegreeste.model.Countries;
import com.example.fortydegreeste.viewmodel.MainActivityViewModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    ArrayAdapter<String> regionApdater;
    ArrayAdapter<String> countryAdapter;
    List<Countries> regionlist = new ArrayList<>();

    ArrayList<String> arrRegion = new ArrayList<String>();
    ArrayList<String> arrCities = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getCountriesObserver().observe(this, new Observer<List<Countries>>() {
            @Override
            public void onChanged(List<Countries> baseResponses) {
                Log.d("Data", new Gson().toJson(baseResponses));

                regionlist = baseResponses;
                for (int i = 0; i < regionlist.size(); i++) {

                    if (arrRegion.indexOf(regionlist.get(i).getRegion()) < 0) {
                        arrRegion.add(regionlist.get(i).getRegion());
                    }

                }

            }
        });

        mainActivityViewModel.callCountries();

        Spinner spinnerRegion = (Spinner) findViewById(R.id.spinnerRegion);
        regionApdater = new ArrayAdapter<String>(this, R.layout.item_spinner, arrRegion);
        spinnerRegion.setAdapter(regionApdater);

        spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
                String region = arrRegion.get(i);
                Log.d("regionselected", region);
                for (int x = 0; x < regionlist.size(); x++) {

                    if (regionlist.get(x).getRegion() == region) {
                        arrCities.add(regionlist.get(x).getName().getCommon());
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);
        countryAdapter = new ArrayAdapter<String>(this, R.layout.item_spinner, arrCities);
        spinnerCountry.setAdapter(countryAdapter);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
                String region = arrRegion.get(i);
                Log.d("regionselected", region);
                for (int x = 0; x < regionlist.size(); x++) {

                    if (regionlist.get(x).getRegion() == region) {
                        arrCities.add(regionlist.get(x).getName().getCommon());
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}