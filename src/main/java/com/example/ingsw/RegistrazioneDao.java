package com.example.ingsw;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrazioneDao {
    private RegistrazioneController registrazioneController;



    public RegistrazioneDao(LoginController logincontroller) { //LE DO UN NUOVO NOME
        this.registrazioneController = registrazioneController ; }
    public boolean startRegister(final String nomeutente, String mailutentte, String passutente, final String cittàutente, final String nickutente, final String datautente, final boolean checkutente ){
        final FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();
        final DatabaseReference databaseReference;
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Utente");
        firebaseAuth.createUserWithEmailAndPassword(mailutentte, passutente).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                   boolean b = true;
                   String user_id = firebaseAuth.getCurrentUser().getUid();
                   DatabaseReference current_user_db = databaseReference.child(user_id);
                   current_user_db.child("Nome").setValue(nomeutente);
                    current_user_db.child("Città").setValue(cittàutente);
                    current_user_db.child("dataNascita").setValue(datautente);
                    current_user_db.child("NickName").setValue(nickutente);
                    current_user_db.child("visualizza_nick").setValue(checkutente);
                } else {
                   boolean b = false;}
                }
        });
       return true;
    }

}
