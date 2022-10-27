package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.EngineerTest;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class TimerExampleTest extends EngineerTest {

    private BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private WhiteMage Wm_3 = new WhiteMage("Kvote", 435, 13, 130, queue);
    private Enemy badg = new Enemy("Stif", 40, 234, 20, queue);
    private ArrayList<Weapons> Bag = new ArrayList<Weapons>();

    @BeforeEach
    void setUp() {
        Bag.add(k2);
        Bag.add(a2);
        Bag.add(b2);
        Bag.add(st3);
    }

    @Test
    void testsurrealFight() throws InterruptedException {
        assertNull(Wm_3.getEquippedWeapon(), "After inilizialized the character must not have a Weapon");
        Wm_3.equip(Bag.get(0));
        assertEquals(Bag.get(0), Wm_3.getEquippedWeapon(), "After been equipped a weapon this should be the same");
        System.out.println(Wm_3.getName() + " Attacks " + badg.getName());
        badg.setCurrentHp(badg.getCurrentHp() - Wm_3.getEquippedWeapon().getDamage());
        assertNotEquals(badg.getMaxHp(), badg.getCurrentHp(), "After been hitted the currentHp and the MaxHp shouldn´t be the same");
        Wm_3.equip(Bag.get(1));
        assertEquals(Bag.get(1), Wm_3.getEquippedWeapon(), "After been equipped a weapon this should be the same");
        System.out.println(Wm_3.getName() + " Attacks " + badg.getName());
        badg.setCurrentHp(badg.getCurrentHp() - Wm_3.getEquippedWeapon().getDamage());
        assertNotEquals(badg.getMaxHp(), badg.getCurrentHp(), "After been hitted the currentHp and the MaxHp shouldn´t be the same");
        Wm_3.equip(Bag.get(2));
        assertEquals(Bag.get(2), Wm_3.getEquippedWeapon(), "After been equipped a weapon this should be the same");
        System.out.println(Wm_3.getName() + " Attacks " + badg.getName());
        badg.setCurrentHp(badg.getCurrentHp() - Wm_3.getEquippedWeapon().getDamage());
        assertNotEquals(badg.getMaxHp(), badg.getCurrentHp(), "After been hitted the currentHp and the MaxHp shouldn´t be the same");
        Wm_3.equip(Bag.get(3));
        assertEquals(Bag.get(3), Wm_3.getEquippedWeapon(), "After been equipped a weapon this should be the same");
        System.out.println(Wm_3.getName() + " Attacks " + badg.getName());
        badg.setCurrentHp(badg.getCurrentHp() - Wm_3.getEquippedWeapon().getDamage());
        assertEquals(0, badg.getCurrentHp(), "After been hitted to death (Hp dropped to 0 or less) the currentHp shoul be 0");
        Wm_3.waitTurn();
        badg.waitTurn();
        // Waits for 6 seconds to ensure that all characters have finished waiting
        Thread.sleep(6000);
        while (!queue.isEmpty()) {
            // Pops and prints the names of the characters of the queue to illustrate the turns
            // order
            System.out.println(queue.poll().toString());
        }
    }
}