package Launcher;


import Spil.Field;
import Spil.Language;
import Spil.Player;
import Spil.fileScanner;

public class Launcher {
    public static void main(String[] args) {
//        String lang = "English";
//        fileScanner fieldScanner = new fileScanner("Fields");
//
//        String[] fieldFileNames = fieldScanner.getFieldNames();
//        Field[] allFields = new Field[fieldFileNames.length];
//
//
//        for(int i=0; i< fieldFileNames.length;i++){
//
//            allFields[i] = new Field(fieldFileNames[i], lang);
//        }
//
//        System.out.println("test1 udprint: " + allFields[0].getFieldName());
//        System.out.println("test2 udprint: " + allFields[1].getFieldName());
//
//
//
//        System.out.println("navn på fil 1: " + fieldFileNames[0]);
//        System.out.println("navn på fil 2: "+fieldFileNames[1]);
//
//        Player adam = new Player("Adam", 9019201);
//        Player henrik = new Player("Henrik", 9021380);
//
//        allFields[0].setOwner(adam);
//        allFields[0].isOwned(henrik);
//        allFields[1].setOwner(adam);
//        allFields[1].isOwned(henrik);
//        allFields[0].isOwned(henrik);
//

        // Language test

        fileScanner languageScanner = new fileScanner("Languages");
        fileScanner fieldScanner = new fileScanner("Fields");

        String[] languageFileNames = languageScanner.getFieldNames();
        Language[] allLanguages = new Language[languageFileNames.length];
        String[] fieldFileNames = fieldScanner.getFieldNames();
        Field[] allFieldsDK = new Field[fieldFileNames.length];
        Field[] allFieldsENG = new Field[fieldFileNames.length];

       // adding languages in allLanguages
        for(int i=0; i< languageFileNames.length;i++){

            allLanguages[i] = new Language(languageFileNames[i]);
        }
        for(int i=0; i< fieldFileNames.length;i++){

            allFieldsDK[i] = new Field(fieldFileNames[i], allLanguages[0]);
        }
        for(int i=0; i< fieldFileNames.length;i++){

            allFieldsENG[i] = new Field(fieldFileNames[i], allLanguages[1]);
        }
        System.out.println(allFieldsDK[0].getFieldName());
        System.out.println(allFieldsDK[1].getFieldName());
        System.out.println(allFieldsDK[2].getFieldName());

        System.out.println(allFieldsENG[0].getFieldName());
        System.out.println(allFieldsENG[1].getFieldName());
        System.out.println(allFieldsENG[2].getFieldName());

    }
}
