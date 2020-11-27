package Spil;

public class FieldFactory {
    private String[] fieldFileNames;
    private Field[] allFields;
    private Field[] allFieldsTemp;

    public FieldFactory(Language lang){
        fileScanner fieldScanner = new fileScanner("Fields");


        fieldFileNames = fieldScanner.getFieldNames();
        allFields = new Field[fieldFileNames.length];
        allFieldsTemp = new Field[fieldFileNames.length];




        // Tjekker på dansk
        for(int i=0; i< fieldFileNames.length;i++){

            allFieldsTemp[i] = new Field(fieldFileNames[i], lang);
        }
        for(int i=0; i< fieldFileNames.length;i++){

            allFields[allFieldsTemp[i].getPos()] = allFieldsTemp[i];
        }
    }

    public Field[] getAllFields() {
        return allFields;
    }
}
