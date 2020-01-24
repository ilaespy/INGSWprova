package com.example.ingsw;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;


public class Risultati extends Fragment {
    private String nrt;
    private boolean log;
    private String parola;
    private String emailu;
    private CercaController cercaController;
    private Button back;
    private String filtroStruttura;


    //lista
    private RecyclerView recyclerView;
    private ExampleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_risultati, container, false);
        cercaController= new CercaController(this);
        EditText numerost = view.findViewById(R.id.ns);
        final String stelle= numerost.getText().toString();
        final RadioButton bottonH= view.findViewById(R.id.hotelRb);
        final RadioButton bottonR= view.findViewById(R.id.ristoranteRb);
        final RadioButton bottonA= view.findViewById(R.id.attrazioneRb);
        CheckBox aperti =view.findViewById(R.id.apertura);
        Button cercaf= view.findViewById(R.id.cercafiltri);

        Bundle b = getArguments();
        log = b.getBoolean("accesso");
        parola= b.getString("search");

            if (log) {
                nrt = b.getString("N1");
                emailu = b.getString("mail");}
        //lista
        final ArrayList<Struttura> struttura = new ArrayList<>();


        struttura.add(new Struttura("pizza", "cocco", "123","albergo", 2 , 4, 22));
        struttura.add(new Struttura("pino", "biscotto", "43", "albergo", 2 , 4, 22));
        struttura.add(new Struttura("pasta", "torta", "4535", "albergo", 2 , 4, 22));

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new ExampleAdapter(struttura);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                HomeStruttura homeStruttura = new HomeStruttura();
                Bundle bundle = new Bundle();
                bundle.putParcelable("ExampleItem", struttura.get(position));


                bundle.putBoolean("accesso", log);
                bundle.putString("search", parola);
                if (log) {
                    bundle.putString("Nl", nrt);
                    bundle.putString("Nem", emailu);
                }


                homeStruttura.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.container, homeStruttura).commit();
            }

        });

         if(parola=="hotel"|| parola== "ristorante"|| parola=="attrazione"){
             struttura.clear();

             cercaf.setEnabled(false);
                            if(parola=="hotel"){
                                bottonH.setChecked(true);
                            }
                            if(parola=="ristorante"){
                             bottonR.setChecked(true);
                             }
                             if(parola=="attrazione"){
                                 bottonA.setChecked(true);
                                }


             String esiste= cercaController.Trovata(parola);
             String nome = cercaController.NomeStruttura(esiste);
             String indirizzo = cercaController.IndirizzoStruttura(esiste);
             String telefono= cercaController.TelefonoStruttura(esiste);
             String typ = cercaController.TipoStruttura(esiste);
             Integer apr= cercaController.AperturaStruttura(esiste);
             Integer chi= cercaController.ChiusuraStruttura(esiste);
             Integer stl= cercaController.StelleStruttura(esiste);
             struttura.add(new Struttura(nome, indirizzo, telefono, typ, apr, chi, stl));
         }
         else{

                   /* if (aperti.isChecked()){
                        Calendar rightNow = Calendar.getInstance();                  //prendo ora corrente e metodo nel controller che torna strutture orario e struttura
                        int currentHour = rightNow.get(Calendar.HOUR_OF_DAY);
                        oraap
                    }*/

                   bottonA.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {

                               bottonH.setChecked(false);
                               bottonR.setChecked(false);
                           filtroStruttura= "attrazione";
                       }
                   });
             bottonH.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     bottonA.setChecked(false);
                     bottonR.setChecked(false);
                     filtroStruttura= "hotel";
                 }
             });
             bottonR.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     bottonH.setChecked(false);
                     bottonA.setChecked(false);
                     filtroStruttura="ristorante";
                 }
             });          /*NON FUNZIONA
             cercaf.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                            int i= Integer.parseInt(stelle);
                         if(i != 5){

                             AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                             builder.setTitle("Il numero di stelle dev'essere compreso tra 1 e 5");
                             builder.setMessage("");
                             builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialog, int which) {
                                     dialog.cancel();
                                 }
                             }); builder.create().show();

                     } }
             }); */

             boolean find = cercaController.StrutturaEsiste(parola);
             if (find){

             struttura.clear();
             String esiste= cercaController.Trovata(parola);
            String nome = cercaController.NomeStruttura(esiste);
            String indirizzo = cercaController.IndirizzoStruttura(esiste);
            String telefono= cercaController.TelefonoStruttura(esiste);
             String typ = cercaController.TipoStruttura(esiste);
             Integer apr= cercaController.AperturaStruttura(esiste);
             Integer chi= cercaController.ChiusuraStruttura(esiste);
             Integer stl= cercaController.StelleStruttura(esiste);
             struttura.add(new Struttura(nome, indirizzo, telefono, typ, apr, chi, stl));

                  }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Siamo spiacenti");
            builder.setMessage("Non abbiamo trovato nessuna struttura con questo nome");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            }); builder.create().show(); } }


     back = (Button) view.findViewById(R.id.indietro);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homefragment home = new homefragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean("accesso", log);
                if (log) {
                    bundle.putString("Nl", nrt);
                    bundle.putString("Nem", emailu);
                }
                home.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.container, home).commit();
            }

        });

    return view; }

}
