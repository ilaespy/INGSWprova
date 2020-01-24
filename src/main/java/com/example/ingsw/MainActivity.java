package com.example.ingsw;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmMang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmMang = getSupportFragmentManager();
        if (findViewById(R.id.container)!= null){
            if (savedInstanceState !=null){
                return;
            }
            FragmentTransaction fragmentTransaction = fragmMang.beginTransaction();
            Benvenuto benvenuto = new Benvenuto();
            fragmentTransaction.add(R.id.container, benvenuto, null);
            fragmentTransaction.commit();
        }
    }
}
