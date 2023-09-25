package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.weapon.nomagical.Bow;
import cl.uchile.dcc.finalreality.model.weapon.nomagical.Knife;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BowTest extends KnifeTest {
    private Bow b1 = new Bow("Large Bow", 34, 15);
    protected Bow b2 = new Bow("Large Bow", 34, 15);
    private Bow b3 = new Bow("Bone Bow", 22, 9);
    private Knife k01 = new Knife("DemonKiller", 10, 5);
    private Knife k11 = new Knife("Bone Bow", 22, 9);

    @Test
    void testEquals() {
        assertTrue(b1.equals(b2),"Two different instances with equal data should be equals");
        assertTrue(b2.equals(b1),"Equal should be symmetric");
        assertTrue(b3.equals(b3),"the same instances should be equal to itself" );
        assertFalse(b2.equals(b3),"Two different instances with different data shouldn´t be equals" );
        assertFalse(b1.equals(k01), "Two different Objects should be different");
        assertFalse(b1.equals(k11), "Two different Objects with same data should be different");
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

    @Test
    void testResolutionExceptioninConstructorsbow() {
        Bow b0_test = new Bow("Mcfly", -3, 64);
        assertNotEquals(-3, b0_test.getDamage(), "Damage shouldn´t be negative even if given a negative to the constructor");
        Bow b1_test = new Bow("Mccoffin", 0, 23);
        assertEquals(0, b1_test.getDamage(), "Damage should be 0 if given 0 to the constructor");
        Bow b2_test = new Bow("Lucy", 42, 32);
        assertEquals(42, b2_test.getDamage(), "Damage should be the same as the given to the constructor if it's possitive");
    }

    @Test
    void Magicexceptions() throws UnsupportedEquipmentException {
        assertThrows(UnsupportedEquipmentException.class,() -> b1.getMagicDamage(),
            "A weapon thats not Magical should throw an error when asking its magic damage");
        assertThrows(UnsupportedEquipmentException.class,() -> b2.getMagicDamage(),
            "A weapon thats not Magical should throw an error when asking its magic damage");
        assertThrows(UnsupportedEquipmentException.class,() -> b3.getMagicDamage(),
            "A weapon thats not Magical should throw an error when asking its magic damage");
    }
}