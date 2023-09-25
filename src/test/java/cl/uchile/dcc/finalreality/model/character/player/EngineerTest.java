package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.AxeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

public class EngineerTest extends AxeTest {
    private BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();
    private Engineer eng1  = new Engineer("Tim", 30, 15, queue1);
    private Engineer eng2 = new Engineer("Mark", 41, 30, queue1);
    private Engineer eng3 = new Engineer("Mark", 41, 30, queue1);
    private Knight knt0 = new Knight("Tim", 30, 15, queue1);
    private Knight knt3 = new Knight("Simon", 90, 70, queue1);

    @BeforeEach
    void setUp() {
        this.queue1 = new LinkedBlockingQueue<>();
    }

    @Test
    void testequals() {
        assertTrue(eng1.equals(eng1), "The same instances should be equal to itself");
        assertTrue(eng3.equals(eng2), "Two different instances with equal data should be equals");
        assertTrue(eng2.equals(eng3), "Equal should be symmetric");
        assertFalse(eng3.equals(eng1), "Two different instances with different data shouldn´t be equals");
        assertFalse(eng2.equals(knt3), "Two different Objects should be different");
        assertFalse(eng1.equals(knt0), "Two different Objects with same data should be different");
    }

    @Test
    void testToString() {
        assertEquals(eng1.toString(), eng1.toString(), "toString get correct the data of the enemy?");
        assertNotEquals(eng3.toString(), eng1.toString(), "Is the data of 2 different intances equal?");
        assertEquals(eng2.toString(), eng3.toString(), "Is the data of 2 equal intances equal?");
    }

    @Test
    void testResolutionExceptioninConstructors() {
        Engineer e0_test = new Engineer("Elias", -3, 64,  queue1);
        assertNotEquals(-3, e0_test.getMaxHp(), "MaxHp shouldn´t be negative even if given a negative to the constructor");
        Engineer e1_test = new Engineer("Isaias", 0, 23, queue1);
        assertNotEquals(-3, e1_test.getDefense(), "MaxHp shouldn´t be 0 if it's a new character even if given 0 to the constructor");
        Engineer e2_test = new Engineer("Lucy", 42, -3,  queue1);
        assertNotEquals(0, e2_test.getMaxHp(), "Defense Shouldn´t be 0 even if given a negative to the constructor");
    }

    @Test
    void testResolutionExceptioninHp() {
        eng3.setCurrentHp(-10);
        assertNotEquals(-10, eng3.getCurrentHp(), "The current Hp of a Character shoul't be negative");
        eng3.setCurrentHp(eng3.getMaxHp()+10);
        assertNotEquals(eng3.getMaxHp()+10, eng3.getCurrentHp(), "The current Hp of a Character shoul't be higher than it´s maxHp");
        eng3.setCurrentHp(1);
        assertEquals(1, eng3.getCurrentHp(), "Every change in the currentHP, that's between 0 and maxHp should change correctly");
    }

    @Test
    void testreduceHp() {
        eng3.reduceHp(eng3.getMaxHp()+1);
        assertEquals(0, eng3.getCurrentHp(), "The current Hp of a Character should be 0 when its hp go lower than 0");
        eng2.reduceHp(eng2.getMaxHp());
        assertEquals(0, eng2.getCurrentHp(), "The current Hp of a Character should be 0 if its hp went to 0");
        eng1.reduceHp(14);
        assertEquals(16, eng1.getCurrentHp(), "Every change in the currentHP, that's between 0 and maxHp should change correctly");
    }
}