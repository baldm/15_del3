package Gui;

//import Gui.remove.fieldContructor;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
// Nedenstående koder er en modificeret udgave, med udgangspunkt i:
// CDIO2, af os, gruppe 15.

public class Interface {


    // Definering af variable
    // TODO: Fix adgangen til disser vars
    private static GUI gui;
    private static GUI_Player player1;
    private static GUI_Player player2;

    /**
     * Laver laver et gui element
     * @param namePlayer1 Navnet af spiller 1
     * @param namePlayer2 Navnet af spiller 2
     */
    public static void createGui(String namePlayer1, String namePlayer2) { // Field[] fieldList

        // Opretter fields der skal bruges i spillet.

//        fieldContructor contruct = new fieldContructor();
//        fields = contruct.Construct(fieldList);



        // Opretter gui elementet
        //gui = new GUI(fields, Color.WHITE);
        GUI gui = new GUI();


        //Opretter spillere til spillet
        GUI_Car car = new GUI_Car();
        car.setPrimaryColor(Color.BLUE);
        player1 = new GUI_Player(namePlayer1,1000, car);
        GUI_Car car2 = new GUI_Car();
        car2.setPrimaryColor(Color.YELLOW);
        player2 = new GUI_Player(namePlayer2,1000, car2);

        // Implementere spillet
        gui.addPlayer(player1);
        gui.addPlayer(player2);

    }
    public static void movePlayer(String playerName, int playerPos){
        GUI_Field[] fields = gui.getFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].removeAllCars();
        }
        if (playerName.equals(player1.getName())) {
            fields[playerPos].setCar(player1, true);
        } else if (playerName.equals(player2.getName())) {
            fields[playerPos].setCar(player2, true);
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
