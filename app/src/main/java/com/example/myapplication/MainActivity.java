package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.Toast;
import android.content.DialogInterface;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;



public class MainActivity<MyActivity> extends AppCompatActivity {
    //private CheckBox egg_k, beef_k, pork_k, chicken_k, shrimp_k, crab_k, squid_k, mackerel_k, shellfish_k, milk_k, peach_k, peanut_k, walnut_k, pine_nut_k, tomato_k, soybean_k, wheat_k, buck_wheat_k, sulfurous_acid_k;
    private CheckBox milk_u, egg_u, fish_u, crustaceanShellfish_u,  treeNuts_u, wheat_u, peanuts_u, soybeans_u;

    /*boolean eggAlK;
    boolean beefAlK;
    boolean porkAlK;
    boolean chickenAlK;
    boolean shrimpAlK;
    boolean crabAlK;
    boolean squidAlK;
    boolean mackerelAlK;
    boolean shellfishAlK;
    boolean milkAlK;
    boolean peachAlK;
    boolean peanutAlK;
    boolean walnutAlK;
    boolean pineNutAlK;
    boolean tomatoAlK;
    boolean soybeanAlK;
    boolean wheatAlK;
    boolean buckWheatAlK;
    boolean sulfurousAlK; */

    boolean milkAlU;
    boolean eggAlU;
    boolean fishAlU;
    boolean crustaceanShellfishAlU;
    boolean treeNutsAlU;
    boolean wheatAlU;
    boolean peanutsAlU;
    boolean soybeansAlU;


    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    String alResult = "";
                    String[] product = result.getContents().split("/");
                    int pdNum = result.getContents().length() - result.getContents().replace("/", "").length();
                    //System.out.println(product[0]);

                    for(int i =0; i< pdNum; i++) {
                        String food = product[i].split("&")[0];
                        String[] allergy = product[i].split("&")[1].split(",");
                        String warn ="";
                        int alNum = product[i].length() - product[i].replace(",", "").length() + 1; // 알러지 정보 쉼표의 개수

                        for(int j=0; j < alNum; j++) {
                            String alInform = allergy[j].trim();
                            /*if(eggAlK && alInform.equals("계란")) {
                                warn += "계란 ";
                            }if(beefAlK && alInform.equals("쇠고기")) {
                                warn += "쇠고기 ";
                            }if(porkAlK && alInform.equals("돼지고기")) {
                                warn += "돼지고기 ";
                            }if(chickenAlK && alInform.equals("닭고기")) {
                                warn += "닭고기 ";
                            }if(shrimpAlK && alInform.equals("새우")) {
                                warn += "새우 ";
                            }if(crabAlK && alInform.equals("게")) {
                                warn += "게 ";
                            }if(squidAlK && alInform.equals("오징어")) {
                                warn += "오징어 ";
                            }if(mackerelAlK && alInform.equals("고등어")) {
                                warn += "고등어 ";
                            }if(shellfishAlK && alInform.equals("조개류")) {
                                warn += "조개류 ";
                            }if(milkAlK && alInform.equals("우유")) {
                                warn += "우유 ";
                            }if(peachAlK && alInform.equals("복숭아")) {
                                warn += "복숭아 ";
                            }if(peanutAlK && alInform.equals("땅콩")) {
                                warn += "땅콩 ";
                            }if(walnutAlK && alInform.equals("호두")) {
                                warn += "호두 ";
                            }if(pineNutAlK && alInform.equals("잣")) {
                                warn += "잣 ";
                            }if(tomatoAlK && alInform.equals("토마토")) {
                                warn += "토마토 ";
                            }if(soybeanAlK && alInform.equals("대두")) {
                                warn += "대두 ";
                            }if(wheatAlK && alInform.equals("밀")) {
                                warn += "밀 ";
                            }if(buckWheatAlK && alInform.equals("메밀")) {
                                warn += "메밀 ";
                            }if(sulfurousAlK && alInform.equals("아황산")) {
                                warn += "아황산 ";
                            } */
                            if(milkAlU && alInform.equals("milk")) {
                                warn += "milk ";
                            }if(eggAlU && alInform.equals("egg")) {
                                warn += "egg ";
                            }if(fishAlU && alInform.equals("fish")) {
                                warn += "fish ";
                            }if(crustaceanShellfishAlU) {
                                if(alInform.equals("crustacean")) {
                                    warn += "crustacean ";
                                } if(alInform.equals("shellfish")){
                                    warn += "shellfish ";
                                }
                            } if( treeNutsAlU && alInform.equals("tree nuts")) {
                                warn += "tree nuts ";
                            } if(wheatAlU && alInform.equals("wheat")) {
                                warn += "wheat ";
                            } if(peanutsAlU && alInform.equals("peanuts")) {
                                warn += "peanuts ";
                            } if(soybeansAlU && alInform.equals("soybeans")) {
                                warn += "soybeans";
                            }


                        }
                        if(warn.length() > 0) {
                            AlertDialog.Builder menu = new AlertDialog.Builder(MainActivity.this);
                            menu.setIcon(R.mipmap.ic_launcher);
                            menu.setTitle("알러지 검출");
                            menu.setMessage(food + "에서 " + warn + "알러지가 당신의 알러지와 일치합니다.");

                            menu.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                        }
                    }
                    Toast.makeText(MainActivity.this, "Scanned: " + alResult, Toast.LENGTH_LONG).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* egg_k = findViewById(R.id.checkBox_egg_k);
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

