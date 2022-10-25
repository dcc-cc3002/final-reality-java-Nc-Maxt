package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnifeTest {
    private Knife k1;
    private Knife k2;
    private Knife k3;
    private Staff st0;
    private Staff st1;

    @BeforeEach
    void setUp() {
        this.k1 = new Knife("DemonKiller", 10, 5);
        this.k2 = new Knife("Moon Knife", 3, 6);
        this.k3 = new Knife("Moon Knife", 3, 6);
        this.st0 = new Staff("Demon invoquer", 3, 6);
        this.st1 = new Staff("Moon Knife", 3, 6);
    }
    @Test
    void testEquals() {
        assertTrue(k3.equals(k2),"Two different instances with equal data should be equals");
        assertTrue(k2.equals(k3),"Equal should be symmetric");
        assertTrue(k1.equals(k1),"the same instances should be equal to itself" );
        assertFalse(k2.equals(k1),"Two different instances with different data shouldn´t be equals" );
        assertFalse(k1.equals(st0), "Two different Objects should be different");
        assertFalse(k1.equals(st1), "Two different Objects with same data should be different");
    }

    @Test
    void testToString() {
        String name = k3.getName();
        int Dmg = k3.getDamage();
        int weight = k3.getWeight();
        String knfstr = "Knife{name='%s', damage=%d, weight=%d}"
                .formatted(name, Dmg, weight);
        assertEquals(knfstr,k3.toString(), "toString get correct the data of the Knife?");
        assertNotEquals(k1.toString(), k3.toString(), "The string data of Two different intances with different data should be diferent");
        assertEquals(k2.toString(), k3.toString(), "The string data of Two different intances with equal data should be equal");
    }
}