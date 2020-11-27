package Spil;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    String name = "test";
    int money = 0;
    int addedMoney;
    Player player = new Player(name,money);
    Dice dice = new Dice(0);
    int newpos;
    boolean[] ownedFields = new boolean[player.getOwnedFields().length];
    boolean[] ownsboth = new boolean[player.getOwnsboth().length];


    @Test
    void getName() {
        assertEquals(player.getName().equals(name),true);
    }

    @Test
    void setName() {
        name = "test1";

        player.setName(name);
        assertEquals(player.getName().equals(name),true);
    }

    @Test
    void getMoney() {
        assertEquals(player.getMoney() == money,true);
    }

    @Test
    void addMoney() {
        addedMoney = dice.Roll();
        money += addedMoney;
        player.addMoney(addedMoney);
        assertEquals(player.getMoney() == money,true);
    }

    @Test
    void getPosition() {
        assertEquals(player.getPosition() == 0,true);
    }

    @Test
    void setPosition() {
        newpos = player.getPosition()+ dice.Roll();
        player.setPosition(newpos);
        assertEquals(player.getPosition() == newpos,true);
    }

    @Test
    void getOwnedFields() {
        ownedFields = player.getOwnedFields();
        for (int i = 0; i < player.getOwnedFields().length; i++) {
            assertEquals(Objects.equals(ownedFields[i], false), true);
        }
    }
    @Test
    void getOwnsboth() {
        ownsboth = player.getOwnsboth();
        for (int i = 0; i < ownsboth.length; i++) {
            assertEquals(Objects.equals(ownedFields[i], false), true);
        }
    }

    @Test
    void setOwnedFields() {
        for (int i = 0; i < player.getOwnedFields().length; i++) {
            ownedFields[i] = true;
        }
        for (int i = 0; i < player.getOwnedFields().length; i++) {
            assertEquals(Objects.equals(ownedFields[i], true), true);
        }

    }

    @Test
    void ownsboth() {
        for (int i = 0; i < player.getOwnedFields().length; i++) {
            ownedFields[i] = true;
        }
        for (int i = 0; i < ownsboth.length; i++) {
            assertEquals(Objects.equals(ownedFields[i], true), true);
        }
    }


}