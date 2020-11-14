package Spil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Field {
    private String fieldName;
    private boolean isOwned = false;
    private Player owner;
    private int rent;
    private int groupID;
    private int price;
    private int fieldID;



    public Field(String fileName, Language language){
        try {
            FileInputStream input = new FileInputStream("./Fields/"+ fileName);


            Properties prop = new Properties();
            prop.load(input);

            fieldName = prop.getProperty("name");

            fieldName = language.getName(fileName);

            groupID = Integer.parseInt(prop.getProperty("groupID"));

            fieldID = Integer.parseInt(prop.getProperty("fieldID"));

            price = Integer.parseInt(prop.getProperty("price"));

            rent = Integer.parseInt(prop.getProperty("rent"));



        } catch (FileNotFoundException e){

        } catch (IOException e){

        }



    }

    public String getFieldName() {
        return fieldName;
    }

    public void setOwner(Player player) {
        isOwned = true;
        owner = player;
        owner.addMoney(-price);
        owner.setOwnedFields(fieldID);
    }

    public void removeOwner(){
        owner = null;
        isOwned = false;
    }

    public void isOwned(Player player) {
        if(isOwned){
            if(owner.ownsboth(groupID)){
                player.addMoney(- 2*rent);
                owner.addMoney(2*rent);
                System.out.println("betalt 2 gang leje");
            } else {
                player.addMoney(- rent);
                owner.addMoney(rent);
                System.out.println("betalt 1 gang leje");
            }

        }
    }

    public int getPrice() {
        return price;
    }

    public int getFieldID() {
        return fieldID;
    }
}
