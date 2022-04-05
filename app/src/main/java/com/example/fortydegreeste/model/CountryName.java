package com.example.fortydegreeste.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryName {

    @Expose
    @SerializedName("common")
    private  String common;
    @Expose
    @SerializedName("official")
    private String official;


    public CountryName(String common, String official) {
        this.common = common;
        this.official = official;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }
}
