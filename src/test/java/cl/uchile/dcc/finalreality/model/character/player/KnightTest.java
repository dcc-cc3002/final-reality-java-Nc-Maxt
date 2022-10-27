package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest extends ThiefTest{
    private BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();
    private Knight knt1 = new Knight("Petrick", 120, 40, queue1);
    private Knight knt2 = new Knight("Petrick", 120, 40, queue1);
    protected Knight knt3 = new Knight("Simon", 90, 70, queue1);
    private Thief t0 = new Thief("Simon", 90, 70, queue1);

    @BeforeEach
    void setUp() {
        this.queue1 = new LinkedBlockingQueue<>();
    }

    @Test
    void testequals() {
        assertTrue(knt3.equals(knt3), "The same instances should be equal to itself");
        assertTrue(knt1.equals(knt2), "Two different instances with equal data should be equals");
        assertTrue(knt1.equals(knt2), "Equal should be symmetric");
        assertFalse(knt3.equals(knt1), "Two different instances with different data shouldn´t be equals");
        assertFalse(knt2.equals(t3), "Two different Objects should be different");
        assertFalse(knt3.equals(t0), "Two different Objects with same data should be different");
        System.out.println(enem4);
    }

    @Test
    void testToString() {
        assertEquals(knt1.toString(), knt1.toString(), "toString get correct the data of the enemy?");
        assertNotEquals(knt3.toString(), knt1.toString(), "Is the data of 2 different intances equal?");
        assertEquals(knt2.toString(), knt1.toString(), "Is the data of 2 equal intances equal?");
    }

    @Test
    void testResolutionExceptioninConstructors() {
        Knight k0_test = new Knight("Elias", -3, 64,  queue1);
        assertNotEquals(-3, k0_test.getMaxHp(), "MaxHp shouldn´t be negative even if given a negative to the constructor");
        Knight k1_test = new Knight("Isaias", 0, 23, queue1);
        assertNotEquals(-3, k1_test.getDefense(), "MaxHp shouldn´t be 0 if it's a new character even if given 0 to the constructor");
        Knight k2_test = new Knight("Lucy", 42, -3,  queue1);
        assertNotEquals(0, k2_test.getMaxHp(), "Defense Shouldn´t be 0 even if given a negative to the constructor");
    }

    @Test
    void testResolutionExceptioninHp() {
        knt2.setCurrentHp(-10);
        assertNotEquals(-10, knt2.getCurrentHp(), "The current Hp of a Character shoul't be negative");
        knt2.setCurrentHp(knt2.getMaxHp()+10);
        assertNotEquals(knt2.getMaxHp()+10, knt2.getCurrentHp(), "The current Hp of a Character shoul't be higher than it´s maxHp");
        knt2.setCurrentHp(1);
        assertEquals(1, knt2.getCurrentHp(), "Every change in the currentHP, that's between 0 and maxHp should change correctly");
    }
}