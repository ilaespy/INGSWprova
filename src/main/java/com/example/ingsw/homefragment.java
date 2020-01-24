package com.example.ingsw;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.MapView;

import java.util.ArrayList;
import java.util.Calendar;

public class homefragment extends Fragment {
    private Button button;
    private Button ristoranti;
    private Button hotel;
    private Button attrazioni;
    private TextView prova2;
    private String nrt;
    private String type;
    private Button ricerca;
    private EditText cerca;
    private boolean log;
    private String emailu;
    private CercaController cercaController;
    public homefragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_homefragment, container, false);

        Bundle b = getArguments();
         log = b.getBoolean("accesso");
        if (log) {
            nrt = b.getString("N1");
            emailu = b.getString("mail");
            prova2 = (TextView) view.findViewById(R.id.prova1);
            prova2.setText(nrt + " " + "accesso effettuato");
                 }

        button = view.findViewById(R.id.prox) ;
        button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          if (log){
              Bundle bundle = new Bundle();
              bundle.putBoolean("accesso", log );
                  bundle.putString("Nl",nrt);
                  bundle.putString("Nem", emailu);
              profile prof= new profile();
              prof.setArguments(bundle);
              FragmentManager manager2 = getFragmentManager();
              manager2.beginTransaction().replace(R.id.container, prof).commit();

          }
          else {

              MainActivity.fragmMang.beginTransaction().replace(R.id.container, new User(), null).commit();


      } }


    });

        cerca = (EditText) view.findViewById(R.id.searchV);

        ricerca = view.findViewById(R.id.mapsbt) ;

        ricerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeSS = cerca.getText().toString();
                if (!TextUtils.isEmpty(nomeSS)){
                Bundle bundle = new Bundle();
                bundle.putBoolean("accesso", log );
                if (log) {
                    bundle.putString("Nl",nrt);
                }

                bundle.putString("search",nomeSS);
Risultati risultati= new Risultati();
risultati.setArguments(bundle);
FragmentManager manager2 = getFragmentManager();
manager2.beginTransaction().replace(R.id.container, risultati).commit();

            } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Cosa vuoi cercare?");
                    builder.setMessage(" ");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }); builder.create().show();


            }  } } );
        Button mapsB = (Button) view.findViewById(R.id.buttonmappa);
        mapsB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(),MapsActivity.class);
                getActivity().startActivity(intent);
            }
        });


        hotel= (Button) view.findViewById(R.id.HotelB);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("accesso", log );
                    if (log) {
                        bundle.putString("Nl",nrt);
                    }
                    type ="hotel";
                    bundle.putString("search",type);
                    Risultati risultati= new Risultati();
                    risultati.setArguments(bundle);
                    FragmentManager manager2 = getFragmentManager();
                    manager2.beginTransaction().replace(R.id.container, risultati).commit();

                }
        });

        attrazioni = (Button) view.findViewById(R.id.AttrazioniB);
        attrazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("accesso", log );
                if (log) {
                    bundle.putString("Nl",nrt);
                }
                type ="attrazione";
                bundle.putString("search",type);
                Risultati risultati= new Risultati();
                risultati.setArguments(bundle);
                FragmentManager manager2 = getFragmentManager();
                manager2.beginTransaction().replace(R.id.container, risultati).commit();

            }
        });

        ristoranti=(Button) view.findViewById(R.id.RistorantiB);
        ristoranti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("accesso", log );
                if (log) {
                    bundle.putString("Nl",nrt);
                }
                type ="ristorante";
                bundle.putString("search",type);
                Risultati risultati= new Risultati();
                risultati.setArguments(bundle);
                FragmentManager manager2 = getFragmentManager();
                manager2.beginTransaction().replace(R.id.container, risultati).commit();


            }
        });

    return view;  }

    }

