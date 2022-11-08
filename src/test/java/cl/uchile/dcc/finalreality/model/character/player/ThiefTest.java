package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.AxeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

class ThiefTest extends AxeTest {
    private BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();
    private Thief t1 = new Thief("Balze", 30, 15, queue1);
    private Thief t2 = new Thief("Balze", 30, 15, queue1);
    private Thief t3 = new Thief("Mathew", 60, 3, queue1);
    private WhiteMage wm0 = new WhiteMage("Balze", 30, 15, 40, queue1);
    private WhiteMage wm3 = new WhiteMage("Thomas", 45, 28, 50, queue1);

    @BeforeEach
    void setUp() {
        this.queue1 = new LinkedBlockingQueue<>();
    }

    @Test
    void testequals() {
        assertTrue(t3.equals(t3), "The same instances should be equal to itself");
        assertTrue(t1.equals(t2), "Two different instances with equal data should be equals");
        assertTrue(t1.equals(t2), "Equal should be symmetric");
        assertFalse(t3.equals(t1), "Two different instances with different data shouldn´t be equals");
        assertFalse(t2.equals(wm3), "Two different Objects should be different");
        assertFalse(t3.equals(wm0), "Two different Objects with same data should be different");
    }

    @Test
    void testToString() {
        assertEquals(t1.toString(), t1.toString(), "toString get correct the data of the enemy?");
        assertNotEquals(t3.toString(), t1.toString(), "Is the data of 2 different intances equal?");
        assertEquals(t2.toString(), t1.toString(), "Is the data of 2 equal intances equal?");
    }

    @Test
    void testResolutionExceptioninConstructors() {
        Thief t0_test = new Thief("Elias", -3, 64,  queue1);
        assertNotEquals(-3, t0_test.getMaxHp(), "MaxHp shouldn´t be negative even if given a negative to the constructor");
        Thief t1_test = new Thief("Isaias", 0, 23, queue1);
        assertNotEquals(-3, t1_test.getDefense(), "MaxHp shouldn´t be 0 if it's a new character even if given 0 to the constructor");
        Thief t2_test = new Thief("Lucy", 42, -3,  queue1);
        assertNotEquals(0, t2_test.getMaxHp(), "Defense Shouldn´t be 0 even if given a negative to the constructor");
    }

    @Test
    void testResolutionExceptioninHp() {
        t3.setCurrentHp(-10);
        assertNotEquals(-10,t3.getCurrentHp(), "The current Hp of a Character shoul't be negative");
        t3.setCurrentHp(t3.getMaxHp()+10);
        assertNotEquals(t3.getMaxHp()+10,t3.getCurrentHp(), "The current Hp of a Character shoul't be higher than it´s maxHp");
        t3.setCurrentHp(1);
        assertEquals(1, t3.getCurrentHp(), "Every change in the currentHP, that's between 0 and maxHp should change correctly");
    }
}