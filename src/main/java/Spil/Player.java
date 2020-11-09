package Spil;

// Nedenstående koder er en modificeret udgave, med udgangspunkt i:
// CDIO1, af os, gruppe 15.

public class Player {
    private String name;
    private final Account account = new Account(0);
    private int position = 0;

    public Player(String n, int money){
        this.name = n;
        account.addToBalance(money);
    }
    // Definerer spillerens navn
    public void setName(String p_name){
        this.name = p_name;
    }

    // Tilføjer penge til nuværende formue
    public void addMoney(int p_money){
        account.addToBalance(p_money);
    }

    // Retunerer navn
    public String getName(){
        return this.name;
    }

    // Retunerer antal penge spilleren har
    public int getMoney(){
        return account.getBalance();
    }
    // Retunerer positionen af playeren
    public int getPosition(){
        return position;
    }
    // Setter positionen af playeren
    public void setPosition(int newPos){
        position = newPos;
    }
}