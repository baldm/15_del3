package Gui;

import Spil.Dice;
import Spil.FieldFactory;
import Spil.Language;
import Spil.Player;

public class PlayerGuiLinkedTest {
    public static void main(String[] args) {
        // Opretter players
        Player playerOne = new Player("jonathan", 2);
        Player playerTwo = new Player("jens", 2);
        // Opretter dices
        Dice diceOne = new Dice(1);
        Dice diceTwo = new Dice(1);

        // Opretter player List
        Player[] playerList = new Player[]{playerOne,playerTwo};
        Language lang = new Language("Danish.properties");
        FieldFactory fieldFact = new FieldFactory(lang);

        // Forskellige metoder i interface
        Interface.createGui(playerOne, playerTwo, fieldFact.getAllFields());

        playerOne.setPosition(5);
        playerOne.setOwnedFields(7);
        playerOne.setOwnedFields(15);


        while (true) {
            for (int i = 0; i < 2; i++) {
                Player curPlayer = playerList[i];

                Interface.displayMessage("Rul med dices:");
                int roll = diceOne.Roll() + diceTwo.Roll();
                Interface.setBoardDice(diceOne, diceTwo);

                curPlayer.setPosition(curPlayer.getPosition() + roll);
                Interface.refreshGui(playerList);

            }
        }
    }
}
