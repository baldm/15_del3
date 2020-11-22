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


    public ChanceCard(String fileName, Language language){
        try {
            FileInputStream input = new FileInputStream("./Fields/"+ fileName);


            Properties prop = new Properties();
            prop.load(input);

            cardName = prop.getProperty("name");

            //cardName = language.getName(cardName);

            cardID = Integer.parseInt(prop.getProperty("cardID"));

            forceBuy = Boolean.parseBoolean(prop.getProperty("forceBuy"));

            drawCard = Boolean.parseBoolean(prop.getProperty("drawCard"));


        } catch (FileNotFoundException e){

        } catch (IOException e){

        }



    }
}
