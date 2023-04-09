package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity<MyActivity> extends AppCompatActivity {
    private CheckBox egg_k, beef_k, pork_k, chicken_k, shrimp_k, crab_k, squid_k, mackerel_k, shellfish_k, milk_k, peach_k, peanut_k, walnut_k, pine_nut_k, tomato_k, soybean_k, wheat_k, buck_wheat_k, sulfurous_acid_k;
    private CheckBox milk_u, egg_u, fish_u, shrimp_u, shellfish_u, treeNuts_u, wheat_u, peanuts_u, soybeans_u;
    private Spinner spinner_language, spinner_nationality;
    private TextView textView_consider;

    Allergy alMilkU = new Allergy("Milk", "우유",  1, false);
    Allergy alEggsU = new Allergy("Eggs", "난류",1, false);
    Allergy alFishU = new Allergy("Fish", "생선",1, false);
    Allergy alShrimpU = new Allergy("Shrimp", "새우",1, false);
    Allergy alShellfishU = new Allergy("Shellfish", "조개",1, false);
    Allergy alNutsU = new Allergy("Nuts", "견과류",1, false);
    Allergy alWheatU = new Allergy("Wheat", "밀",1, false);
    Allergy alPeanutsU = new Allergy("Peanuts", "땅콩",1, false);
    Allergy alSoybeansU = new Allergy("Soybeans", "대두",1, false);

    Allergy alEggsK = new Allergy("계란", "Eggs", 82, false);
    Allergy alBeefK = new Allergy("소고기", "Beef", 82, false);
    Allergy alPorkK = new Allergy("돼지고기", "Pork", 82, false);
    Allergy alChickenK = new Allergy("닭고기", "Chicken", 82, false);
    Allergy alShrimpK = new Allergy("새우", "Shrimp", 82, false);
    Allergy alCrabK = new Allergy("게", "Crab", 82, false);
    Allergy alSquidK = new Allergy("오징어", "Squid", 82, false);
    Allergy alMackerelK = new Allergy("고등어", "Mackerel", 82, false);
    Allergy alShellfishK = new Allergy("조개류", "Shellfish", 82, false);
    Allergy alMilkK = new Allergy("우유", "Milk", 82, false);
    Allergy alPeachK = new Allergy("복숭아", "Peach", 82, false);
    Allergy alPeanutK = new Allergy("땅콩", "Peanut", 82, false);
    Allergy alWalnutK = new Allergy("호두", "Walnut", 82, false);
    Allergy alPineNutK = new Allergy("잣", "Pine Nut", 82, false);
    Allergy alTomatoK = new Allergy("토마토", "Tomato", 82, false);
    Allergy alSoybeanK = new Allergy("대두", "Soybean", 82, false);
    Allergy alWheatK = new Allergy("밀", "Wheat", 82, false);
    Allergy alBuckWheatK = new Allergy("메밀", "Buck Wheat", 82, false);
    Allergy alSulfurousAcidK = new Allergy("아황산류", "Sulfurous Acid", 82, false);

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    int nationalNum;
    int languageNum;

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if (result.getContents() == null) {
                    Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    int numFood = 0;
                    String[] product = result.getContents().split("/");
                    int pdNum = result.getContents().length() - result.getContents().replace("/", "").length();

                    for (int i = 0; i < pdNum; i++) {
                        String food = product[i].split("&")[0];
                        String[] allergy = product[i].split("&")[1].split(",");
                        String warn = "";
                        int alNum = product[i].length() - product[i].replace(",", "").length() + 1; // 알러지 정보 쉼표의 개수

                        for (int j = 0; j < alNum; j++) {
                            String alInform = allergy[j].trim();
                            if(nationalNum == 1) {
                                if (alMilkU.allergyCompare(alInform)) {
                                    warn += alMilkU.warnMessage(languageNum);
                                } if (alEggsU.allergyCompare(alInform)) {
                                    warn += alEggsU.warnMessage(languageNum);
                                } if (alFishU.allergyCompare(alInform)) {
                                    warn += alFishU.warnMessage(languageNum);
                                } if (alShrimpU.allergyCompare(alInform)) {
                                    warn += alShrimpU.warnMessage(languageNum);
                                } if (alShellfishU.allergyCompare(alInform)) {
                                    warn += alShrimpU.warnMessage(languageNum);
                                } if (alNutsU.allergyCompare(alInform)) {
                                    warn += alNutsU.warnMessage(languageNum);
                                } if (alWheatU.allergyCompare(alInform)) {
                                    warn += alWheatU.warnMessage(languageNum);
                                } if (alPeanutsU.allergyCompare(alInform)) {
                                    warn += alPeanutsU.warnMessage(languageNum);
                                } if (alSoybeansU.allergyCompare(alInform)) {
                                    warn += alSoybeansU.warnMessage(languageNum);
                                }
                            } else if(nationalNum == 82) {
                                if (alEggsK.allergyCompare(alInform)) {
                                    warn += alEggsK.warnMessage(languageNum);
                                }if (alBeefK.allergyCompare(alInform)) {
                                    warn += alBeefK.warnMessage(languageNum);
                                }if(alPorkK.allergyCompare(alInform)) {
                                    warn += alPorkK.warnMessage(languageNum);
                                }if(alChickenK.allergyCompare(alInform)) {
                                    warn += alChickenK.warnMessage(languageNum);
                                }if(alShrimpK.allergyCompare(alInform)) {
                                    warn += alShrimpK.warnMessage(languageNum);
                                }if(alCrabK.allergyCompare(alInform)) {
                                    warn += alCrabK.warnMessage(languageNum);
                                }if(alSquidK.allergyCompare(alInform)) {
                                    warn += alSquidK.warnMessage(languageNum);
                                }if(alMackerelK.allergyCompare(alInform)) {
                                    warn += alMackerelK.warnMessage(languageNum);
                                }if(alShellfishK.allergyCompare(alInform)) {
                                    warn += alShellfishK.warnMessage(languageNum);
                                }if(alMilkK.allergyCompare(alInform)) {
                                    warn += alMilkK.warnMessage(languageNum);
                                }if(alPeachK.allergyCompare(alInform)) {
                                    warn += alPeachK.warnMessage(languageNum);
                                }if(alPeanutK.allergyCompare(alInform)){
                                    warn += alPeanutK.warnMessage(languageNum);
                                }if(alWalnutK.allergyCompare(alInform)) {
                                    warn += alWalnutK.warnMessage(languageNum);
                                }if(alPineNutK.allergyCompare(alInform)) {
                                    warn += alPineNutK.warnMessage(languageNum);
                                }if(alTomatoK.allergyCompare(alInform)) {
                                    warn += alTomatoK.warnMessage(languageNum);
                                }if(alSoybeanK.allergyCompare(alInform)) {
                                    warn += alSoybeanK.warnMessage(languageNum);
                                }if(alWheatK.allergyCompare(alInform)) {
                                    warn += alWheatK.warnMessage(languageNum);
                                }if(alBuckWheatK.allergyCompare(alInform)) {
                                    warn += alBuckWheatK.warnMessage(languageNum);
                                }if(alSulfurousAcidK.allergyCompare(alInform)) {
                                    warn += alSulfurousAcidK.warnMessage(languageNum);
                                }
                            }
                        }
                        if (warn.length() > 0) {
                            numFood++;
                            AlertDialog.Builder warning = new AlertDialog.Builder(MainActivity.this);

                            warning.setTitle(food + "(" + numFood + ")");
                            warning.setMessage("'" + warn + "'" + " were detected" + " in it");

                            warning.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                            AlertDialog alertDialog = warning.show();
                            TextView messageText = (TextView) alertDialog.findViewById(android.R.id.message);
                            messageText.setTextSize(25);
                            alertDialog.show();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        egg_k = findViewById(R.id.checkBox_egg_k);
        beef_k = findViewById(R.id.checkBox_beef_k);
        pork_k = findViewById(R.id.checkBox_pork_k);
        chicken_k = findViewById(R.id.checkBox_chicken_k);
        shrimp_k = findViewById(R.id.checkBox_shrimp_k);
        crab_k = findViewById(R.id.checkBox_crab_k);
        squid_k = findViewById(R.id.checkBox_squid_k);
        mackerel_k = findViewById(R.id.checkBox_mackerel_k);
        shellfish_k = findViewById(R.id.checkBox_shellfish_k);
        milk_k = findViewById(R.id.checkBox_milk_k);
        peach_k = findViewById(R.id.checkBox_peach_k);
        peanut_k = findViewById(R.id.checkBox_peanut_k);
        walnut_k = findViewById(R.id.checkBox_walnut_k);
        pine_nut_k = findViewById(R.id.checkBox_pine_nut_k);
        tomato_k = findViewById(R.id.checkBox_tomato_k);
        soybean_k = findViewById(R.id.checkBox_soybean_k);
        wheat_k = findViewById(R.id.checkBox_wheat_k);
        buck_wheat_k = findViewById(R.id.checkBox_buck_wheat_k);
        sulfurous_acid_k = findViewById(R.id.checkBox_sulfurous_acid_k);

        milk_u = findViewById(R.id.checkBox_milk_u);
        egg_u = findViewById(R.id.checkBox_egg_u);
        shrimp_u = findViewById(R.id.checkBox_shrimp_u);
        fish_u = findViewById(R.id.checkBox_fish_u);
        shellfish_u = findViewById(R.id.checkBox_shellfishAlU_u);
        treeNuts_u = findViewById(R.id.checkBox_treeNuts_u);
        wheat_u = findViewById(R.id.checkBox_wheat_u);
        peanuts_u = findViewById(R.id.checkBox_peanuts_u);
        soybeans_u = findViewById(R.id.checkBox_soybeans_u);

        textView_consider = findViewById(R.id.textView_consider);

        spinner_language = (Spinner)findViewById(R.id.spinner_language);
        spinner_nationality = (Spinner)findViewById(R.id.spinner_nationality);



        egg_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egg_k.isChecked()) {
                    alEggsK.buttonTurn(true);
                } else {
                    alEggsK.buttonTurn(false);
                }
            }
        });
        beef_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (beef_k.isChecked()) {
                    alBeefK.buttonTurn(true);
                } else {
                    alBeefK.buttonTurn(false);
                }
            }
        });
        pork_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pork_k.isChecked()) {
                    alPorkK.buttonTurn(true);
                } else {
                    alPorkK.buttonTurn(false);
                }
            }
        });
        chicken_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chicken_k.isChecked()) {
                    alChickenK.buttonTurn(true);
                } else {
                    alChickenK.buttonTurn(false);
                }
            }
        });
        shrimp_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shrimp_k.isChecked()) {
                    alShrimpK.buttonTurn(true);
                } else {
                    alShrimpK.buttonTurn(false);
                }
            }
        });
        crab_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (crab_k.isChecked()) {
                    alCrabK.buttonTurn(true);
                } else {
                    alCrabK.buttonTurn(false);
                }
            }
        });
        squid_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (squid_k.isChecked()) {
                    alSquidK.buttonTurn(true);
                } else {
                    alSquidK.buttonTurn(false);
                }
            }
        });
        mackerel_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mackerel_k.isChecked()) {
                    alMackerelK.buttonTurn(true);
                } else {
                    alMackerelK.buttonTurn(false);
                }
            }
        });
        shellfish_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shellfish_k.isChecked()) {
                    alShellfishK.buttonTurn(true);
                } else {
                    alShellfishK.buttonTurn(false);
                }
            }
        });
        milk_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (milk_k.isChecked()) {
                    alMilkK.buttonTurn(true);
                } else {
                    alMilkK.buttonTurn(false);
                }
            }
        });
        peach_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (peach_k.isChecked()) {
                    alPeachK.buttonTurn(true);
                } else {
                    alPeachK.buttonTurn(false);
                }
            }
        });
        peanut_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (peanut_k.isChecked()) {
                    alPeanutK.buttonTurn(true);
                } else {
                    alPeanutK.buttonTurn(false);
                }
            }
        });
        walnut_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (walnut_k.isChecked()) {
                    alWalnutK.buttonTurn(true);
                } else {
                    alWalnutK.buttonTurn(false);
                }
            }
        });
        pine_nut_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pine_nut_k.isChecked()) {
                    alPineNutK.buttonTurn(true);
                } else {
                    alPineNutK.buttonTurn(false);
                }
            }
        });
        tomato_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tomato_k.isChecked()) {
                    alTomatoK.buttonTurn(true);
                } else {
                    alTomatoK.buttonTurn(false);
                }
            }
        });
        soybean_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soybean_k.isChecked()) {
                    alSoybeanK.buttonTurn(true);
                } else {
                    alSoybeanK.buttonTurn(false);
                }
            }
        });
        wheat_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wheat_k.isChecked()) {
                    alWheatK.buttonTurn(true);
                } else {
                    alWheatK.buttonTurn(false);
                }
            }
        });
        buck_wheat_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buck_wheat_k.isChecked()) {
                    alBuckWheatK.buttonTurn(true);
                } else {
                    alBuckWheatK.buttonTurn(false);
                }
            }
        });
        sulfurous_acid_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sulfurous_acid_k.isChecked()) {
                    alSulfurousAcidK.buttonTurn(true);
                } else {
                    alSulfurousAcidK.buttonTurn(false);
                }
            }
        });


        milk_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (milk_u.isChecked()) {
                    alMilkU.buttonTurn(true);
                } else {
                    alMilkU.buttonTurn(false);
                }
            }
        });
        egg_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egg_u.isChecked()) {
                    alEggsU.buttonTurn(true);
                    System.out.println(alEggsU.alTake);
                } else {
                    alEggsU.buttonTurn(false);
                }
            }
        });
        shrimp_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shrimp_u.isChecked()) {
                    alShrimpU.buttonTurn(true);
                } else {
                    alShrimpU.buttonTurn(false);
                }
            }
        });
        fish_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fish_u.isChecked()) {
                    alFishU.buttonTurn(true);
                } else {
                    alFishU.buttonTurn(false);
                }
            }
        });
        shellfish_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shellfish_u.isChecked()) {
                    alShellfishU.buttonTurn(true);
                } else {
                    alShellfishU.buttonTurn(false);
                }
            }
        });
        treeNuts_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (treeNuts_u.isChecked()) {
                    alNutsU.buttonTurn(true);
                } else {
                    alNutsU.buttonTurn(false);
                }
            }
        });
        wheat_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wheat_u.isChecked()) {
                    alWheatU.buttonTurn(true);
                } else {
                    alWheatU.buttonTurn(false);
                }
            }
        });
        peanuts_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (peanuts_u.isChecked()) {
                    alPeanutsU.buttonTurn(true);
                } else {
                    alPeanutsU.buttonTurn(false);
                }
            }
        });
        soybeans_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soybeans_u.isChecked()) {
                    alSoybeansU.buttonTurn(true);
                } else {
                    alSoybeansU.buttonTurn(false);
                }
            }
        });

        spinner_language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(spinner_language.getItemAtPosition(position).toString().equals("English")) {
                   languageNum = 1;

                   milk_u.setText(alMilkU.alNameU);
                   egg_u.setText(alEggsU.alNameU);
                   fish_u.setText(alFishU.alNameU);
                   shrimp_u.setText(alShellfishU.alNameU);
                   shellfish_u.setText(alShellfishU.alNameU);
                   treeNuts_u.setText(alNutsU.alNameU);
                   wheat_u.setText(alWheatU.alNameU);
                   peanuts_u.setText(alPeanutsU.alNameU);
                   soybeans_u.setText(alSoybeansU.alNameU);

                   egg_k.setText(alEggsK.alNameU);
                   beef_k.setText(alBeefK.alNameU);
                   pork_k.setText(alPorkK.alNameU);
                   chicken_k.setText(alChickenK.alNameU);
                   shrimp_k.setText(alShrimpK.alNameU);
                   crab_k.setText(alCrabK.alNameU);
                   squid_k.setText(alSquidK.alNameU);
                   mackerel_k.setText(alMackerelK.alNameU);
                   shellfish_k.setText(alShellfishK.alNameU);
                   milk_k.setText(alMilkK.alNameU);
                   peach_k.setText(alPeachK.alNameU);
                   peanut_k.setText(alPeanutK.alNameU);
                   walnut_k.setText(alWalnutK.alNameU);
                   pine_nut_k.setText(alPineNutK.alNameU);
                   tomato_k.setText(alTomatoK.alNameU);
                   soybean_k.setText(alSoybeanK.alNameU);
                   wheat_k.setText(alWheatK.alNameU);
                   buck_wheat_k.setText(alBuckWheatK.alNameU);
                   sulfurous_acid_k.setText(alSulfurousAcidK.alNameU);

                   textView_consider.setText("Please check your allergy information");
                   textView_consider.setTextSize(27);
               } else if(spinner_language.getItemAtPosition(position).toString().equals("한국어")) {
                   languageNum = 82;

                   milk_u.setText(alMilkU.alNameK);
                   egg_u.setText(alEggsU.alNameK);
                   fish_u.setText(alFishU.alNameK);
                   shrimp_u.setText(alShellfishU.alNameK);
                   shellfish_u.setText(alShellfishU.alNameK);
                   treeNuts_u.setText(alNutsU.alNameK);
                   wheat_u.setText(alWheatU.alNameK);
                   peanuts_u.setText(alPeanutsU.alNameK);
                   soybeans_u.setText(alSoybeansU.alNameK);

                   egg_k.setText(alEggsK.alNameK);
                   beef_k.setText(alBeefK.alNameK);
                   pork_k.setText(alPorkK.alNameK);
                   chicken_k.setText(alChickenK.alNameK);
                   shrimp_k.setText(alShrimpK.alNameK);
                   crab_k.setText(alCrabK.alNameK);
                   squid_k.setText(alSquidK.alNameK);
                   mackerel_k.setText(alMackerelK.alNameK);
                   shellfish_k.setText(alShellfishK.alNameK);
                   milk_k.setText(alMilkK.alNameK);
                   peach_k.setText(alPeachK.alNameK);
                   peanut_k.setText(alPeanutK.alNameK);
                   walnut_k.setText(alWalnutK.alNameK);
                   pine_nut_k.setText(alPineNutK.alNameK);
                   tomato_k.setText(alTomatoK.alNameK);
                   soybean_k.setText(alSoybeanK.alNameK);
                   wheat_k.setText(alWheatK.alNameK);
                   buck_wheat_k.setText(alBuckWheatK.alNameK);
                   sulfurous_acid_k.setText(alSulfurousAcidK.alNameK);

                   textView_consider.setText("당신의 알러지 정보를 입력해주세요");
                   textView_consider.setTextSize(24);
               }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_nationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner_nationality.getItemAtPosition(position).toString().equals("USA")) {
                    nationalNum = 1;

                    milk_u.setVisibility(View.VISIBLE);
                    egg_u.setVisibility(View.VISIBLE);
                    fish_u.setVisibility(View.VISIBLE);
                    shrimp_u.setVisibility(View.VISIBLE);
                    shellfish_u.setVisibility(View.VISIBLE);
                    treeNuts_u.setVisibility(View.VISIBLE);
                    wheat_u.setVisibility(View.VISIBLE);
                    peanuts_u.setVisibility(View.VISIBLE);
                    soybeans_u.setVisibility(View.VISIBLE);

                    egg_k.setVisibility(View.GONE);
                    beef_k.setVisibility(View.GONE);
                    pork_k.setVisibility(View.GONE);
                    chicken_k.setVisibility(View.GONE);
                    shrimp_k.setVisibility(View.GONE);
                    crab_k.setVisibility(View.GONE);
                    squid_k.setVisibility(View.GONE);
                    mackerel_k.setVisibility(View.GONE);
                    shellfish_k.setVisibility(View.GONE);
                    milk_k.setVisibility(View.GONE);
                    peach_k.setVisibility(View.GONE);
                    peanut_k.setVisibility(View.GONE);
                    walnut_k.setVisibility(View.GONE);
                    pine_nut_k.setVisibility(View.GONE);
                    tomato_k.setVisibility(View.GONE);
                    soybean_k.setVisibility(View.GONE);
                    wheat_k.setVisibility(View.GONE);
                    buck_wheat_k.setVisibility(View.GONE);
                    sulfurous_acid_k.setVisibility(View.GONE);
                } else if(spinner_nationality.getItemAtPosition(position).toString().equals("Korea")) {
                    nationalNum = 82;

                    milk_u.setVisibility(View.GONE);
                    egg_u.setVisibility(View.GONE);
                    fish_u.setVisibility(View.GONE);
                    shrimp_u.setVisibility(View.GONE);
                    shellfish_u.setVisibility(View.GONE);
                    treeNuts_u.setVisibility(View.GONE);
                    wheat_u.setVisibility(View.GONE);
                    peanuts_u.setVisibility(View.GONE);
                    soybeans_u.setVisibility(View.GONE);

                    egg_k.setVisibility(View.VISIBLE);
                    beef_k.setVisibility(View.VISIBLE);
                    pork_k.setVisibility(View.VISIBLE);
                    chicken_k.setVisibility(View.VISIBLE);
                    shrimp_k.setVisibility(View.VISIBLE);
                    crab_k.setVisibility(View.VISIBLE);
                    squid_k.setVisibility(View.VISIBLE);
                    mackerel_k.setVisibility(View.VISIBLE);
                    shellfish_k.setVisibility(View.VISIBLE);
                    milk_k.setVisibility(View.VISIBLE);
                    peach_k.setVisibility(View.VISIBLE);
                    peanut_k.setVisibility(View.VISIBLE);
                    walnut_k.setVisibility(View.VISIBLE);
                    pine_nut_k.setVisibility(View.VISIBLE);
                    tomato_k.setVisibility(View.VISIBLE);
                    soybean_k.setVisibility(View.VISIBLE);
                    wheat_k.setVisibility(View.VISIBLE);
                    buck_wheat_k.setVisibility(View.VISIBLE);
                    sulfurous_acid_k.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onButtonClick(View view) {
        barcodeLauncher.launch(new ScanOptions());
    }
}
