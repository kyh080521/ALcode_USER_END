package com.example.myapplication;

public class Food {
    String name;
    String alInform;

    public Food(String fdName, String fdAlInform ){
        this.name = fdName;
        this.alInform = fdAlInform;
    }

    public String getFoodName()
    {
        return this.name;
    }

    public String getAlInform()
    {
        return this.alInform;
    }

}
