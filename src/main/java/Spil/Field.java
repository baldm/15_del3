package Spil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Field {
    private String fieldName;
    private boolean isOwned = false;
    private Player owner;
    private int money;
    private int fieldID;
    private int price;


    public Field(String fileName, String language){
        try {
            FileInputStream input = new FileInputStream("./Fields/"+ fileName);


            Properties prop = new Properties();
            prop.load(input);
            switch (language){
                case "Danish":
                    fieldName = prop.getProperty("dkName");
                    break;
                case  "English":
                    fieldName = prop.getProperty("engName");
                    break;
                default: fieldName = "Error!";
            }
            fieldID = Integer.parseInt(prop.getProperty("fieldID"));

            price = Integer.parseInt(prop.getProperty("price"));



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
    }

    public void removeOwner(){
        owner.addMoney(price/2);
        owner = null;
        isOwned = false;
    }

    public void isOwned(Player player) {
        if(isOwned){
            player.addMoney(- money);
            owner.addMoney(money);
        }
    }
}
