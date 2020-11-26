package Spil;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChanceCardTest {

    @Test
    public void ChanceCardOutputTest() {
        fileScanner languageScanner = new fileScanner("Languages");
        fileScanner fieldScanner = new fileScanner("ChanceCards");

        String[] cardFileNames = fieldScanner.getFieldNames();
        ChanceCard[] allCards = new ChanceCard[cardFileNames.length];

        String[] Langss = languageScanner.getFieldNames();
        Language lang = new Language(Langss[0]);
        for(int i=0; i< cardFileNames.length;i++){

            allCards[i] = new ChanceCard(cardFileNames[i], lang);
        }
        assertEquals("CHANCE", allCards[0].getCardName());
        assertEquals(0, allCards[0].getCardID());
        assertEquals(2, allCards[0].getMoneyAmount());
        assertEquals(8, allCards[8].getCardID());
        assertEquals(4, allCards[9].getMoveToGroupID());
        assertEquals(23, allCards[6].getMoveToFieldID());
    }


}
