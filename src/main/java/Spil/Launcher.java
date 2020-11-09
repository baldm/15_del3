package Spil;

import java.io.File;
import java.util.Arrays;

public class Launcher {
    public static void main(String[] args) {
        String lang = "English";
        fileScanner fieldScanner = new fileScanner("Fields");
        String[] fieldFileNames = fieldScanner.getFieldNames();
        Field[] allFields = new Field[fieldFileNames.length];


        for(int i = 0; i< fieldFileNames.length;i++){
            allFields[i] = new Field(fieldFileNames[i], lang);
        }

        System.out.println(allFields[0].getFieldName());
        System.out.println(allFields[1].getFieldName());
    }
}
