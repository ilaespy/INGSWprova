package com.example.ingsw;

import android.os.Parcel;
import android.os.Parcelable;

public class Struttura implements Parcelable{
    public String nome;
    public String indirizzo;
    public String tel;
    public String tipo;
    public Integer apertura;
    public Integer chiusura;
    public Integer nStelle;



    protected Struttura(Parcel in) {
        nome = in.readString();
        indirizzo = in.readString();
        tel = in.readString();
        tipo= in.readString();
        apertura=in.readInt();
        chiusura=in.readInt();
        nStelle=in.readInt();
    }

    public static final Creator<Struttura> CREATOR = new Creator<Struttura>() {
        @Override
        public Struttura createFromParcel(Parcel in) {
            return new Struttura(in);
        }

        @Override
        public Struttura[] newArray(int size) {
            return new Struttura[size];
        }
    };

    public String getTel() {
        return tel;
    }
    public String getTipo() {
        return tipo;
    }

    public Integer getApertura() {
        return apertura;
    }

    public Integer getChiusura() {
        return chiusura;
    }

    public Integer getnStelle() {
        return nStelle;
    }


    //private int foto;



    public Struttura(String nome, String indirizzo, String tel, String tipo, Integer nStelle, Integer apertura, Integer chiusura) {
      //  this.foto=foto;
        this.indirizzo=indirizzo;
        this.nome= nome;
        this.tel= tel;
        this.tipo= tipo;
        this.nStelle=nStelle;
        this.apertura= apertura;
        this.chiusura= chiusura;
    }

    public String getIndirizzo() {
        return indirizzo;
    }


   public String getNome() {
        return nome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(indirizzo);
        dest.writeString(tel);
        dest.writeString(tipo);
        dest.writeInt(apertura);
        dest.writeInt(chiusura);
        dest.writeInt(nStelle);
    }
    //public int getFoto() {
        //return foto;
   // }
}