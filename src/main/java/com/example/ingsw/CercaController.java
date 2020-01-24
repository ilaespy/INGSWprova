package com.example.ingsw;

import java.util.ArrayList;

public class CercaController {
    private Risultati results;


    public CercaController(Risultati results) {
        this.results = results;

    }
    public boolean StrutturaEsiste (String parola){
        return false;
    }
    public String Trovata (String parola){
        return "1010";
    }
    public String NomeStruttura (String idStruttura){
        return "lally";
    }
    public String IndirizzoStruttura(String idStruttura){
        return "          via Biscotto";
    }
    public String TelefonoStruttura (String idStruttura){
        return "23453";
    }
    public String TipoStruttura (String idStruttura)
    {return "hotel";}
    public Integer StelleStruttura (String idStruttura)
    {
        return  4;
    }
    public Integer AperturaStruttura (String idStruttura){
        return 12;
    }
    public Integer ChiusuraStruttura (String idStruttura){
        return 24;
    }

}
