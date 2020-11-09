package Gui;

import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;

import java.awt.*;

public class fieldConstructor {
    public GUI_Field[] Construct(Field[] fieldList) {


        // Definere felt information

        //String[] fieldNameArray = new String[]{"","Tower", "Crater", "Palace gates", "Cold Desert", "Walled city", "Monastery", "Black Cave", "Huts in the mountain", "The Werewall", "The pit","Goldmine"};
        //String[] fieldNameArrayDanish = new String[]{"","Tower", "Krater", "Palace gates", "Kold Ørken", "Walled city", "Monastery", "Mørk Hule", "Hytter på Bjerget", "The Werewall", "The pit","Guldmine"};
        //String[] fieldPointArray = new String[]{"","250", "-100", "100", "-20", "180", "0", "-70", "60", "-80", "-50", "650","250","250"};

        // Opretter array af felter fra antal
        GUI_Field[] fields = new GUI_Field[12];

        // Opretter start felt
        GUI_Start startField = new GUI_Start("Start", "", "", Color.WHITE, Color.BLACK);
        fields[0] = startField;

        // Looper gennem felterne og opretter dem.
        // Muligvis lav dette om til at læse en .prop eller json fil.
        for (int i = 0; i < fieldList.length; i++) {
            GUI_Street Field = new GUI_Street();
            Field.setForeGroundColor(Color.BLACK);
            Field.setBackGroundColor(Color.WHITE);
            Field.setTitle(fieldList[i].getFieldName());
            int points = fieldList[i].getFieldPoints();
            String stringPoints = String.valueOf(points);
            Field.setSubText(stringPoints);
            // Tilføjere ændrigere til fields.
            fields[i+1] = Field;

        }
        return fields;
    }
}
