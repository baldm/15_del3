package Gui;

import Spil.Dice;
import Spil.Field;
import Spil.Player;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

// Nedenstående koder er en modificeret udgave, med udgangspunkt i:
// CDIO2, af os, gruppe 15.

public class Interface {


    // Definering af variable
    // TODO: Fix adgangen til disser vars
    private static GUI gui;
    private static GUI_Player[] guiPlayerList;


    /**
     * Laver laver et gui element
     * @param playerList Liste over spillere
     */

    public static void createGui(Player[] playerList, Field[] inputFields) {

        // Opretter gui elementet
        gui = new GUI(guiFieldFactory(inputFields), Color.WHITE);

        //Opretter spillere til spillet
        guiPlayerList = new GUI_Player[playerList.length];

        for (int i = 0; i < playerList.length; i++) {
            Player curPlayer = playerList[i];
            GUI_Car car = new GUI_Car();

            guiPlayerList[i] = new GUI_Player(curPlayer.getName(),2, car);

            switch (i) {
                case 0:
                    car.setPrimaryColor(Color.BLUE);
                    break;
                case 1:
                    car.setPrimaryColor(Color.RED);
                    break;
                case 2:
                    car.setPrimaryColor(Color.YELLOW);
                    break;
            }
        }

        // Implementere spillet
        for (GUI_Player guiPlayer : guiPlayerList) {
            gui.addPlayer(guiPlayer);
        }



    }
    public static GUI_Field[] guiFieldFactory(Field[] inputFields) {

        GUI_Field[] fields = new GUI_Field[inputFields.length];


        for (int i = 0; i < inputFields.length; i++) {
            Field curField = inputFields[i];
            Color curColor;
            String curRent = String.valueOf(curField.getPrice());

            switch (curField.getGroupID()) {
                case 0:
                    curColor = Color.pink;
                    break;
                case 1:
                    curColor = Color.CYAN;
                    break;
                case 2:
                    curColor = Color.MAGENTA;
                    break;
                case 3:
                    curColor = Color.ORANGE;
                    break;
                case 4:
                    curColor = Color.RED;
                    break;
                case 5:
                    curColor = Color.YELLOW;
                    break;
                case 6:
                    curColor = Color.GREEN;
                    break;
                case 7:
                    curColor = Color.BLUE;
                    break;
                default:
                    curColor = Color.WHITE;

            }
            switch(curField.getFieldType()) {
                case "Start":
                    fields[i] = new GUI_Start(curField.getFieldName(), "", "Her starter du", curColor, Color.BLACK);
                    break;
                case "Street":
                    fields[i] = new GUI_Street(curField.getFieldName(), "Pris:"+curRent, "   ", curRent, curColor, Color.BLACK);
                    break;
                case "Chance":
                    fields[i] = new GUI_Chance("?", "Chancekort", "Her trækker du et chancekort", curColor, Color.BLACK);
                    break;
                case "Jail":
                    fields[i] = new GUI_Jail();
                    fields[i].setSubText("Fængsel");
                    break;
                case "Parking":
                    fields[i] = new GUI_Refuge("./Images/parking.PNG", curField.getFieldName(), "Parkering", "Her kan du parkere gratis", curColor, Color.BLACK);
                    break;
                default:
                    // Ikke muligt
            }

        }
        return fields;
    }

    // Intern funktion til at finde gui objectes spiller
    public static GUI_Player findGuiPlayer(Player player){
        String playerName = player.getName();
        for (GUI_Player guiPlayer : guiPlayerList) {
            if (playerName.equals(guiPlayer.getName())) {return guiPlayer;}
        }
        return guiPlayerList[9001]; // Error handling
    }
    public static void refreshGui(Player[] players) {
        GUI_Field[] fields = gui.getFields();
        for (GUI_Field field : fields) {
            field.removeAllCars();
        }
        for (Player player : players) {
            movePlayer(player);
            setPlayerBalance(player);
            setOwned(player);
        }
    }
    // flyt eller fjern spiller object
    public static void movePlayer(Player player){
        gui.getFields()[player.getPosition()].setCar(findGuiPlayer(player), true);
    }
    public static void removePlayer(Player player) {
        gui.getFields()[player.getPosition()].setCar(findGuiPlayer(player), false);
    }

    /**
     * Viser msg i gui
     * @param message String
     */
    public static void displayMessage(String message) {
        gui.showMessage("\n\n\n"+message);
    }

    /**
     * Setter dice på boarded
     * @param roll dice object 1
     */
    public static void setBoardDice(int roll) {
        gui.setDie(roll);
    }

    /**
     * tilføjer en delta balance til player
     * @param player playerObject
     */
    // TODO: gør bedre
    public static void setPlayerBalance(Player player) {
        findGuiPlayer(player).setBalance(player.getMoney());
    }

    /**
     * displayer en besked på guien med et variable mængde valg
     * @param msg String
     * @param args Variable mængde strings
     */
    public static String displayMultiButtonMsg(String msg, String... args) {
        return gui.getUserSelection(msg, args);
    }
    public static void displayChance(String stringInput) {
        gui.setChanceCard(stringInput);
        gui.displayChanceCard(stringInput);
    }

    public static void setOwned(Player player) {
        int[] ownedFields = player.getOwnedFieldsGui();
        for (int fieldNumber : ownedFields) {
            if (fieldNumber == 0) {continue;}

            GUI_Field field = gui.getFields()[fieldNumber];
            GUI_Ownable ownable = (GUI_Ownable) field;

            ownable.setOwnerName(player.getName());

            // Finder tallene i feltes pris, og derefter sætter rent som det samme
            String subtext = field.getSubText();
            String rent = subtext.replaceAll("[^0-9]", "");
            ownable.setRent(rent);

            ownable.setBorder(findGuiPlayer(player).getPrimaryColor());
        }


        // Kode der måske skal bruges i voksen version
        //String rentChoice = displayMultiButtonMsg("Hvad skal lejen være?", "100", "200", "300", "400", "500");
        //ownable.setRent(rentChoice);



    }

}
