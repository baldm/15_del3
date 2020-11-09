package Gui;

import Spil.Dice;
import Spil.Player;

public class allGuiFuncTest {
    public static void main(String[] args) {

        // Opretter players
        Player playerOne = new Player("jonathan", 1000);
        Player playerTwo = new Player("jens", 1000);

        // Opretter dices
        Dice diceOne = new Dice(1);
        Dice diceTwo = new Dice(1);

        // Opretter player List
        Player[] playerList = new Player[]{playerOne,playerTwo};

        // Forskellige metoder i interface
        Interface.createGui(playerOne, playerTwo);
        Interface.movePlayer(playerOne);
        Interface.movePlayer(playerTwo);
        Interface.displayMessage("Test af display message");
        Interface.addPlayerBalance(playerOne, 500);


        while (true) {
            for (int i = 0; i < 2; i++) {
                Player curPlayer = playerList[i];

                Interface.displayMessage("Rul med dices:");
                int roll = diceOne.Roll() + diceTwo.Roll();
                Interface.setBoardDice(diceOne.getValue(),diceTwo.getValue());

                curPlayer.setPosition(curPlayer.getPosition()+roll);

                Interface.movePlayer(curPlayer);
            }
        }



    }
}
