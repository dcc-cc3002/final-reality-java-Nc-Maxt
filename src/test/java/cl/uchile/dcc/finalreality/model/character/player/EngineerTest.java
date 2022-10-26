package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EngineerTest extends KnightTest {
    private BlockingQueue<GameCharacter> queue1;
    private Engineer eng1;
    private Engineer eng2;
    protected Engineer eng3;
    private Knight knt0;

    @BeforeEach
    void setUp() {
        this.queue1 = new LinkedBlockingQueue<>();
        this.eng1 = new Engineer("Tim", 30, 15, queue1);
        this.eng2 = new Engineer("Mark", 41, 30, queue1);
        this.eng3 = new Engineer("Mark", 41, 30, queue1);
        this.knt0 = new Knight("Tim", 30, 15, queue1);
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
        String name = eng1.getName();
        int Hp = eng1.getCurrentHp();
        int maxHp = eng1.getMaxHp();
        int def = eng1.getDefense();
        String enemstr = "Engineer{ name='%s', currentHp=%d, maxHp=%d, defense=%d }"
                .formatted(name, Hp, maxHp, def);
        assertEquals(enemstr, eng1.toString(), "toString get correct the data of the enemy?");
        assertNotEquals(eng3.toString(), eng1.toString(), "Is the data of 2 different intances equal?");
        assertEquals(eng2.toString(), eng3.toString(), "Is the data of 2 equal intances equal?");
    }
}