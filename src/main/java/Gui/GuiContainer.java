package Gui;

import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_main.GUI;

import java.awt.*;

public class GuiContainer {
    public static void main(String[] args) {
        GUI gui = new GUI();

        // Cast felt til GUI_Ownable
        GUI_Field field = gui.getFields()[1];
        GUI_Ownable ownable = (GUI_Ownable) field;

        ownable.setSubText("Pris: 1000");
        ownable.setOwnerName("Albert");
        ownable.setRent("1000");
        ownable.setBorder(Color.GREEN);

        System.out.println(ownable.getRent());

        GUI_Field field3 = gui.getFields()[3];

        System.out.println(field3.getSubText());

    }
}