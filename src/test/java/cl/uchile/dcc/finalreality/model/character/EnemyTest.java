package cl.uchile.dcc.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    private BlockingQueue<GameCharacter> queue1;
    private Enemy enem1;
    private Enemy enem2;
    private Enemy enem3;
    private Enemy enem4;

    @BeforeEach
    void setUp() {
        this.queue1 =  new LinkedBlockingQueue<>();
        this.enem1 = new Enemy("Steven", 50, 32, 10, queue1);
        this.enem2 = new Enemy("Steven", 50, 32, 10, queue1);
        this.enem3 = new Enemy("Steven", 80, 502, 2, queue1);
        this.enem4 = new Enemy("Stif", 40, 19, 40, queue1);
    }
    @Test
    void testgetWeight() {
        assertEquals(50, enem1.getWeight(), "The weight of enem1 should be 50");
        assertNotEquals(enem3.getWeight(), enem2.getWeight(), "The weight of enem2 and enem3 should be different");
        assertEquals(80, enem3.getWeight(), "The weight of enem3 should be 80");
        assertEquals(40, enem4.getWeight(), "The weight of enem4 should be 40");
    }

    @Test
    void testequals() {
        assertTrue(enem4.equals(enem4),"Are two same instances equals?");
        assertTrue(enem1.equals(enem2),"Are two different instances with same data equal?");
        assertTrue(enem1.equals(enem2),"Is equals symmetric?");
        assertFalse(enem4.equals(enem3),"Are two different instances equal?");
    }
    @Disabled
    @Test
    void testGetters() {
        assertEquals(enem1.getName(),enem1.getName(), "Are the names of the same instance equal?");
        assertEquals(enem2.getCurrentHp(),enem2.getCurrentHp(), "Are the currentHp of the same instance equal?");
        assertEquals(enem3.getMaxHp(),enem3.getMaxHp(), "Are the maxHp of the same instance equal?");
        assertEquals(enem4.getDefense(),enem4.getDefense(), "Are the defense of the same instance equal?");
        assertEquals(enem1.getWeight(),enem1.getWeight(), "Are the weight of the same instance equal?");
        assertNotEquals(enem2.getName(),enem3.getName(), "Are the names of the same instance equal?");
        assertNotEquals(enem3.getCurrentHp(),enem4.getCurrentHp(), "Are the currentHp of the same instance equal?");
        assertNotEquals(enem4.getMaxHp(),enem1.getMaxHp(), "Are the maxHp of the same instance equal?");
        assertNotEquals(enem1.getDefense(),enem2.getDefense(), "Are the defense of the same instance equal?");
        assertNotEquals(enem2.getWeight(),enem3.getWeight(), "Are the weight of the same instance equal?");

    }
    @Test
    void testToString() {
        String name = enem4.getName();
        int Hp = enem4.getCurrentHp();
        int maxHp = enem4.getMaxHp();
        int def = enem4.getDefense();
        int weight = enem4.getWeight();
        String enemstr = "Enemy{name='%s', currentHp=%d, maxHp=%d, defense=%d, weight=%d}"
                .formatted(name, Hp, maxHp, def, weight);;
        assertEquals(enemstr,enem4.toString(), "toString get correct the data of the enemy?");
        assertNotEquals(enem3.toString(), enem4.toString(), "Are equal the data string of 2 different intances?");
        assertEquals(enem3.toString(), enem3.toString(), "Are equal the data string of 2 equal intances?");
    }
}