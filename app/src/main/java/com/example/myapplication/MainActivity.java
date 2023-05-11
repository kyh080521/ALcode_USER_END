package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity<MyActivity> extends AppCompatActivity {
    private LinearLayout KOR, USA;
    private LinearLayout chicken_k, shrimp_k, crab_k, squid_k, mackerel_k, shellfish_k, milk_k, peach_k, peanut_k, walnut_k, pine_nut_k, tomato_k, soybean_k, wheat_k, buck_wheat_k, sulfurous_acid_k, egg_k, beef_k, pork_k;
    private LinearLayout egg_u, milk_u, fish_u, shellfish_u, treeNuts_u, wheat_u, peanuts_u, soybeans_u;
    private Spinner spinner_language, spinner_nationality;
    /*private TextView textView_consider;
    private TextView text_egg_k, text_beef_k, text_pork_k, text_chicken_k, text_shrimp_k,  text_crab_k, text_squid_k,  text_mackerel_k,  text_shellfish_k,  text_milk_k,  text_peach_k,  text_peanut_k, text_walnut_k, text_pine_nut_k, text_tomato_k, text_soybean_k, text_wheat_k, text_buck_wheat_k, text_sulfurous_acid_k;
    private TextView text_milk_u, text_egg_u, text_fish_u, text_shellfish_u, text_treeNuts_u, text_wheat_u, text_peanuts_u, text_soybeans_u;
    private ImageView image_egg_k, image_beef_k, image_pork_k, image_chicken_k, image_shrimp_k,  image_crab_k, image_squid_k,  image_mackerel_k,  image_shellfish_k,  image_milk_k,  image_peach_k,  image_peanut_k, image_walnut_k, image_pine_nut_k, image_tomato_k, image_soybean_k, image_wheat_k, image_buck_wheat_k, image_sulfurous_acid_k;
    private ImageView image_milk_u, image_egg_u, image_fish_u, image_shellfish_u, image_treeNuts_u, image_wheat_u, image_peanuts_u, image_soybeans_u; */
    private Dialog dialog_layout;
    private Color Color;
    private ListView listview;

    /*String[] alFish=new String[]{"Anchovies", "Bass", "Catfish", " Cod", " Flounder", " Grouper", " Haddock", "Hake", "Halibut", "Herring", "Mahi mahi", "Perch", " Pike", "Pollock", " Salmon", "Scrod", " Sole", " Snapper", " Swordfish", "Tilapia", "Trout", "Tuna"};
    String[] alShellfish = new String[]{"Barnacle", "Crab",  "Crawfish", " Krill", " Lobster", "Prawns", "Shrimp"};
    String[] alNuts = new String[]{"Almond", "Artificial nuts", "Beechnut", "Black walnut", "Brazil nut", "Butternut", "Cashew", "Chestnut", "Chinquapin nut", "Coconut"}; */

    Allergy alMilkU = new Allergy("Milk", "우유",  1, false);
    Allergy alEggsU = new Allergy("Eggs", "난류",1, false);
    Allergy alFishU = new Allergy("Fish", "생선",1, false);
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

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if (result.getContents() == null) {
                    Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    String[] product = result.getContents().split("/");
                    int pdNum = result.getContents().length() - result.getContents().replace("/", "").length();
                    String fdResult = "";

                    for (int i = 0; i < pdNum; i++) {
                        String food = product[i].split("&")[0];
                        String[] allergy = product[i].split("&")[1].split(",");
                        String warn = "";
                        int alNum = product[i].length() - product[i].replace(",", "").length() + 1; // 알러지 정보 쉼표의 개수

                        for (int j = 0; j < alNum; j++) {
                            String alInform = allergy[j].trim();
                            if(nationalNum == 1) {
                                if (alMilkU.allergyCompare(alInform)) {
                                    warn += alMilkU.warnMessage();
                                } if (alEggsU.allergyCompare(alInform)) {
                                    warn += alEggsU.warnMessage();
                                } if (alFishU.allergyCompare(alInform)) {
                                    warn += alFishU.warnMessage();
                                } if (alShellfishU.allergyCompare(alInform)) {
                                    warn += alShellfishU.warnMessage();
                                } if (alNutsU.allergyCompare(alInform)) {
                                    warn += alNutsU.warnMessage();
                                } if (alWheatU.allergyCompare(alInform)) {
                                    warn += alWheatU.warnMessage();
                                } if (alPeanutsU.allergyCompare(alInform)) {
                                    warn += alPeanutsU.warnMessage();
                                } if (alSoybeansU.allergyCompare(alInform)) {
                                    warn += alSoybeansU.warnMessage();
                                } if (alInform.equals("Hazelnut") && alNutsU.alTake) {
                                    warn += "Hazelnut, ";
                                }
                            } else if(nationalNum == 82) {
                                if (alEggsK.allergyCompare(alInform)) {
                                    warn += alEggsK.warnMessage();
                                }if (alBeefK.allergyCompare(alInform)) {
                                    warn += alBeefK.warnMessage();
                                }if(alPorkK.allergyCompare(alInform)) {
                                    warn += alPorkK.warnMessage();
                                }if(alChickenK.allergyCompare(alInform)) {
                                    warn += alChickenK.warnMessage();
                                }if(alShrimpK.allergyCompare(alInform)) {
                                    warn += alShrimpK.warnMessage();
                                }if(alCrabK.allergyCompare(alInform)) {
                                    warn += alCrabK.warnMessage();
                                }if(alSquidK.allergyCompare(alInform)) {
                                    warn += alSquidK.warnMessage();
                                }if(alMackerelK.allergyCompare(alInform)) {
                                    warn += alMackerelK.warnMessage();
                                }if(alShellfishK.allergyCompare(alInform)) {
                                    warn += alShellfishK.warnMessage();
                                }if(alMilkK.allergyCompare(alInform)) {
                                    warn += alMilkK.warnMessage();
                                }if(alPeachK.allergyCompare(alInform)) {
                                    warn += alPeachK.warnMessage();
                                }if(alPeanutK.allergyCompare(alInform)){
                                    warn += alPeanutK.warnMessage();
                                }if(alWalnutK.allergyCompare(alInform)) {
                                    warn += alWalnutK.warnMessage();
                                }if(alPineNutK.allergyCompare(alInform)) {
                                    warn += alPineNutK.warnMessage();
                                }if(alTomatoK.allergyCompare(alInform)) {
                                    warn += alTomatoK.warnMessage();
                                }if(alSoybeanK.allergyCompare(alInform)) {
                                    warn += alSoybeanK.warnMessage();
                                }if(alWheatK.allergyCompare(alInform)) {
                                    warn += alWheatK.warnMessage();
                                }if(alBuckWheatK.allergyCompare(alInform)) {
                                    warn += alBuckWheatK.warnMessage();
                                }if(alSulfurousAcidK.allergyCompare(alInform)) {
                                    warn += alSulfurousAcidK.warnMessage();
                                }
                            }
                        }
                        /*if(warn.length() == 0) {
                            warn = "safe";
                            fdResult += food + "\n"+ warn + "\n\n";
                        } */
                        if (warn.length() > 0) {
                            fdResult += food + "\n*allergy : " + warn + "\n\n";
                        }
                    }
                    showDialogLayout(fdResult, pdNum);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog_layout = new Dialog(MainActivity.this);       // Dialog 초기화
        dialog_layout.setContentView(R.layout.dialog_layout);             // xml 레이아웃 파일과 연결

        KOR = findViewById(R.id.linear_KOR);
        USA = findViewById(R.id.linear_USA);

        egg_k = findViewById(R.id.linear_egg_k);
        beef_k = findViewById(R.id.linear_beef_k);
        pork_k = findViewById(R.id.linear_pork_k);
        chicken_k = findViewById(R.id.linear_chicken_k);
        shrimp_k = findViewById(R.id.linear_shrimp_k);
        crab_k = findViewById(R.id.linear_crab_k);
        squid_k = findViewById(R.id.linear_squid_k);
        mackerel_k = findViewById(R.id.linear_mackerel_k);
        shellfish_k = findViewById(R.id.linear_shellfish_k);
        milk_k = findViewById(R.id.linear_milk_k);
        peach_k = findViewById(R.id.linear_peach_k);
        peanut_k = findViewById(R.id.linear_peanut_k);
        walnut_k = findViewById(R.id.linear_walnut_k);
        pine_nut_k = findViewById(R.id.linear_pine_nut_k);
        tomato_k = findViewById(R.id.linear_tomato_k);
        soybean_k = findViewById(R.id.linear_soybean_k);
        wheat_k = findViewById(R.id.linear_wheat_k);
        buck_wheat_k = findViewById(R.id.linear_buck_wheat_k);
        sulfurous_acid_k = findViewById(R.id.linear_sulfurous_acid_k);

        milk_u = findViewById(R.id.linear_milk_u);
        egg_u = findViewById(R.id.linear_egg_u);
        fish_u = findViewById(R.id.linear_fish_u);
        shellfish_u = findViewById(R.id.linear_shellfish_u);
        treeNuts_u = findViewById(R.id.linear_treeNuts_u);
        wheat_u = findViewById(R.id.linear_wheat_u);
        peanuts_u = findViewById(R.id.linear_peanuts_u);
        soybeans_u = findViewById(R.id.linear_soybeans_u);

        /*text_egg_k = findViewById(R.id.text_egg_k);
        text_beef_k = findViewById(R.id.text_beef_k);
        text_pork_k = findViewById(R.id.text_pork_k);
        text_chicken_k = findViewById(R.id.text_chicken_k);
        text_shrimp_k = findViewById(R.id.text_shrimp_k);
        text_crab_k = findViewById(R.id.text_crab_k);
        text_squid_k = findViewById(R.id.text_squid_k);
        text_mackerel_k = findViewById(R.id. text_mackerel_k);
        text_shellfish_k = findViewById(R.id.text_shellfish_k);
        text_milk_k = findViewById(R.id.text_milk_k);
        text_peach_k = findViewById(R.id.text_peach_k);
        text_peanut_k = findViewById(R.id.text_peanut_k);
        text_walnut_k = findViewById(R.id.text_walnut_k);
        text_pine_nut_k = findViewById(R.id.text_pine_nut_k);
        text_tomato_k = findViewById(R.id.text_tomato_k);
        text_soybean_k = findViewById(R.id.text_soybean_k);
        text_wheat_k = findViewById(R.id.text_wheat_k);
        text_buck_wheat_k = findViewById(R.id.text_buck_wheat_k);
        text_sulfurous_acid_k = findViewById(R.id.text_sulfurous_acid_k);

        text_milk_u = findViewById(R.id.text_milk_u);
        text_egg_u = findViewById(R.id.text_egg_u);
        text_fish_u = findViewById(R.id.text_fish_u);
        text_shellfish_u = findViewById(R.id.text_shellfish_u);
        text_treeNuts_u = findViewById(R.id.text_treeNuts_u);
        text_wheat_u = findViewById(R.id.text_wheat_u);
        text_peanuts_u = findViewById(R.id.text_peanuts_u);
        text_soybeans_u = findViewById(R.id.text_soybeans_u);

        image_egg_k = findViewById(R.id.image_egg_k);
        image_beef_k = findViewById(R.id.image_beef_k);
        image_pork_k = findViewById(R.id.image_pork_k);
        image_chicken_k = findViewById(R.id.image_chicken_k);
        image_shrimp_k = findViewById(R.id.image_shrimp_k);
        image_crab_k = findViewById(R.id.image_crab_k);
        image_squid_k = findViewById(R.id.image_squid_k);
        image_mackerel_k = findViewById(R.id. image_mackerel_k);
        image_shellfish_k = findViewById(R.id.image_shellfish_k);
        image_milk_k = findViewById(R.id.image_milk_k);
        image_peach_k = findViewById(R.id.image_peach_k);
        image_peanut_k = findViewById(R.id.image_peanut_k);
        image_walnut_k = findViewById(R.id.image_walnut_k);
        image_pine_nut_k = findViewById(R.id.image_pine_nut_k);
        image_tomato_k = findViewById(R.id.image_tomato_k);
        image_soybean_k = findViewById(R.id.image_soybean_k);
        image_wheat_k = findViewById(R.id.image_wheat_k);
        image_buck_wheat_k = findViewById(R.id.image_buck_wheat_k);
        image_sulfurous_acid_k = findViewById(R.id.image_sulfurous_acid_k);

        image_milk_u = findViewById(R.id.image_milk_u);
        image_egg_u = findViewById(R.id.image_egg_u);
        image_fish_u = findViewById(R.id.image_fish_u);
        image_shellfish_u = findViewById(R.id.image_shellfish_u);
        image_treeNuts_u = findViewById(R.id.image_treeNuts_u);
        image_wheat_u = findViewById(R.id.image_wheat_u);
        image_peanuts_u = findViewById(R.id.image_peanuts_u);
        image_soybeans_u = findViewById(R.id.image_soybeans_u);

        textView_consider = findViewById(R.id.textView_consider);

        spinner_language = (Spinner)findViewById(R.id.spinner_language); */
        spinner_nationality = (Spinner)findViewById(R.id.spinner_nationality);

        egg_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alEggsK.buttonTurn(!alEggsK.alTake);
                //System.out.println(alEggsK.alTake);
                egg_k.setBackgroundColor(Color.parseColor(alEggsK.backgroundColorSet()));
            }
        });
        beef_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alBeefK.buttonTurn(!alBeefK.alTake);
                beef_k.setBackgroundColor(Color.parseColor(alBeefK.backgroundColorSet()));
            }
        });
        pork_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alPorkK.buttonTurn(!alPorkK.alTake);
                pork_k.setBackgroundColor(Color.parseColor(alPorkK.backgroundColorSet()));
            }
        });
        chicken_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alChickenK.buttonTurn(!alChickenK.alTake);
                chicken_k.setBackgroundColor(Color.parseColor(alChickenK.backgroundColorSet()));
            }
        });
        shrimp_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alShrimpK.buttonTurn(!alShrimpK.alTake);
                shrimp_k.setBackgroundColor(Color.parseColor(alShrimpK.backgroundColorSet()));
            }
        });
        crab_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alCrabK.buttonTurn(!alCrabK.alTake);
                crab_k.setBackgroundColor(Color.parseColor(alCrabK.backgroundColorSet()));
            }
        });
        squid_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alSquidK.buttonTurn(!alSquidK.alTake);
                squid_k.setBackgroundColor(Color.parseColor(alSquidK.backgroundColorSet()));
            }
        });
        mackerel_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alMackerelK.buttonTurn(!alMackerelK.alTake);
                mackerel_k.setBackgroundColor(Color.parseColor(alMackerelK.backgroundColorSet()));
            }
        });
        shellfish_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alShellfishK.buttonTurn(!alShellfishK.alTake);
                shellfish_k.setBackgroundColor(Color.parseColor(alShellfishK.backgroundColorSet()));
            }
        });
        milk_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alMilkK.buttonTurn(!alMilkK.alTake);
                milk_k.setBackgroundColor(Color.parseColor(alMilkK.backgroundColorSet()));
            }
        });
        peach_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alPeachK.buttonTurn(!alPeachK.alTake);
                peach_k.setBackgroundColor(Color.parseColor(alPeachK.backgroundColorSet()));
            }
        });
        peanut_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alPeanutK.buttonTurn(!alPeanutK.alTake);
                peanut_k.setBackgroundColor(Color.parseColor(alPeanutK.backgroundColorSet()));
            }
        });
        walnut_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alWalnutK.buttonTurn(!alWalnutK.alTake);
                walnut_k.setBackgroundColor(Color.parseColor(alWalnutK.backgroundColorSet()));
            }
        });
        pine_nut_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alPineNutK.buttonTurn(!alPineNutK.alTake);
                pine_nut_k.setBackgroundColor(Color.parseColor(alPineNutK.backgroundColorSet()));
            }
        });
        tomato_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alTomatoK.buttonTurn(!alTomatoK.alTake);
                tomato_k.setBackgroundColor(Color.parseColor(alTomatoK.backgroundColorSet()));
            }
        });
        soybean_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alSoybeanK.buttonTurn(!alSoybeanK.alTake);
                soybean_k.setBackgroundColor(Color.parseColor(alSoybeanK.backgroundColorSet()));
            }
        });
        wheat_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alWheatK.buttonTurn(!alWheatK.alTake);
                wheat_k.setBackgroundColor(Color.parseColor(alWheatK.backgroundColorSet()));
            }
        });
        buck_wheat_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alBuckWheatK.buttonTurn(!alBuckWheatK.alTake);
                buck_wheat_k.setBackgroundColor(Color.parseColor(alBuckWheatK.backgroundColorSet()));
            }
        });
        sulfurous_acid_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alSulfurousAcidK.buttonTurn(!alSulfurousAcidK.alTake);
                sulfurous_acid_k.setBackgroundColor(Color.parseColor(alSulfurousAcidK.backgroundColorSet()));
            }
        });


        egg_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alEggsU.buttonTurn(!alEggsU.alTake);
                egg_u.setBackgroundColor(Color.parseColor(alEggsU.backgroundColorSet()));
            }
        });
        milk_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alMilkU.buttonTurn(!alMilkU.alTake);
                milk_u.setBackgroundColor(Color.parseColor(alMilkU.backgroundColorSet()));
            }
        });
        fish_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alFishU.buttonTurn(!alFishU.alTake);
                fish_u.setBackgroundColor(Color.parseColor(alFishU.backgroundColorSet()));
            }
        });
        shellfish_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alShellfishU.buttonTurn(!alShellfishU.alTake);
                shellfish_u.setBackgroundColor(Color.parseColor(alShellfishU.backgroundColorSet()));
            }
        });
        treeNuts_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alNutsU.buttonTurn(!alNutsU.alTake);
                treeNuts_u.setBackgroundColor(Color.parseColor(alNutsU.backgroundColorSet()));
            }
        });
        wheat_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alWheatU.buttonTurn(!alWheatU.alTake);
                wheat_u.setBackgroundColor(Color.parseColor(alWheatU.backgroundColorSet()));
            }
        });
        peanuts_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alPeanutsU.buttonTurn(!alPeanutsU.alTake);
                peanuts_u.setBackgroundColor(Color.parseColor(alPeanutsU.backgroundColorSet()));
            }
        });
        soybeans_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alSoybeansU.buttonTurn(!alSoybeansU.alTake);
                soybeans_u.setBackgroundColor(Color.parseColor(alSoybeansU.backgroundColorSet()));
            }
        });

        /*spinner_language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner_language.getItemAtPosition(position).toString().equals("English")) {
                   languageNum = 1;

                   text_milk_u.setText(alMilkU.alNameU);
                   text_egg_u.setText(alEggsU.alNameU);
                   text_fish_u.setText(alFishU.alNameU);
                   text_shellfish_u.setText(alShellfishU.alNameU);
                   text_treeNuts_u.setText(alNutsU.alNameU);
                   text_wheat_u.setText(alWheatU.alNameU);
                   text_peanuts_u.setText(alPeanutsU.alNameU);
                   text_soybeans_u.setText(alSoybeansU.alNameU);

                   text_egg_k.setText(alEggsK.alNameU);
                   text_beef_k.setText(alBeefK.alNameU);
                   text_pork_k.setText(alPorkK.alNameU);
                   text_chicken_k.setText(alChickenK.alNameU);
                   text_shrimp_k.setText(alShrimpK.alNameU);
                   text_crab_k.setText(alCrabK.alNameU);
                   text_squid_k.setText(alSquidK.alNameU);
                   text_mackerel_k.setText(alMackerelK.alNameU);
                   text_shellfish_k.setText(alShellfishK.alNameU);
                   text_milk_k.setText(alMilkK.alNameU);
                   text_peach_k.setText(alPeachK.alNameU);
                   text_peanut_k.setText(alPeanutK.alNameU);
                   text_walnut_k.setText(alWalnutK.alNameU);
                   text_pine_nut_k.setText(alPineNutK.alNameU);
                   text_tomato_k.setText(alTomatoK.alNameU);
                   text_soybean_k.setText(alSoybeanK.alNameU);
                   text_wheat_k.setText(alWheatK.alNameU);
                   text_buck_wheat_k.setText(alBuckWheatK.alNameU);
                   text_sulfurous_acid_k.setText(alSulfurousAcidK.alNameU);

                   textView_consider.setText("Check your Allergy");
                   textView_consider.setTextSize(27);
               } else if(spinner_language.getItemAtPosition(position).toString().equals("한국어")) {
                   languageNum = 82;

                   text_milk_u.setText(alMilkU.alNameK);
                   text_egg_u.setText(alEggsU.alNameK);
                   text_fish_u.setText(alFishU.alNameK);
                   text_shellfish_u.setText(alShellfishU.alNameK);
                   text_treeNuts_u.setText(alNutsU.alNameK);
                   text_wheat_u.setText(alWheatU.alNameK);
                   text_peanuts_u.setText(alPeanutsU.alNameK);
                   text_soybeans_u.setText(alSoybeansU.alNameK);

                   text_egg_k.setText(alEggsK.alNameK);
                   text_beef_k.setText(alBeefK.alNameK);
                   text_pork_k.setText(alPorkK.alNameK);
                   text_chicken_k.setText(alChickenK.alNameK);
                   text_shrimp_k.setText(alShrimpK.alNameK);
                   text_crab_k.setText(alCrabK.alNameK);
                   text_squid_k.setText(alSquidK.alNameK);
                   text_mackerel_k.setText(alMackerelK.alNameK);
                   text_shellfish_k.setText(alShellfishK.alNameK);
                   text_milk_k.setText(alMilkK.alNameK);
                   text_peach_k.setText(alPeachK.alNameK);
                   text_peanut_k.setText(alPeanutK.alNameK);
                   text_walnut_k.setText(alWalnutK.alNameK);
                   text_pine_nut_k.setText(alPineNutK.alNameK);
                   text_tomato_k.setText(alTomatoK.alNameK);
                   text_soybean_k.setText(alSoybeanK.alNameK);
                   text_wheat_k.setText(alWheatK.alNameK);
                   text_buck_wheat_k.setText(alBuckWheatK.alNameK);
                   text_sulfurous_acid_k.setText(alSulfurousAcidK.alNameK);

                   textView_consider.setText("알러지를 체크해주세요");
                   textView_consider.setTextSize(24);
               }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); */


        spinner_nationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner_nationality.getItemAtPosition(position).toString().equals("USA")) {
                    nationalNum = 1;

                    KOR.setVisibility(View.GONE);
                    USA.setVisibility(View.VISIBLE);
                } else if(spinner_nationality.getItemAtPosition(position).toString().equals("Korea")) {
                    nationalNum = 82;

                    KOR.setVisibility(View.VISIBLE);
                    USA.setVisibility(View.GONE);
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
    public void showDialogLayout(String foodResult, int pdNum){
        int pdNm = pdNum;

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog_layout.getWindow().getAttributes());
        lp.width = 1000;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog_layout.show();

        Window window = dialog_layout.getWindow();
        window.setAttributes(lp);

        Button OKBtn = dialog_layout.findViewById(R.id.btnOK);
        OKBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_layout.dismiss();
            }
        });
        TextView WarnMessage = dialog_layout.findViewById(R.id.textMessage);
        TextView PrNumMessage = dialog_layout.findViewById(R.id.textTitleBottom);
        WarnMessage.setText(foodResult);
        PrNumMessage.setText("( " + pdNum+" )");
    }
    /*public class ListViewAdapter extends BaseAdapter {
        ArrayList<Food> items = new ArrayList<Food>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Food item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final Food product = items.get(position);

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.dialog_layout, viewGroup, false);

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            TextView tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);

            tv_num.setText(bearItem.getNum());
            tv_name.setText(bearItem.getName());
            iv_icon.setImageResource(bearItem.getResId());
            Log.d(TAG, "getView() - [ "+position+" ] "+bearItem.getName());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, bearItem.getNum()+" 번 - "+bearItem.getName()+" 입니당! ", Toast.LENGTH_SHORT).show();
                }
            });

        }
    } */
}

