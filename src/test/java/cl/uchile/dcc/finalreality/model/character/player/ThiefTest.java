package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class ThiefTest extends WhiteMageTest {
    private BlockingQueue<GameCharacter> queue1;
    private Thief t1;
    private Thief t2;
    protected Thief t3;
    private WhiteMage wm0 ;

    @BeforeEach
    void setUp() {
        this.queue1 = new LinkedBlockingQueue<>();
        this.t1 = new Thief("Balze", 30, 15, queue1);
        this.t2 = new Thief("Balze", 30, 15, queue1);
        this.t3 = new Thief("Mathew", 60, 3, queue1);
        this.wm0 = new WhiteMage("Balze", 30, 15, 40, queue1);
        System.out.println(queue1);
    }

    @Test
    void testequals() {
        assertTrue(t3.equals(t3), "The same instances should be equal to itself");
        assertTrue(t1.equals(t2), "Two different instances with equal data should be equals");
        assertTrue(t1.equals(t2), "Equal should be symmetric");
        assertFalse(t3.equals(t1), "Two different instances with different data shouldn´t be equals");
        assertFalse(t2.equals(wm3), "Two different Objects should be different");
        assertFalse(t3.equals(wm0), "Two different Objects with same data should be different");
        System.out.println(enem4);
    }

    @Test
    void testToString() {
        assertEquals(t1.toString(), t1.toString(), "toString get correct the data of the enemy?");
        assertNotEquals(t3.toString(), t1.toString(), "Is the data of 2 different intances equal?");
        assertEquals(t2.toString(), t1.toString(), "Is the data of 2 equal intances equal?");
    }
}