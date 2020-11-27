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
    private int pos;
    private String fieldType;
    private boolean isPrison;
    private boolean isPrisonVisit;
    private boolean isChance;
    private boolean isParking;
    private boolean isStart;




    public Field(String fileName, Language language){
        try {
            FileInputStream input = new FileInputStream("./Fields/"+ fileName);


            Properties prop = new Properties();
            prop.load(input);

            fieldName = prop.getProperty("name");

            fieldName = language.getName(fieldName);

            groupID = Integer.parseInt(prop.getProperty("groupID"));

            fieldID = Integer.parseInt(prop.getProperty("fieldID"));

            price = Integer.parseInt(prop.getProperty("price"));

            rent = Integer.parseInt(prop.getProperty("rent"));

            isPrison = Boolean.parseBoolean(prop.getProperty("isPrison"));

            isPrisonVisit = Boolean.parseBoolean(prop.getProperty("isPrisonVisit"));

            isChance = Boolean.parseBoolean(prop.getProperty("isChance"));

            isParking = Boolean.parseBoolean(prop.getProperty("isParking"));

            isStart = Boolean.parseBoolean(prop.getProperty("isStart"));

            pos = Integer.parseInt(prop.getProperty("pos"));

            /* Field Type Strings's
            Start,
            Street,
            Chance,
            Jail,
            Parking
             */
            fieldType = prop.getProperty("fieldType");

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
        owner.addMoney(price/2);
        owner = null;
        isOwned = false;
    }

    public void isOwned(Player player) {
        if(fieldID < 16) {
            if(isOwned) {
                if (!player.equals(owner)) {
                    if (owner.ownsboth(groupID)) {
                        player.addMoney(-2 * rent);
                        owner.addMoney(2 * rent);
                        System.out.println("betalt 2 gang leje");
                    } else {
                        player.addMoney(-rent);
                        owner.addMoney(rent);
                        System.out.println("betalt 1 gang leje");
                    }
                }
            }else if (player.getMoney() >= price) {
                setOwner(player);
            }


        }
    }

    public int getPrice() {
        return price;
    }

    public int getFieldID() {
        return fieldID;
    }

    public boolean isChance() {
        return isChance;
    }

    public boolean isParking() {
        return isParking;
    }

    public boolean isPrisonVisit() {
        return isPrisonVisit;
    }

    public boolean isPrison() {
        return isPrison;
    }

    public boolean isStart() {
        return isStart;
    }

    public int getPos() {
        return pos;
    }

    public String getFieldType() { return fieldType; }

    public int getGroupID() { return groupID; }
}