        egg_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(egg_k.isChecked()){
                    eggAlK = true;
                    System.out.println(eggAlK);
                }
                else {
                    eggAlK =false;
                    System.out.println(eggAlK);
                }
            }
        });
        beef_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(beef_k.isChecked()){
                    beefAlK = true;
                }
                else {
                    beefAlK =false;
                }
            }
        });
        pork_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pork_k.isChecked()){
                    porkAlK = true;
                }
                else {
                    porkAlK =false;
                }
            }
        });
        chicken_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chicken_k.isChecked()){
                    chickenAlK = true;
                }
                else {
                    chickenAlK =false;
                }
            }
        });
        shrimp_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(shrimp_k.isChecked()){
                    shrimpAlK = true;
                }
                else {
                    shrimpAlK =false;
                }
            }
        });
        crab_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(crab_k.isChecked()){
                    crabAlK = true;
                }
                else {
                    crabAlK =false;
                }
            }
        });
        squid_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(squid_k.isChecked()){
                    squidAlK = true;
                }
                else {
                    squidAlK =false;
                }
            }
        });
       mackerel_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mackerel_k.isChecked()){
                    mackerelAlK = true;
                }
                else {
                    mackerelAlK =false;
                }
            }
        });
        shellfish_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(shellfish_k.isChecked()){
                    shellfishAlK = true;
                }
                else {
                    shellfishAlK =false;
                }
            }
        });
        milk_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(milk_k.isChecked()){
                    milkAlK = true;
                }
                else {
                    milkAlK =false;
                }
            }
        });
        peach_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(peach_k.isChecked()){
                    peachAlK = true;
                }
                else {
                    peachAlK =false;
                }
            }
        });
        peanut_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(peanut_k.isChecked()){
                    peanutAlK = true;
                }
                else {
                    peanutAlK =false;
                }
            }
        });
       walnut_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(walnut_k.isChecked()){
                    walnutAlK = true;
                }
                else {
                    walnutAlK =false;
                }

            }
        });
       pine_nut_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pine_nut_k.isChecked()){
                    pineNutAlK = true;
                }
                else {
                    pineNutAlK =false;
                }
            }
        });
        tomato_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tomato_k.isChecked()){
                    tomatoAlK = true;
                }
                else {
                    tomatoAlK =false;
                }
            }
        });
        soybean_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(soybean_k.isChecked()){
                    soybeanAlK = true;
                }
                else {
                    soybeanAlK =false;
                }
            }
        });
       wheat_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wheat_k.isChecked()){
                    wheatAlK = true;
                }
                else {
                    wheatAlK =false;
                }
            }
        });
        buck_wheat_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buck_wheat_k.isChecked()){
                    buckWheatAlK = true;
                }
                else {
                    buckWheatAlK =false;
                }
            }
        });
       sulfurous_acid_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sulfurous_acid_k.isChecked()){
                    sulfurousAlK = true;
                }
                else {
                    sulfurousAlK =false;
                }
            }
        }); */

        milk_u = findViewById(R.id.checkBox_milk_u);
        egg_u = findViewById(R.id.checkBox_egg_u);
        fish_u = findViewById(R.id.checkBox_fish_u);
        crustaceanShellfish_u = findViewById(R.id.checkBox_crustaceanShellfishAlU_u);
        treeNuts_u = findViewById(R.id.checkBox_treeNuts_u);
        wheat_u = findViewById(R.id.checkBox_wheat_u);
        peanuts_u = findViewById(R.id.checkBox_peanuts_u);
        soybeans_u = findViewById(R.id.checkBox_soybeans_u);




        milk_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(milk_u.isChecked()){
                    milkAlU = true;
                }
                else {
                    milkAlU=false;
                }
            }
        });
        egg_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(egg_u.isChecked()){
                    eggAlU = true;
                }
                else {
                    eggAlU=false;
                }
            }
        });
        fish_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fish_u.isChecked()){
                    fishAlU = true;
                }
                else {
                    fishAlU=false;
                }
            }
        });
        crustaceanShellfish_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(crustaceanShellfish_u.isChecked()){
                    crustaceanShellfishAlU = true;
                }
                else {
                    crustaceanShellfishAlU=false;
                }
            }
        });
        treeNuts_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(treeNuts_u.isChecked()){
                    treeNutsAlU = true;
                }
                else {
                    treeNutsAlU = false;
                }
            }
        });
        treeNuts_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(treeNuts_u.isChecked()){
                    treeNutsAlU = true;
                }
                else {
                    treeNutsAlU = false;
                }
            }
        });
        wheat_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wheat_u.isChecked()){
                    wheatAlU = true;
                }
                else {
                    wheatAlU = false;
                }
            }
        });
        peanuts_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(peanuts_u.isChecked()){
                    peanutsAlU = true;
                }
                else {
                    peanutsAlU = false;
                }
            }
        });
        soybeans_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(soybeans_u.isChecked()){
                    soybeansAlU = true;
                }
                else {
                    soybeansAlU = false;
                }
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
    }}