package com.example.ingsw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Recensione extends Fragment {


    private RadioButton s1;
    private RadioButton s2;
    private RadioButton s3;
    private RadioButton s4;
    private RadioButton s5;
    private EditText testo;
    private TextView nu;
    private boolean login;
    private Button invioreview;
    private Button backreview;
    private String mailchepassa;
    private RecensioneController RecensioneContr;
    private Integer numerostelle = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recensione, container, false);
        RecensioneContr = new RecensioneController(this);
        testo = (EditText) view.findViewById(R.id.recensionetxt);
       Bundle b = getArguments();
        login = b.getBoolean("accesso");
        if(login){
             mailchepassa = b.getString("Nl");
            nu = (TextView) view.findViewById(R.id.nutreview);
            nu.setText(mailchepassa);
        }
        else {
            nu = (TextView) view.findViewById(R.id.nutreview);
            nu.setText("effettua l'accesso prima di lasciare una recensione");
        }


        s1 = (RadioButton) view.findViewById(R.id.stella1);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s2.setChecked(false);
                s3.setChecked(false);
                s4.setChecked(false);
                s5.setChecked(false);
                numerostelle = 1;
            }
        });
        s2 = (RadioButton) view.findViewById(R.id.stella2);
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setChecked(true);
                s3.setChecked(false);
                s4.setChecked(false);
                s5.setChecked(false);
                numerostelle = 2;
            }
        });
        s3 = (RadioButton) view.findViewById(R.id.stella3);
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setChecked(true);
                s2.setChecked(true);
                s4.setChecked(false);
                s5.setChecked(false);
                numerostelle = 3;
            }
        });
        s4 = (RadioButton) view.findViewById(R.id.stella4);
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setChecked(true);
                s2.setChecked(true);
                s3.setChecked(true);
                s5.setChecked(false);
                numerostelle = 4;
            }
        });
        s5 = (RadioButton) view.findViewById(R.id.stella5);
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setChecked(true);
                s2.setChecked(true);
                s3.setChecked(true);
                s4.setChecked(true);
                numerostelle = 5;
            }
        });
       invioreview = (Button) view.findViewById(R.id.buttoninvioreview);
       invioreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login) {
                    String ema = testo.getText().toString();
                          if(TextUtils.isEmpty(ema) || numerostelle == 0) {
                          Toast.makeText(getActivity(), "Riempi tutti i campi!", Toast.LENGTH_LONG).show();}
                        else {
                            invioreview.setEnabled(false);
                            boolean returnreview = RecensioneContr.inviaRecensione(testo.getText().toString(), nu.getText().toString(), numerostelle);
                            if(returnreview){
                            Toast.makeText(getActivity(), "La tua recensione sarà presto valutata!", Toast.LENGTH_LONG).show();
                            //salvorecensione
                            homefragment homef = new homefragment();
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("accesso", login);
                            bundle.putString("N1", mailchepassa);
                            homef.setArguments(bundle);
                            FragmentManager manager = getFragmentManager();
                            manager.beginTransaction().replace(R.id.container, homef).commit();
                        } } }
                else {
                    Toast.makeText(getActivity(), "Prima di lasciare una recensione effettua l'accesso!", Toast.LENGTH_LONG).show();


                }
            }
        });

        backreview = (Button) view.findViewById(R.id.buttonbackrecensioni);
        backreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homefragment homef = new homefragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean("accesso", login);
                if (login){
                bundle.putString("N1", mailchepassa);}
                homef.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.container, homef).commit();
            }
        });



return view;



} }
