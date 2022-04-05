package com.example.fortydegreeste.network;

import com.example.fortydegreeste.model.Countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {


    @GET("all")
    Call<List<Countries>> getCountries();


}
