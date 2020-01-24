package com.example.ingsw;

import android.content.Intent;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;

public class RegistrazioneController {
    private Registrazione model;
    private RegistrazioneDao registrazioneDao;
    public RegistrazioneController(Registrazione model) {
    this.model = model;

    }
    public boolean startRegister(String nomeutente, String mailutentte, String passutente, String cittàutente, String nickutente, String datautente, boolean checkutente ){
        return true;
    }
public boolean mailinuso (String mailutente){
    return true; }

}
