package Gui;

public class allGuiFuncTest {
    public static void main(String[] args) {

        String playerOneName = "jonathan";
        String playerTwoName = "jens";
        // Opretter players
        Player playerOne = new Player(playerOneName, 1000);
        Player playerTwo = new Player(playerTwoName, 1000);

        // Opretter dices
        diceOne = new Dice(1);
        diceTwo = new Dice(1);

        // Opretter player List
        playerList = new Player[]{playerOne,playerTwo};


        Interface.createGui(playerOne.getName(), playerTwo.getName());
        Interface.movePlayer(playerOne.getName(), 0);
        Interface.movePlayer(playerTwo.getName(), 0);
        Interface.displayMessage(lang.getWelcome());
    }
}
