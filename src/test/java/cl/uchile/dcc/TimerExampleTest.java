package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.EngineerTest;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.BlackMage;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

class TimerExampleTest extends EngineerTest {

    private BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private BlackMage Bm_3 = new BlackMage("Kvote", 435, 13, 130, queue);
    private Enemy badg = new Enemy("Stif", 40, 234, 20, 26, queue);

    void setUp() {
        Bm_3.setCurrentHp(Bm_3.getMaxHp());
        badg.setCurrentHp(badg.getMaxHp());
    }
    @Test
    void testsurrealFight() throws InterruptedException {
        assertNull(Bm_3.getEquippedWeapon(), "After inilizialized the character must not have a Weapon");
        Bm_3.equip(k2);
        assertEquals(k2, Bm_3.getEquippedWeapon(), "After been equipped a weapon this should be the same");
        System.out.println(Bm_3.getName() + " Attacks " + badg.getName());
        badg.setCurrentHp(badg.getCurrentHp() - Bm_3.getEquippedWeapon().getDamage());
        assertNotEquals(badg.getMaxHp(), badg.getCurrentHp(), "After been hitted the currentHp and the MaxHp shouldn´t be the same");
        Bm_3.equip(st3);
        assertEquals(st3, Bm_3.getEquippedWeapon(), "After been equipped a weapon this should be the same");
        System.out.println(Bm_3.getName() + " Attacks " + badg.getName());
        badg.setCurrentHp(badg.getCurrentHp() - Bm_3.getEquippedWeapon().getDamage());
        assertEquals(0, badg.getCurrentHp(), "After been hitted to death (Hp dropped to 0 or less) the currentHp shoul be 0");
        Bm_3.waitTurn();
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