package Gui;

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
    public static void movePlayer(Player player){
        GUI_Field[] fields = gui.getFields();
        String playerName = player.getName();

        fields[player.oldPosition].removeAllCars();

        // TODO: gør bedre
        if (playerName.equals(guiPlayerOne.getName())) {
            fields[player.getPosition()].setCar(guiPlayerOne, true);
        } else if (playerName.equals(guiPlayerTwo.getName())) {
            fields[player.getPosition()].setCar(guiPlayerTwo, true);
        } else {
            throw new IllegalArgumentException("Player does not exist");
        }
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
     * @param roll1 int
     * @param roll2 int
     */
    public static void setBoardDice(int roll1, int roll2) {
        gui.setDice(roll1, roll2);
    }

    /**
     * tilføjer en delta balance til player
     * @param player playerObject
     * @param pointDelta int
     */
    // TODO: gør bedre
    public static void addPlayerBalance(Player player, int pointDelta) {
        String playerName = player.getName();
        if (playerName.equals(guiPlayerOne.getName())) {
            guiPlayerOne.setBalance(guiPlayerOne.getBalance()+pointDelta);
        } else if (playerName.equals(guiPlayerTwo.getName())) {
            guiPlayerTwo.setBalance(guiPlayerTwo.getBalance()+pointDelta);
        } else {
            throw new IllegalArgumentException("Player does not exist");
        }
    }
    public static void displayMultiButtonMsg(String... args) {

    }

}
