package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaffTest extends SwordTest {
    private Staff st1 = new Staff("Demon invoquer", 3, 6);
    private Staff st2 = new Staff("Bonk", 1000, 2);
    protected Staff st3 = new Staff("Bonk", 1000, 2);
    private Sword s01 = new Sword("Greatsword", 34, 15);
    private Sword s11 = new Sword("Bonk", 1000, 2);

    @Test
    void testEquals() {
        assertTrue(st3.equals(st2),"Two different instances with equal data should be equals");
        assertTrue(st2.equals(st3),"Equal should be symmetric");
        assertTrue(st1.equals(st1),"the same instances should be equal to itself" );
        assertFalse(st2.equals(st1),"Two different instances with different data shouldn´t be equals" );
        assertFalse(st1.equals(s01), "Two different Objects should be different");
        assertFalse(st3.equals(s11), "Two different Objects with same data should be different");

    }

    @Test
    void testToString() {
        String name = st3.getName();
        int Dmg = st3.getDamage();
        int weight = st3.getWeight();
        String swdstr = "Staff{name='%s', damage=%d, weight=%d}"
                .formatted(name, Dmg, weight);
        assertEquals(swdstr,st3.toString(), "if pass toString get correct the data of the Staff");
        assertNotEquals(st1.toString(), st3.toString(), "The string data of Two different intances with different data should be diferent");
        assertEquals(st2.toString(), st3.toString(), "The string data of Two different intances with equal data should be equal");

    }
}