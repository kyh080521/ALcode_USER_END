package com.example.myapplication;

public class Allergy {
    String alName;
    String alNameU;
    String alNameK;
    int alNationality;
    boolean alTake;

    Allergy(String nameMain, String nameTranslate, int nationality, boolean take) {
        this.alNationality = nationality;
        this.alTake = take;
        if(this.alNationality == 1) {
            alName = nameMain;
            alNameU = nameMain;
            alNameK = nameTranslate;
        } else if(this.alNationality == 82) {
            alName = nameMain;
            alNameU = nameTranslate;
            alNameK =  nameMain;
        }
    }

    void buttonTurn(boolean buttonCheck) {
        alTake = buttonCheck;
    }

    String warnMessage() {
        return alNameU + ", ";
    }

    boolean allergyCompare(String foodAlInform) {
        System.out.println(alName);
        if(foodAlInform.contains(alName) && alTake) {
            return true;
        } else {
            return false;
        }
    }

    String backgroundColorSet() {
        if(alTake == true) return "#F15656";
        else return "#ffffff";
    }
}
