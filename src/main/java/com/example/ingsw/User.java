package com.example.ingsw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.sql.BatchUpdateException;

public class User extends Fragment {
    private Button buttonLogU;
    private Button buttonRegU;
    private Button buttonBkU;

    public User() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        buttonLogU = view.findViewById(R.id.buttonloginusr);
        buttonLogU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmMang.beginTransaction().replace(R.id.container, new Login(), null).commit();


            }


        });
        buttonRegU = view.findViewById(R.id.buttonregistrazioneusr);
        buttonRegU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmMang.beginTransaction().replace(R.id.container, new Registrazione(), null).commit();
            }
        });
        buttonBkU = view.findViewById(R.id.buttonbackusr);
        buttonBkU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homefragment homef = new homefragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean("accesso", false);
                homef.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.container, homef).commit();
            }
        });
        return view;

}  }
