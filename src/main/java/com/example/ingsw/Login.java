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
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.regex.Pattern;


public class Login extends Fragment {
    private EditText mailog;
    private EditText passlog;
    private Button buttlog;
    private Button buttbklog;
    private LoginController Logcontr; //DICHIARO CONTROLLER

    public Login() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View l = inflater.inflate(R.layout.fragment_login, container, false);
         Logcontr= new LoginController(this);
        mailog = (EditText) l.findViewById(R.id.mailogin);
        passlog = (EditText) l.findViewById(R.id.passlogin);
        buttlog = (Button) l.findViewById(R.id.buttonlogin);
        buttlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emal = mailog.getText().toString();
                String psl = passlog.getText().toString();



                if(TextUtils.isEmpty(emal)||TextUtils.isEmpty(psl)  ) {
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
                    buttlog.setEnabled(false);
                    boolean returnlog = Logcontr.startLogin(mailog.getText().toString(), passlog.getText().toString()); //PASSO QUESTI DATI AL CONTROLLER

                    if (returnlog) {
                        //SE è VERO ED è TUTTO OK PASSO ALLA PAGINA NUOVA


                        profile prof = new profile();
                        Bundle bundle = new Bundle();


                        bundle.putString("Nem",emal);


                        prof.setArguments(bundle);
                        FragmentManager manager = getFragmentManager();
                        manager.beginTransaction().replace(R.id.container, prof).commit();
                    } else {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                        builder1.setTitle("Credenziali errate");
                        builder1.setMessage("vedi");
                        builder1.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }); builder1.create().show(); }
                }
            }




        });
        buttbklog= l.findViewById(R.id.buttonbklogin);
        buttbklog.setOnClickListener(new View.OnClickListener() {
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
        return l;
    }



}
