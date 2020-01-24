package com.example.ingsw;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class Benvenuto extends Fragment {
    private Button welc;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_benvenuto, container, false);
        welc = view.findViewById(R.id.buttonwelcome);
        welc.setOnClickListener(new View.OnClickListener() {
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
    }
}