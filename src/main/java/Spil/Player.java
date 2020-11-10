package Spil;

// Nedenstående koder er en modificeret udgave, med udgangspunkt i:
// CDIO1, af os, gruppe 15.

public class Player {
    private String name;

    private Account account = new Account(0);

    private boolean[] ownsboth = new boolean[8];

    private boolean[] ownedFields = new boolean[16];

    public Player(String n, int money){
        this.name = n;
        this.account.addToBalance(money);
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

    public boolean ownsboth(int groupID) {
        return ownsboth[groupID];
    }

    public void setOwnedFields(int fieldID) {
        this.ownedFields[fieldID] = true;
    }
}