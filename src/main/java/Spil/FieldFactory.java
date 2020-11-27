package Spil;

public class FieldFactory {


    public FieldFactory(Language lang){
        fileScanner fieldScanner = new fileScanner("Fields");


        String[] fieldFileNames = fieldScanner.getFieldNames();
        Field[] allFields = new Field[fieldFileNames.length];
        Field[] allFieldsTemp = new Field[fieldFileNames.length];




        // Tjekker på dansk
        for(int i=0; i< fieldFileNames.length;i++){

            allFieldsTemp[i] = new Field(fieldFileNames[i], lang);
        }
        for(int i=0; i< fieldFileNames.length;i++){

            allFields[allFieldsTemp[i].getPos()] = allFieldsTemp[i];
        }
    }
}
