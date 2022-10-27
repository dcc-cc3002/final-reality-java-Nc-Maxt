package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.EnemyTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageTest extends EnemyTest {
    private BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();
    private BlackMage bmg1 = new BlackMage("Azrael", 20, 35, 40, queue1);
    private BlackMage bmg2 = new BlackMage("Azrael", 20, 35, 40, queue1);
    protected BlackMage bmg3 = new BlackMage("Thomas", 45, 28, 50, queue1);
    private Enemy en0 = new Enemy("Thomas", 45, 28, 50, queue1);


    @BeforeEach
    void setUp() {
        this.queue1 = new LinkedBlockingQueue<>();
    }

    @Test
    void testequals() {
        assertTrue(bmg3.equals(bmg3),"The same instances should be equal to itself" );
        assertTrue(bmg1.equals(bmg2),"Two different instances with equal data should be equals");
        assertTrue(bmg1.equals(bmg2),"Equal should be symmetric");
        assertFalse(bmg3.equals(bmg1),"Two different instances with different data shouldn´t be equals" );
        assertFalse(bmg2.equals(bmg3), "Two different Objects should be different");
        assertFalse(bmg3.equals(en0), "Two different Objects with same data should be different");
    }


    @Test
    void testToString() {
        assertEquals(bmg1.toString(), bmg1.toString(), "the data of the same intances should be equal");
        assertNotEquals(bmg3.toString(), bmg1.toString(), "different data in different intances shouldn´t be equal");
        assertEquals(bmg2.toString(), bmg1.toString(), "same data in different intances (same Class) should be equal");
        assertNotEquals(bmg3.toString(), en0.toString(), "same data in different intances (different Class) shouldn´t be equal");
    }

    @Test
    void testResolutionExceptioninConstructors() {
        BlackMage bm0_test = new BlackMage("Elias", -3, 64, 32, queue1);
        assertNotEquals(-3, bm0_test.getMaxHp(), "MaxHp shouldn´t be negative even if given a negative to the constructor");
        BlackMage bm2_test = new BlackMage("Lucy", 0, 0, 10, queue1);
        assertNotEquals(0, bm2_test.getMaxHp(), "MaxHp shouldn´t be 0 if it's a new character even if given 0 to the constructor");
        BlackMage bm1_test = new BlackMage("Isaias", 64, -3, 32, queue1);
        assertNotEquals(-3, bm1_test.getDefense(), "Defense shouldn´t be negative even if given a negative to the constructor");
        BlackMage bm3_test = new BlackMage("Fer", 13, 13, -10, queue1);
        assertNotEquals(-10, bm3_test.getMaxMp(), "maxMp Shouldn´t be negative even if given a negative to the constructor");
    }

    @Test
    void testResolutionExceptioninHp() {
        bmg3.setCurrentHp(-10);
        assertNotEquals(-10,bmg3.getCurrentHp(), "The current Hp of a Character shoul't be negative");
        bmg3.setCurrentHp(bmg3.getMaxHp()+10);
        assertNotEquals(bmg3.getMaxHp()+10,bmg3.getCurrentHp(), "The current Hp of a Character shoul't be higher than it´s maxHp");
        bmg3.setCurrentHp(1);
        assertEquals(1, bmg3.getCurrentHp(), "Every change in the currentHP, that's between 0 and maxHp should change correctly");
    }

    @Test
    void testResolutionExceptioninMp() {
        bmg3.setCurrentMp(-10);
        assertNotEquals(-10,bmg3.getCurrentMp(), "The current Mp of a Character shoul't be negative");
        bmg3.setCurrentMp(bmg3.getMaxMp()+10);
        assertNotEquals(bmg3.getMaxMp()+10,bmg3.getCurrentMp(), "The current Mp of a Character shoul't be higher than it´s maxMp");
        bmg3.setCurrentMp(1);
        assertEquals(1, bmg3.getCurrentMp(), "Every change in the currentMp, that's between 0 and maxMp should change correctly");
    }

}