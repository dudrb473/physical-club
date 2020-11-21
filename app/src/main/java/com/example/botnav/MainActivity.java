package com.example.botnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;//하단바
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;

    Button btnIninImg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIninImg=findViewById(R.id.btn_InitImg);



        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        bottomNavigationView = findViewById(R.id.botNavi);

        //frag와 버튼을 연결해주는 구문문
       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_airplane:
                        setFrag(0);
                        break;
                    case R.id.action_cloud:
                        setFrag(1);
                        break;
                    case R.id.action_favorite:
                        setFrag(2);
                        break;
                    case R.id.action_picture:
                        setFrag(3);
                        break;
                    case R.id.action_check:
                        setFrag(4);
                        break;

                }
                return true;
            }
        });
        frag1=new Frag1();
        frag2=new Frag2();
        frag3=new Frag3();
        frag4=new Frag4();
        frag5=new Frag5();
        setFrag(0);//처음 frag(화면)을 정해주는 구문
    }

    private  void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, frag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame, frag5);
                ft.commit();
                break;
        }
    }
}