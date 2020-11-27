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

    private String FÆNGSELSBESØG;
    private String CHANCE;
    private String FÆNGSEL;
    private String GRATISPARKERING;
    private String START;

    private String chance0;
    private String chance1;
    private String chance2;
    private String chance3;
    private String chance4;
    private String chance5;
    private String chance6;
    private String chance7;
    private String chance8;
    private String chance9;

    public String ANTALSPILLER;
    public String FORKERTNUMMER;
    public String NAVN;
    public String ANGIVSPILLER;
    public String DETER;
    public String TUR;
    public String RULTERNING;
    public String STARTHER;
    public String PRIS;
    public String CHANCEKORT;
    public String TRÆKCHANCEKORT;
    public String PARKERING;
    public String HERHARDUFRIPARKERING;
    public String FÆNGSELTEKST;




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

            FÆNGSELSBESØG = prop.getProperty("FÆNGSELSBESØG");
            CHANCE = prop.getProperty("CHANCE");
            FÆNGSEL = prop.getProperty("FÆNGSEL");
            GRATISPARKERING = prop.getProperty("GRATISPARKERING");
            START = prop.getProperty("START");

            chance0 = prop.getProperty("chance0");
            chance1 = prop.getProperty("chance1");
            chance2 = prop.getProperty("chance2");
            chance3 = prop.getProperty("chance3");
            chance4 = prop.getProperty("chance4");
            chance5 = prop.getProperty("chance5");
            chance6 = prop.getProperty("chance6");
            chance7 = prop.getProperty("chance7");
            chance8 = prop.getProperty("chance8");
            chance9 = prop.getProperty("chance9");

            ANTALSPILLER = prop.getProperty("ANTALSPILLER");
            FORKERTNUMMER = prop.getProperty("FORKERTNUMMER");
            NAVN = prop.getProperty("NAVN");
            ANGIVSPILLER = prop.getProperty("ANGIVSPILLER");
            DETER = prop.getProperty("DETER");
            TUR = prop.getProperty("TUR");
            RULTERNING = prop.getProperty("RULTERNING");
            TRÆKCHANCEKORT = prop.getProperty("TRÆKCHANCEKORT");
            RULTERNING = prop.getProperty("STARTHER");
            PRIS = prop.getProperty("PRIS");
            CHANCEKORT = prop.getProperty("CHANCEKORT");
            TRÆKCHANCEKORT = prop.getProperty("PARKERING");
            HERHARDUFRIPARKERING = prop.getProperty("HERHARDUFRIPARKERING");
            STARTHER = prop.getProperty("STARTHER");
            PARKERING = prop.getProperty("PARKERING");
            FÆNGSELTEKST = prop.getProperty("FÆNGSEL");

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

            case "FÆNGSELSBESØG":
                return FÆNGSELSBESØG;

            case "CHANCE":
                return CHANCE;

            case "FÆNGSEL":
                return FÆNGSEL;

            case "GRATISPARKERING":
                return GRATISPARKERING;

            case "START":
                return START;

            default:
                return "Error! Name not found!";
        }

    }
    public String getChanceText(int chanceNumber) {
        switch (chanceNumber) {
            case 0:
                return chance0;
            case 1:
                return chance1;
            case 2:
                return chance2;
            case 3:
                return chance3;
            case 4:
                return chance4;
            case 5:
                return chance5;
            case 6:
                return chance6;
            case 7:
                return chance7;
            case 8:
                return chance8;
            case 9:
                return chance9;
            default:
                return chance0;
        }
    }
    public String getLanguage() {
        return language;
    }
}
