package Spil;

public class FieldFactory {
    private String[] fieldFileNames;
    private Field[] allFields;
    private Field[] allFieldsTemp;
    private Field[] streetFields = new Field[16];
    private Field[] streetFieldsTemp;

    public FieldFactory(Language lang){
        fileScanner fieldScanner = new fileScanner("Fields");

        fieldFileNames = fieldScanner.getFieldNames();
        allFields = new Field[fieldFileNames.length];
        allFieldsTemp = new Field[fieldFileNames.length];






        for(int i=0; i< fieldFileNames.length;i++){

            allFieldsTemp[i] = new Field(fieldFileNames[i], lang);
        }
        for(int i=0; i< fieldFileNames.length;i++){

            allFields[allFieldsTemp[i].getPos()] = allFieldsTemp[i];
        }
        streetFieldsTemp = new Field[fieldFileNames.length];
        for(int i=0; i< fieldFileNames.length;i++){

            streetFieldsTemp[allFields[i].getFieldID()] = allFields[i];



        }

        for(int i = 0; i <streetFields.length;i++){
            streetFields[i]=streetFieldsTemp[i];
            System.out.println(streetFields[i].getFieldName());
        }

    }

    public Field[] getAllFields() {
        return allFields;
    }

    public Field[] getStreetFields() {
        return streetFields;
    }
}
