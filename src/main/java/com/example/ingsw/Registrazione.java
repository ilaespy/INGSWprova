package com.example.ingsw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.regex.Pattern;


public class Registrazione extends Fragment {
    private EditText nomereg;
    private EditText mailreg;
    private EditText passreg;
    private EditText cittàreg;
    private EditText nickreg;
    private Button buttreg;
    private EditText datareg;
    private Button shownickreg;
    private Button buttbkreg;
    private RegistrazioneController Regcontr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View i = inflater.inflate(R.layout.fragment_registrazione, container, false);
        Regcontr = new RegistrazioneController(this);
        nomereg = (EditText) i.findViewById(R.id.nomeregistrazione);
        mailreg = (EditText) i.findViewById(R.id.mailregistrazione);
        passreg = (EditText) i.findViewById(R.id.passregistrazione);
        cittàreg = (EditText) i.findViewById(R.id.cittàregistrazione);
        nickreg = (EditText) i.findViewById(R.id.nickregistrazione);
        datareg = (EditText) i.findViewById(R.id.dataregistrazione);
        shownickreg = (CheckBox) i.findViewById(R.id.shownickregistrazione);
        buttreg = (Button) i.findViewById(R.id.buttonregistrazione);
        buttreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ema = mailreg.getText().toString();
                String ps = passreg.getText().toString();
                String nou = nomereg.getText().toString();
                String ct = cittàreg.getText().toString();
                String nk = nickreg.getText().toString();
                String dt = datareg.getText().toString();
                boolean sh = shownickreg.isSelected();

                 boolean mailusata = Regcontr.mailinuso(ema);


                if(TextUtils.isEmpty(ema)||TextUtils.isEmpty(ps)||TextUtils.isEmpty(nou)||TextUtils.isEmpty(ct)||TextUtils.isEmpty(nk)||TextUtils.isEmpty(dt)||!mailusata )
                    {
                         if (TextUtils.isEmpty(ema)||TextUtils.isEmpty(ps)||TextUtils.isEmpty(nou)||TextUtils.isEmpty(ct)||TextUtils.isEmpty(nk)||TextUtils.isEmpty(dt))
                         {
                             AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Riempi tutti i campi");
                        builder.setMessage("vedi");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }); builder.create().show();
                     }
                         else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Mail già in uso");
                        builder.setMessage("vedi");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }); builder.create().show();
                    }
                    }


                else {
                buttreg.setEnabled(false);
                shownickreg.setEnabled(false);
               boolean returnregister = Regcontr.startRegister(nomereg.getText().toString(), mailreg.getText().toString(), passreg.getText().toString(), cittàreg.getText().toString(), nickreg.getText().toString(), datareg.getText().toString(), sh);
                    if(returnregister){
                        Toast.makeText(getActivity(), "Registrazione completa!", Toast.LENGTH_LONG).show();
                        MainActivity.fragmMang.beginTransaction().replace(R.id.container, new Login(), null).commit();
                    } } }



        });
        buttbkreg= i.findViewById(R.id.buttonbackreg);
        buttbkreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                Bundle bundle = new Bundle();
                bundle.putBoolean("accesso", false);
                user.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.container, user).commit();
            }
        });
        return i;
    }
}