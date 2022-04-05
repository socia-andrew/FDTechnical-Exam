package com.example.fortydegreeste.model;

public class User {
    private String Name;
    private String SelecedRegion;
    private String SelectedCity;

    public User(String name, String selecedRegion, String selectedCity) {
        Name = name;
        SelecedRegion = selecedRegion;
        SelectedCity = selectedCity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSelecedRegion() {
        return SelecedRegion;
    }

    public void setSelecedRegion(String selecedRegion) {
        SelecedRegion = selecedRegion;
    }

    public String getSelectedCity() {
        return SelectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        SelectedCity = selectedCity;
    }
}
