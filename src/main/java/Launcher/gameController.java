package Launcher;
import Gui.Interface;
import Spil.*;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class gameController {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int playerCount = 0;
        Language lang;
        String[] playerNamelist;
        boolean gameisover = false;
        Player[] playerlist;
        Dice dice = new Dice(1);
        Field[] fieldList;
        Field[] streetFields;
        int[] scoreboard;
        ChanceCard[] chanceCards;


        //Choose language
        fileScanner languageScanner = new fileScanner("Languages");
        String[] languageFileNames = languageScanner.getFieldNames();


        while (true) {
            System.out.println("Choose language");
            for (int i = 0; i < languageFileNames.length; i++) {
                System.out.println("Press " + (i + 1) + " for " + languageFileNames[i]);
            }
            int choice = Integer.parseInt(input.nextLine());

            if (choice <= languageFileNames.length && choice > 0) {
                lang = new Language(languageFileNames[choice - 1]);
                break;
            } else {
                System.out.println("Error! Language not found!");
            }

        }

        // Decide number of players

        boolean choiceValid = false;

        while (!choiceValid) {
            System.out.println("Angiv antal spillere mellem 2 og 4");
            playerCount = Integer.parseInt(input.nextLine());

            switch (playerCount) {
                case 2:
                    choiceValid = true;
                    break;
                case 3:
                    choiceValid = true;
                    break;
                case 4:
                    choiceValid = true;
                    break;
                default:
                    System.out.println("Error! wrong number");
                    choiceValid = false;
                    break;

            }
        }

        // Make playerlist with names
        playerNamelist = new String[playerCount];

        for (int i = 0; i < playerCount; i++) {
            System.out.println("Angiv spiller " + (i + 1) + "'s navn");
            playerNamelist[i] = input.nextLine();
        }

        // Initializing players
        playerlist = new Player[playerCount];
        for (int i = 0; i < playerCount; i++) {
            playerlist[i] = new Player(playerNamelist[i], 10);
        }

        // Initializing Fields

        FieldFactory fieldFactory = new FieldFactory(lang);
        fieldList = fieldFactory.getAllFields();
        streetFields = fieldFactory.getStreetFields();

        // Open gui
        Interface.createGui(playerlist, fieldList, lang);

        // Initializing Chance Cards
        ChanceFactory chanceFactory = new ChanceFactory(lang);
        chanceCards = chanceFactory.getCards();


        //Start game

        while (!gameisover) {

            for (int i = 0; i < playerCount; i++) {

                if (playerlist[i].isInJail()) {
                    playerlist[i].addMoney(-1);
                    playerlist[i].setInJail(false);
                    if (playerlist[i].getMoney() < 0) {
                        gameisover = true;
                        break;
                    }
                }
                Interface.displayMessage(lang.RULTERNING);

                takeTurn(playerlist[i], dice, fieldList, streetFields, chanceCards);
                if (playerlist[i].getMoney() < 0) {
                    gameisover = true;
                    Interface.displayChance("GAME OVER!");
                    Interface.refreshGui(playerlist);
                    break;
                }
                Interface.refreshGui(playerlist);

            }
        }

        scoreboard = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {

        }


    }

    public static void takeTurn(Player player, Dice dice, Field[] fieldList, Field[] streetFields, ChanceCard[] cardlist) {
        int roll = dice.Roll();
        int newpos = player.getPosition() + roll;
        Interface.setBoardDice(roll);
        player.setPosition(newpos);

        if (fieldList[player.getPosition()].isChance()) {
            drawCard(player, cardlist, streetFields);

        }
        fieldList[player.getPosition()].isOwned(player);


    }

    public static void drawCard(Player player, ChanceCard[] cardlist, Field[] streetFields) {
        int cardNumber;
        ChanceCard card;
        int pos = player.getPosition();

        cardNumber = ThreadLocalRandom.current().nextInt(0, cardlist.length);
        card = cardlist[cardNumber];
        Interface.displayChance(card.getCardText());
        if (card.getMoveToFieldID() >= 0) {
            player.setPosition(card.getMoveToFieldID());
        }
        player.setPosition(pos + card.getMoveAmount());
        player.addMoney(card.getMoneyAmount());
        if (card.getMoveToGroupID() >= 0){
            for (int i = 0; i < 2; i++) { ;
                if (!streetFields[(card.getMoveToGroupID() * 2 + i)].getisOwned()) {
                    player.setPosition(streetFields[(card.getMoveToGroupID() * 2 + i)].getPos());

                }
            }
            if (player.getPosition() != card.getMoveToGroupID() * 2 && player.getPosition() != card.getMoveToGroupID() * 2 + 1) {
                player.setPosition(streetFields[(card.getMoveToGroupID() * 2)].getPos());
            }


        }

    }
}
