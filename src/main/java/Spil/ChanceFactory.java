package Spil;

public class ChanceFactory {
    private String[] cardNames;
    private ChanceCard[] cards;




    public ChanceFactory(Language lang) {
        fileScanner cardScanner = new fileScanner("ChanceCards");

        cardNames = cardScanner.getFieldNames();
        cards = new ChanceCard[cardNames.length];
        for (int i = 0; i < cardNames.length; i++) {

            cards[i] = new ChanceCard(cardNames[i], lang);
        }

    }

    public ChanceCard[] getCards() {
        return cards;
    }
}
