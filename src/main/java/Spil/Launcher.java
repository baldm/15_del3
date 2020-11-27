package Spil;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int playerCount =0;
        Language lang;
        String[] playerNamelist;
        boolean gameisover = false;
        Player[] playerlist;
        Dice dice = new Dice(1);
        Field[] fieldList;
        int[] scoreboard;


         //Choose language
        fileScanner languageScanner = new fileScanner("Languages");
        String[] languageFileNames = languageScanner.getFieldNames();



        while(true){
            System.out.println("Choose language");
            for(int i =0; i < languageFileNames.length;i++){
                System.out.println("Press " + (i+1) + " for " + languageFileNames[i]);
            }
            int choice = input.nextInt();

            if(choice <= languageFileNames.length && choice > 0){
                lang = new Language(languageFileNames[choice-1]);
                break;
            } else{
                System.out.println("Error! Language not found!");
            }

        }

         // Decide number of players

        boolean choiceValid = false;

        while(!choiceValid){
            System.out.println("Angiv antal spillere mellem 2 og 4");
            playerCount=input.nextInt();

            switch (playerCount){
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

        for(int i=0;i<playerCount;i++){
            System.out.println("Angiv spiller " + (i+1) + "'s navn");
            playerNamelist[i] = input.next();
        }

        // Initializing players
        playerlist = new Player[playerCount];
        for(int i = 0; i<playerCount;i++){
            playerlist[i] = new Player(playerNamelist[i],2);
        }

        // Initializing Fields

        FieldFactory fieldFactory = new FieldFactory(lang);
        fieldList = fieldFactory.getAllFields();
        //Start game

        while(!gameisover){
            for(int i=0; i<playerCount;i++){
                if(playerlist[i].isInJail()){
                    playerlist[i].addMoney(-1);
                    playerlist[i].setInJail(false);
                    if(playerlist[i].getMoney() < 0){
                        gameisover = true;
                        break;
                    }
                }
                System.out.println("It is " + playerlist[i].getName() + "'s turn");
                System.out.println("Press enter to roll the dice");
                input.next();
            takeTurn(playerlist[i],dice,fieldList);
            if(playerlist[i].getMoney() < 0){
                gameisover = true;
                break;
            }

            }
            //UPDATE GUI
        }

        scoreboard = new int[playerCount];
        for(int i=0; i< playerCount;i++){

        }




    }
    public static void takeTurn(Player player,Dice dice,Field[] fieldList){
        int newpos = player.getPosition() + dice.Roll();
        player.setPosition(newpos);
        fieldList[newpos].isOwned(player);




    }
}
