package Gui;

import Spil.Dice;
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
    private static GUI_Player guiPlayerOne;
    private static GUI_Player guiPlayerTwo;

    /**
     * Laver laver et gui element
     * @param playerOne playerobject 1
     * @param playerTwo playerobject 2
     */
    public static void createGui(Player playerOne, Player playerTwo) {

        // Opretter gui elementet
        gui = new GUI();
        
        //Opretter spillere til spillet
        GUI_Car car = new GUI_Car();
        car.setPrimaryColor(Color.BLUE);
        guiPlayerOne = new GUI_Player(playerOne.getName(),1000, car);
        GUI_Car car2 = new GUI_Car();
        car2.setPrimaryColor(Color.YELLOW);
        guiPlayerTwo = new GUI_Player(playerTwo.getName(),1000, car2);

        // Implementere spillet
        gui.addPlayer(guiPlayerOne);
        gui.addPlayer(guiPlayerTwo);

    }
    // Intern funktion til at finde gui objectes spiller
    public static GUI_Player findGuiPlayer(Player player){
        String playerName = player.getName();

        if (playerName.equals(guiPlayerOne.getName())) {
            return guiPlayerOne;
        } else if (playerName.equals(guiPlayerTwo.getName())) {
            return guiPlayerTwo;
        } else {
            throw new IllegalArgumentException("Player does not exist");
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
        gui.showMessage("\n\n\n\n\n"+message);
    }

    /**
     * Setter dice på boarded
     * @param diceOne dice object 1
     * @param diceTwo dice object 2
     */
    public static void setBoardDice(Dice diceOne, Dice diceTwo) {
        gui.setDice(diceOne.getValue(), diceTwo.getValue());
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
        String selection = gui.getUserSelection(msg, args);
        return selection;
    }
    public static void setOwned(Player player) {
        GUI_Field field = gui.getFields()[player.getPosition()];
        GUI_Ownable ownable = (GUI_Ownable) field;
        ownable.setOwnerName(player.getName());

        // Kode der måske skal bruges i voksen version
        //String rentChoice = displayMultiButtonMsg("Hvad skal lejen være?", "100", "200", "300", "400", "500");
        //ownable.setRent(rentChoice);

        // Finder tallene i feltes pris, og derefter sætter rent som det samme
        String subtext = field.getSubText();
        String rent = subtext.replaceAll("[^0-9]", "");
        ownable.setRent(rent);

        ownable.setBorder(findGuiPlayer(player).getPrimaryColor());

    }

}
