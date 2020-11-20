package Gui;

import Spil.Dice;
import Spil.Player;

public class PlayerGuiLinkedTest {
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

        playerOne.setPosition(5);
        playerOne.addMoney(500);

        Interface.setOwned(playerOne);

        while (true) {
            for (int i = 0; i < 2; i++) {
                Player curPlayer = playerList[i];

                Interface.displayMessage("Rul med dices:");
                int roll = diceOne.Roll() + diceTwo.Roll();
                Interface.setBoardDice(diceOne, diceTwo);

                curPlayer.setPosition(curPlayer.getPosition() + roll);

            }
        }
    }
}
