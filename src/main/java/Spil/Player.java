package Spil;

// Nedenstående koder er en modificeret udgave, med udgangspunkt i:
// CDIO1, af os, gruppe 15.

public class Player {
    private String name;
    private final Account account = new Account(0);
    private int position = 0;
    public int oldPosition = 0;

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

    // Retunerer positionen af playeren
    public int getPosition(){
        return position;
    }

    // Setter positionen af playeren
    public void setPosition(int newPos){
        oldPosition = getPosition();
        if (newPos >= 40) {position = newPos - 40;}
        else { position = newPos; }
    }

    public boolean ownsboth(int groupID) {
        return ownsboth[groupID];
    }

    public void setOwnedFields(int fieldID) {
        this.ownedFields[fieldID] = true;
        for(int i=0, k=0; i<ownedFields.length;i+=2, k++){
            if(ownedFields[i] && ownedFields[i+1]){
                ownsboth[k] = true;
            }
        }
    }
}