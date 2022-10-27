package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AxeTest extends BowTest {
    private Axe a1 = new Axe("DemonKiller", 10, 5);
    protected Axe a2 = new Axe("DemonKiller", 10, 5);
    private Axe a3 = new Axe("Copper Axe", 1, 3);
    private Bow b01 = new Bow("Large Bow", 34, 15);
    private Bow b11 = new Bow("Large Bow", 34, 15);

    @Test
    void testEquals() {
        assertTrue(a1.equals(a2),"Two different instances with equal data should be equals");
        assertTrue(a2.equals(a1),"Equal should be symmetric");
        assertTrue(a3.equals(a3),"the same instances should be equal to itself" );
        assertFalse(a2.equals(a3),"Two different instances with different data shouldn´t be equals" );
        assertFalse(a1.equals(b01), "Two different Objects should be different");
        assertFalse(a1.equals(b11), "Two different Objects with same data should be different");
    }

    @Test
    void testToString() {
        String name = a3.getName();
        int Dmg = a3.getDamage();
        int weight = a3.getWeight();
        String axstr = "Axe{name='%s', damage=%d, weight=%d}"
                .formatted(name, Dmg, weight);
        assertEquals(axstr,a3.toString(), "toString get correct the data of the Axe?");
        assertNotEquals(a1.toString(), a3.toString(), "The string data of Two different intances with different data should be diferent");
        assertEquals(a2.toString(), a1.toString(), "The string data of Two different intances with equal data should be equal");
    }
}