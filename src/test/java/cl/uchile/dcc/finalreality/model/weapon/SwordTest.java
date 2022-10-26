package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class SwordTest {
    private Sword s1 = new Sword("Greatsword", 34, 15);
    private Sword s2 = new Sword("Longsword", 10, 5);
    private Sword s3 = new Sword("Longsword", 10, 5);
    private Bow b01 = new Bow("Large Bow", 34, 15);
    private Bow b11 = new Bow("Longsword", 10, 5);

    @Test
    void testEquals() {
        assertTrue(s3.equals(s2),"Two different instances with equal data should be equals");
        assertTrue(s2.equals(s3),"Equal should be symmetric");
        assertTrue(s1.equals(s1),"the same instances should be equal to itself" );
        assertFalse(s2.equals(s1),"Two different instances with different data shouldn´t be equals" );
        assertFalse(s1.equals(b01), "Two different Objects should be different");
        assertFalse(s1.equals(b11), "Two different Objects with same data should be different");
    }

    @Test
    void testToString() {
        String name = s3.getName();
        int Dmg = s3.getDamage();
        int weight = s3.getWeight();
        String swdstr = "Sword{name='%s', damage=%d, weight=%d}"
                .formatted(name, Dmg, weight);
        assertEquals(swdstr,s3.toString(), "toString get correct the data of the Sword?");
        assertNotEquals(s1.toString(), s3.toString(), "The string data of Two different intances with different data should be diferent");
        assertEquals(s2.toString(), s3.toString(), "The string data of Two different intances with equal data should be equal");
    }
}