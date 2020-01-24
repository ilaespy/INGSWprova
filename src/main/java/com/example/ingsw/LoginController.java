package com.example.ingsw;

public class LoginController {
    private profile prof;
    private Login modell;
    private LoginDao loginDao;



    public LoginController(Login model) { //LE DO UN NUOVO NOME
        this.modell = modell;
        loginDao = new LoginDao (this);}
        public LoginController(profile prof){
        this.prof =prof;
        }




    public boolean startLogin (String mailut, String passutente ){
        return true;
    } //RINOMINO E DICHIARO I DATI CHE MI PASSA LOGIN

    public String returnUserName (String mailus) {

        return "shadow";
    }

    public String returnUserNick (String mailus) {
        return "Cthulhu" ;
    }
    public String returnUserData (String mailus) {
        return "06/06/06" ;
    }
    public boolean returnUserShowNick(String mailus) {
        return false ;
    }


} //passo la mail del tipo a tutti i futuri fragment e quando fa la recensione il controller recensioni verificherà se online o no, cosa che verrà
//settata in questo punto nel db

