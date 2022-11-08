package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.AxeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest extends AxeTest {
    private BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();
    private WhiteMage wm1 = new WhiteMage("Azrael", 20, 35, 40, queue1);;
    private WhiteMage wm2 = new WhiteMage("Azrael", 20, 35, 40, queue1);
    private WhiteMage wm3 = new WhiteMage("Thomas", 45, 28, 50, queue1);
    private BlackMage bm0 = new BlackMage("Thomas", 45, 28, 50, queue1);
    private BlackMage bmg3 = new BlackMage("Thomas", 45, 28, 50, queue1);

    @BeforeEach
    void setUp() {
        this.queue1 = new LinkedBlockingQueue<>();
    }

    @Test
    void testequals() {
        assertTrue(wm3.equals(wm3), "The same instances should be equal to itself");
        assertTrue(wm1.equals(wm2), "Two different instances with equal data should be equals");
        assertTrue(wm1.equals(wm2), "Equal should be symmetric");
        assertFalse(wm3.equals(wm1), "Two different instances with different data shouldn´t be equals");
        assertFalse(wm2.equals(bmg3), "Two different Objects should be different");
        assertFalse(wm3.equals(bm0), "Two different Objects with same data should be different");
    }

    @Test
    void testToString() {
        assertEquals(wm1.toString(), wm1.toString(), "toString get correct the data of the enemy?");
        assertNotEquals(wm3.toString(), wm1.toString(), "Is the data of 2 different intances equal?");
        assertEquals(wm2.toString(), wm1.toString(), "Is the data of 2 equal intances equal?");
    }

    @Test
    void testResolutionExceptioninConstructors() {
        WhiteMage wm0_test = new WhiteMage("Elias", -3, 64, 32, queue1);
        assertNotEquals(-3, wm0_test.getMaxHp(), "MaxHp shouldn´t be negative even if given a negative to the constructor");
        WhiteMage wm2_test = new WhiteMage("Lucy", 0, 0, 10, queue1);
        assertNotEquals(0, wm2_test.getMaxHp(), "MaxHp shouldn´t be 0 if it's a new character even if given 0 to the constructor");
        WhiteMage wm1_test = new WhiteMage("Isaias", 64, -3, 32, queue1);
        assertNotEquals(-3, wm1_test.getDefense(), "Defense shouldn´t be negative even if given a negative to the constructor");
        WhiteMage wm3_test = new WhiteMage("Fer", 13, 13, -10, queue1);
        assertNotEquals(-10, wm3_test.getMaxMp(), "MaxMp Shouldn´t be negative even if given a negative to the constructor");
    }

    @Test
    void testResolutionExceptioninHp() {
        wm1.setCurrentHp(-10);
        assertNotEquals(-10, wm1.getCurrentHp(), "The current Hp of a Character shoul't be negative");
        wm1.setCurrentHp(wm1.getMaxHp()+10);
        assertNotEquals(wm1.getMaxHp()+10, wm1.getCurrentHp(), "The current Hp of a Character shoul't be higher than it´s maxHp");
        wm1.setCurrentHp(1);
        assertEquals(1, wm1.getCurrentHp(), "Every change in the currentHP, that's between 0 and maxHp should change correctly");
    }

    @Test
    void testResolutionExceptioninMp() {
        wm3.setCurrentMp(-10);
        assertNotEquals(-10, wm3.getCurrentMp(), "The current Mp of a Character shoul't be negative");
        wm3.setCurrentMp(wm3.getMaxMp()+10);
        assertNotEquals(wm3.getMaxMp()+10, wm3.getCurrentMp(), "The current Mp of a Character shoul't be higher than it´s maxMp");
        wm3.setCurrentMp(1);
        assertEquals(1, wm3.getCurrentMp(), "Every change in the currentMp, that's between 0 and maxMp should change correctly");
    }
}