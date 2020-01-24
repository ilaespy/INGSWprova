package com.example.ingsw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class profile extends Fragment {
private Button Homprofilebutton;
    private TextView nomeut;
    private TextView mailut;
    private TextView nickut;
    private TextView dataut;
    private CheckBox shownickut;
    private LoginController Logcontr;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View a = inflater.inflate(R.layout.fragment_profile, container, false);
        Logcontr = new LoginController(this); //CONTROLLER
       Bundle b = getArguments();
       final String mailog = b.getString("Nem");

        String returnnn = Logcontr.returnUserName(mailog);
        String returnnk = Logcontr.returnUserNick(mailog);
        String returndt = Logcontr.returnUserData(mailog);
        final boolean returnsk = Logcontr.returnUserShowNick(mailog);

        nomeut = (TextView) a.findViewById(R.id.profilename);
        nomeut.setText(returnnn);

        mailut= (TextView) a.findViewById(R.id.profilemail);
        mailut.setText(mailog);

        nickut = (TextView) a.findViewById(R.id.profilenick);
        nickut.setText(returnnk);

        dataut = (TextView) a.findViewById(R.id.profiledata);
        dataut.setText(returndt);

        shownickut = (CheckBox) a.findViewById(R.id.checkboxprofile);
        shownickut.setChecked(returnsk);


        Homprofilebutton= a.findViewById(R.id.profilebutton);
        Homprofilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                homefragment homef = new homefragment();
                Bundle bundle = new Bundle();
                String nomeutentepassa = nomeut.getText().toString();
                String nickutentepassa = nickut.getText().toString();
                bundle.putBoolean("accesso", true);
                if (returnsk){
                    bundle.putString("N1", nickutentepassa);
                } else {
                    bundle.putString("N1", nomeutentepassa);
            }
                bundle.putString("mail", mailog );
                homef.setArguments(bundle);
                FragmentManager manager = getFragmentManager();

               manager.beginTransaction().replace(R.id.container, homef).commit();

            }

        });

        return a;
    }
    }


//controller nuovo che data la mail restituisce info che verrano mostrate
