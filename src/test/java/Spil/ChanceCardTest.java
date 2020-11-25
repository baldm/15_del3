package Spil;

import org.junit.Test;

public class ChanceCardTest {

    @Test
    public void ChanceCardOutputTest() {
        fileScanner languageScanner = new fileScanner("Languages");
        fileScanner fieldScanner = new fileScanner("ChanceCards");

        String[] fieldFileNames = fieldScanner.getFieldNames();
        ChanceCard[] allFields = new ChanceCard[fieldFileNames.length];

        String[] Langss = languageScanner.getFieldNames();
        Language lang = new Language(Langss[0]);
        for(int i=0; i< fieldFileNames.length;i++){

            allFields[i] = new ChanceCard(fieldFileNames[i], lang);
        }

        System.out.println("test1 udprint: " + allFields[0].getCardName());
        System.out.println("test2 udprint: " + allFields[1].getCardName());
    }


}
