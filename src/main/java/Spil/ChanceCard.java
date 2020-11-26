package Spil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ChanceCard {
    private String cardName;
    private int cardID;
    private boolean forceBuy;
    private boolean drawCard;
    private int moveAmount;
    private int MoneyAmount;
    private int moveToFieldID;
    private int moveToGroupID;


    public ChanceCard(String fileName, Language language){
        try {
            FileInputStream input = new FileInputStream("./ChanceCards/"+ fileName);

            Properties prop = new Properties();
            prop.load(input);

            cardName = prop.getProperty("name");
            cardID = Integer.parseInt(prop.getProperty("cardID"));
            forceBuy = Boolean.parseBoolean(prop.getProperty("forceBuy"));
            drawCard = Boolean.parseBoolean(prop.getProperty("drawCard"));
            moveAmount = Integer.parseInt(prop.getProperty("moveAmount"));
            MoneyAmount = Integer.parseInt(prop.getProperty("MoneyAmount"));
            moveToFieldID = Integer.parseInt(prop.getProperty("moveToFieldID"));
            moveToGroupID = Integer.parseInt(prop.getProperty("moveToGroupID"));


        } catch (FileNotFoundException e){

        } catch (IOException e){

        }



    }

    public String getCardName() {
        return cardName;
    }

    public int getCardID() {
        return cardID;
    }
    public int getMoveAmount() {
        return moveAmount;
    }
    public int getMoneyAmount() {
        return MoneyAmount;
    }
    public int getMoveToFieldID() {
        return moveToFieldID;
    }
    public int getMoveToGroupID() {
        return moveToGroupID;
    }
}
