package Spil;
// Nedenstående koder er en modificeret udgave, med udgangspunkt i:
// CDIO2, af os, gruppe 15.
public class Account {


    private int balance;

    public Account(int start_balance){

        this.balance = start_balance;

    }

    //Retunere spillerens balance
    public int getBalance(){ return this.balance; }

    //Tilføjer et beløb til balancen og checker om balancen er mindre end 0
    public void addToBalance(int amount){ balance += amount; checkBalance(balance); }


    private void checkBalance(int balance){

        //Hvis balancen er negativ bliver den sat til 0
        if(balance < 0){ this.balance = 0; }

    }

}
