package cl.uchile.dcc.finalreality.model.weapon;


import cl.uchile.dcc.finalreality.model.weapon.magical.Staff;
import cl.uchile.dcc.finalreality.model.weapon.nomagical.Sword;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StaffTest extends SwordTest {
    private Staff st1 = new Staff("Demon invoquer", 3, 4, 6);
    private Staff st2 = new Staff("Bonk", 1000, 10, 2);
    protected Staff st3 = new Staff("Bonk", 1000, 10, 2);
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

    @Test
    void testResolutionExceptioninConstructorsstaff() {
        Staff st0_test = new Staff("Mcfly", -3, 10, 64);
        assertNotEquals(-3, st0_test.getDamage(), "Damage shouldn´t be negative even if given a negative to the constructor");
        Staff st1_test = new Staff("Mccoffin", 0, 5,23);
        assertEquals(0, st1_test.getDamage(), "Damage should be 0 if given 0 to the constructor");
        Staff st2_test = new Staff("Lucy", 42, 6, 32);
        assertEquals(42, st2_test.getDamage(), "Damage should be the same as the given to the constructor if it's possitive");
        Staff st3_test = new Staff("Dondimadon", 10, -10, 64);
        assertNotEquals(-10, st3_test.getMagicDamage(), "MagicDamage shouldn´t be lower than 1 even if given a lower number to the constructor");
        Staff st4_test = new Staff("Mccoffin", 5, 1,23);
        assertEquals(1, st4_test.getMagicDamage(), "MagicDamage should be 1 if given 1 to the constructor");
        Staff st5_test = new Staff("magicbonk", 42, 53, 32);
        assertEquals(53, st5_test.getMagicDamage(), "MagicDamage should be the same as the given to the constructor if it's upper to 1");
    }
}