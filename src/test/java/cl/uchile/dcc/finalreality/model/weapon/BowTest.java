package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowTest {
    private Bow b1;
    private Bow b2;
    private Bow b3;
    private Knife k0;
    private Knife k1;
    @BeforeEach
    void setUp() {
        this.b1 = new Bow("Large Bow", 34, 15);
        this.b2 = new Bow("Large Bow", 34, 15);
        this.b3 = new Bow("Bone Bow", 22, 9);
        this.k0 = new Knife("DemonKiller", 10, 5);
        this.k1 = new Knife("Bone Bow", 22, 9);
    }

    @Test
    void testEquals() {
        assertTrue(b1.equals(b2),"Two different instances with equal data should be equals");
        assertTrue(b2.equals(b1),"Equal should be symmetric");
        assertTrue(b3.equals(b3),"the same instances should be equal to itself" );
        assertFalse(b2.equals(b3),"Two different instances with different data shouldn´t be equals" );
        assertFalse(b1.equals(k0), "Two different Objects should be different");
        assertFalse(b1.equals(k1), "Two different Objects with same data should be different");
    }

    @Test
    void testToString() {
        String name = b3.getName();
        int Dmg = b3.getDamage();
        int weight = b3.getWeight();
        String bowstr = "Bow{name='%s', damage=%d, weight=%d}"
                .formatted(name, Dmg, weight);
        assertEquals(bowstr,b3.toString(), "toString get correct the data of the Bow?");
        assertNotEquals(b1.toString(), b3.toString(), "The string data of Two different intances with different data should be diferent");
        assertEquals(b2.toString(), b1.toString(), "The string data of Two different intances with equal data should be equal");
    }
}