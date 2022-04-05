package com.example.fortydegreeste.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Countries {

    @Expose
    @SerializedName("name")
    private CountryName name;
    @Expose
    @SerializedName("region")
    private String region;
    @Expose
    @SerializedName("capital")
    private List<String> capital;

    public Countries(CountryName name, String region, List<String> capital) {
        this.name = name;
        this.region = region;
        this.capital = capital;
    }

    public CountryName getName() {
        return name;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public void setName(CountryName name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }



    @Override
    public String toString() {
        return region;
    }
}
