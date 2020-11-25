package Spil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Language {
    private String language;
    private String BURGERBAR;
    private String PIZZARIA;
    private String SLIKBUTIKKEN;

    private String ISKIOSKEN;
    private String MUSEET;
    private String BILIOTEKET;
    private String SKATERPARKEN;

    private String SWIMMINGPOOLEN;
    private String SPILLEHALLEN;
    private String BIOGRAFEN;
    private String LEGETØJSBUTIKKEN;

    private String DYREHANDLEN;
    private String BOWLINGHALLEN;
    private String ZOO;
    private String VANDLANDET;
    private String STRANDPROMENADEN;


    public Language (String fileName) {
        try {
            FileInputStream input = new FileInputStream("./Languages/" + fileName);


            Properties prop = new Properties();
            prop.load(input);
            language = prop.getProperty("language");
            BURGERBAR = prop.getProperty("BURGERBAR");
            PIZZARIA = prop.getProperty("PIZZARIA");
            SLIKBUTIKKEN = prop.getProperty("SLIKBUTIKKEN");

            ISKIOSKEN = prop.getProperty("ISKIOSKEN");
            MUSEET = prop.getProperty("MUSEET");
            BILIOTEKET = prop.getProperty("BILIOTEKET");
            SLIKBUTIKKEN = prop.getProperty("SLIKBUTIKKEN");

            SKATERPARKEN = prop.getProperty("SKATERPARKEN");
            SWIMMINGPOOLEN = prop.getProperty("SWIMMINGPOOLEN");
            SPILLEHALLEN = prop.getProperty("SPILLEHALLEN");
            BIOGRAFEN = prop.getProperty("BIOGRAFEN");

            LEGETØJSBUTIKKEN = prop.getProperty("LEGETØJSBUTIKKEN");
            DYREHANDLEN = prop.getProperty("DYREHANDLEN");
            BOWLINGHALLEN = prop.getProperty("BOWLINGHALLEN");
            ZOO = prop.getProperty("ZOO");

            VANDLANDET = prop.getProperty("VANDLANDET");
            STRANDPROMENADEN = prop.getProperty("STRANDPROMENADEN");




        } catch (FileNotFoundException e){

        } catch (IOException e){

        }

    }

    public String getName(String name){
        switch (name) {
            case "BURGERBAR":
                return BURGERBAR;

            case "PIZZARIA":
                return PIZZARIA;

            case "SLIKBUTIKKEN":
                return SLIKBUTIKKEN;

            case "ISKIOSKEN":
                return ISKIOSKEN;

            case "MUSEET":
                return MUSEET;

            case "BILIOTEKET":
                return BILIOTEKET;

            case "SKATERPARKEN":
                return SKATERPARKEN;

            case "SWIMMINGPOOLEN":
                return SWIMMINGPOOLEN;

            case "SPILLEHALLEN":
                return SPILLEHALLEN;

            case "BIOGRAFEN":
                return BIOGRAFEN;

            case "LEGETØJSBUTIKKEN":
                return LEGETØJSBUTIKKEN;

            case "DYREHANDLEN":
                return DYREHANDLEN;

            case "BOWLINGHALLEN":
                return BOWLINGHALLEN;

            case "ZOO":
                return ZOO;

            case "VANDLANDET":
                return VANDLANDET;

            case "STRANDPROMENADEN":
                return STRANDPROMENADEN;

            default:
                return "Error! Name not found!";
        }

    }

    public String getLanguage() {
        return language;
    }
}
