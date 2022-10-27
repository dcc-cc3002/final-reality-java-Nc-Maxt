package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest extends BlackMageTest {
    private BlockingQueue<GameCharacter> queue1;
    private WhiteMage wm1;
    private WhiteMage wm2 ;
    protected WhiteMage wm3;
    private BlackMage bm0 ;

    @BeforeEach
    void setUp() {
        this.queue1 = new LinkedBlockingQueue<>();
        this.wm1 = new WhiteMage("Azrael", 20, 35, 40, queue1);
        this.wm2 = new WhiteMage("Azrael", 20, 35, 40, queue1);
        this.wm3 = new WhiteMage("Thomas", 45, 28, 50, queue1);
        this.bm0 = new BlackMage("Thomas", 45, 28, 50, queue1);
        System.out.println(queue1);
    }

    @Test
    void testequals() {
        assertTrue(wm3.equals(wm3), "The same instances should be equal to itself");
        assertTrue(wm1.equals(wm2), "Two different instances with equal data should be equals");
        assertTrue(wm1.equals(wm2), "Equal should be symmetric");
        assertFalse(wm3.equals(wm1), "Two different instances with different data shouldn´t be equals");
        assertFalse(wm2.equals(bmg3), "Two different Objects should be different");
        assertFalse(wm3.equals(bm0), "Two different Objects with same data should be different");
        System.out.println(enem4);
    }

    @Test
    void testToString() {
        assertEquals(wm1.toString(), wm1.toString(), "toString get correct the data of the enemy?");
        assertNotEquals(wm3.toString(), wm1.toString(), "Is the data of 2 different intances equal?");
        assertEquals(wm2.toString(), wm1.toString(), "Is the data of 2 equal intances equal?");
    }
}