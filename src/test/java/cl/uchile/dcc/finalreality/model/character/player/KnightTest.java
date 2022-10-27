package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest extends ThiefTest{
    private BlockingQueue<GameCharacter> queue1;
    private Knight knt1;
    private Knight knt2;
    protected Knight knt3;
    private Thief t0 ;

    @BeforeEach
    void setUp() {
        this.queue1 = new LinkedBlockingQueue<>();
        this.knt1 = new Knight("Petrick", 120, 40, queue1);
        this.knt2 = new Knight("Petrick", 120, 40, queue1);
        this.knt3 = new Knight("Simon", 90, 70, queue1);
        this.t0 = new Thief("Simon", 90, 70, queue1);
        System.out.println(queue1);
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
}