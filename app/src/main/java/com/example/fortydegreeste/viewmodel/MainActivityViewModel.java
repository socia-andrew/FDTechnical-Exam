package com.example.fortydegreeste.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fortydegreeste.model.Countries;
import com.example.fortydegreeste.network.RetrofitClient;
import com.example.fortydegreeste.network.WebService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {


    private MutableLiveData<List<Countries>> countries;

    public MainActivityViewModel() {
        this.countries = new MutableLiveData<>();
    }

    public void callCountries() {


        WebService webService = RetrofitClient.getClient().create(WebService.class);

        webService.getCountries().enqueue(new Callback<List<Countries>>() {
            @Override
            public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
              //  Log.d("Data",""+response.body());
                countries.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Countries>> call, Throwable t) {
                Log.d("Data",""+t.getMessage());
                countries.postValue(null);
            }
        });

    }

    public MutableLiveData<List<Countries>> getCountriesObserver(){
        return countries;
    }


}
