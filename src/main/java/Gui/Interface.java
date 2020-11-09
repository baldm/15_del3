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
     * @param Player playerobject 1
     * @param Player playerobject 2
     */
    public static void createGui(Player playerOne, Player playerTwo) {

        // Opretter gui elementet
        GUI gui = new GUI();


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
    public static void movePlayer(Player player, int playerPos){
        GUI_Field[] fields = gui.getFields();

        String playerName = player.getName();

        // Legacy fra cdio 2 TODO: Opdater
//        for (int i = 0; i < fields.length; i++) {
//            fields[i].removeAllCars();
//        }



        if (playerName.equals(guiPlayerOne.getName())) {
            fields[playerPos].setCar(guiPlayerOne, true);
        } else if (playerName.equals(guiPlayerTwo.getName())) {
            fields[playerPos].setCar(guiPlayerTwo, true);
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
     * @param playerName String
     * @param pointDelta int
     */
    public static void addPlayerBalance(String playerName, int pointDelta) {
        if (playerName.equals(player1.getName())) {
            player1.setBalance(player1.getBalance()+pointDelta);
        } else if (playerName.equals(player2.getName())) {
            player2.setBalance(player2.getBalance()+pointDelta);
        } else {
            throw new IllegalArgumentException("Player does not exist");
        }
    }

}
