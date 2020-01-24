package com.example.ingsw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class HomeStruttura extends Fragment {
          public String nome;
          public String indirizzo;
          public String telefono;
          public String tipo;
          public Integer aperto;
          public Integer chiuso;
          public Integer stelle;
          public boolean log;
          public String nrt;
          public String emailu;
          public String parola;

          public Button indietro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_struttura, container, false);

        Bundle b = getArguments();
        log = b.getBoolean("accesso");
        parola = b.getString("search");

        if (log) {
            nrt = b.getString("N1");
            emailu = b.getString("mail");}

        Struttura str = b.getParcelable("ExampleItem");

        nome = str.getNome();
        TextView txNome = view.findViewById(R.id.txN);
        txNome.setText(nome);

        indirizzo= str.getIndirizzo();
        TextView txIndi = view.findViewById(R.id.txI);
        txIndi.setText(indirizzo);

        telefono= str.getTel();
        TextView txTel = view.findViewById(R.id.txT);
        txTel.setText(telefono);

        tipo= str.getTipo();
        TextView txTip = view.findViewById(R.id.txTipo);
        txTip.setText(tipo);

        aperto=str.getApertura();
        TextView txApr= view.findViewById(R.id.txA);
        txApr.setText(Integer.toString(aperto));

        chiuso= str.getChiusura();
        TextView txCh= view.findViewById(R.id.txC);
        txCh.setText(Integer.toString(chiuso));

        stelle= str.getnStelle();
        TextView txStl= view.findViewById(R.id.txS);
        txStl.setText(Integer.toString(stelle));




        indietro=(Button) view.findViewById(R.id.back);
        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Risultati risultati= new Risultati();
                Bundle bundle = new Bundle();
                bundle.putBoolean("accesso", log);
                bundle.putString("search", parola);
                if (log) {
                    bundle.putString("Nl", nrt);
                    bundle.putString("Nem", emailu);
                }
                risultati.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.container, risultati).commit();
            }
        });



    return view;}


}
