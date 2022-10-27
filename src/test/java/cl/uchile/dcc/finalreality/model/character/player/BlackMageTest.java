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
    private BlockingQueue<GameCharacter> queue1;
    private BlackMage bmg1 ;
    private BlackMage bmg2 ;
    protected BlackMage bmg3 ;
    private Enemy en0 ;


    @BeforeEach
    void setUp() {
        this.queue1 = new LinkedBlockingQueue<>();
        this.bmg1 = new BlackMage("Azrael", 20, 35, 40, queue1);
        this.bmg2 = new BlackMage("Azrael", 20, 35, 40, queue1);
        this.bmg3 = new BlackMage("Thomas", 45, 28, 50, queue1);
        this.en0 = new Enemy("Thomas", 45, 28, 50, queue1);;
        System.out.println(queue1);
    }

    @Test
    void testequals() {
        assertTrue(bmg3.equals(bmg3),"The same instances should be equal to itself" );
        assertTrue(bmg1.equals(bmg2),"Two different instances with equal data should be equals");
        assertTrue(bmg1.equals(bmg2),"Equal should be symmetric");
        assertFalse(bmg3.equals(bmg1),"Two different instances with different data shouldn´t be equals" );
        assertFalse(bmg2.equals(enem4), "Two different Objects should be different");
        assertFalse(bmg3.equals(en0), "Two different Objects with same data should be different");
    }


    @Test
    void testToString() {
        assertEquals(bmg1.toString(), bmg1.toString(), "the data of the same intances should be equal");
        assertNotEquals(bmg3.toString(), bmg1.toString(), "different data in different intances shouldn´t be equal");
        assertEquals(bmg2.toString(), bmg1.toString(), "same data in different intances (same Class) should be equal");
        assertNotEquals(bmg3.toString(), en0.toString(), "same data in different intances (different Class) shouldn´t be equal");
    }
}