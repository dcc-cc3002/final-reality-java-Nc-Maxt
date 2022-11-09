package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.exceptions.InvalidWeaponEquipException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

public class AxeTest extends BowTest {
    private Axe a1 = new Axe("DemonKiller", 10, 5);
    protected Axe a2 = new Axe("DemonKiller", 10, 5);
    private Axe a3 = new Axe("Copper Axe", 1, 3);
    private Bow b01 = new Bow("Large Bow", 34, 15);
    private Bow b11 = new Bow("Large Bow", 34, 15);
    private BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();
    private BlackMage bmg3;
    private Engineer eng3;
    private Knight knt3;
    private Thief t3;
    private WhiteMage wm3;

    @BeforeEach
    void setUp() {
        bmg3 = new BlackMage("Thomas", 45, 28, 50, queue1);
        eng3 = new Engineer("Mark", 41, 30, queue1);
        knt3 = new Knight("Simon", 90, 70, queue1);
        t3 = new Thief("Mathew", 60, 3, queue1);
        wm3 = new WhiteMage("Thomas", 45, 28, 50, queue1);
    }

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

    @Test
    void testequippedByKnight() {
        a3.equippedByKnight(knt3);
        assertEquals(a3, knt3.getEquippedWeapon(), "The weapond equipped should be an Axe called 'Copper Axe'");
        a2.equippedByKnight(knt3);
        assertEquals(a2, knt3.getEquippedWeapon(), "The weapond equipped should be an Axe called 'DemonKiller'");
        a1.equippedByKnight(knt3);
        assertEquals(a1, knt3.getEquippedWeapon(), "The weapond equipped should be an Axe called 'DemonKiller'");
    }

    @Test
    void testequippedByEngineer() {
        a3.equippedByEngineer(eng3);
        assertEquals(a3, eng3.getEquippedWeapon(), "The weapond equipped should be a Axe called 'Copper Axe'");
        a2.equippedByEngineer(eng3);
        assertEquals(a2, eng3.getEquippedWeapon(), "The weapond equipped should be a Axe called 'DemonKiller'");
        a1.equippedByEngineer(eng3);
        assertEquals(a1, eng3.getEquippedWeapon(), "The weapond equipped should be a Axe called 'DemonKiller'");
    }

    @Test
    void testequippedByThief() {
        assertThrows(InvalidWeaponEquipException.class,
            () -> a3.equippedByThief(t3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> a2.equippedByThief(t3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> a1.equippedByThief(t3));
    }

    @Test
    void testequippedByBlackMage() {
        assertThrows(InvalidWeaponEquipException.class,
            () -> a3.equippedByBlackMage(bmg3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> a2.equippedByBlackMage(bmg3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> a1.equippedByBlackMage(bmg3));
    }

    @Test
    void testequippedByWhiteMage() {
        assertThrows(InvalidWeaponEquipException.class,
            () -> a3.equippedByWhiteMage(wm3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> a2.equippedByWhiteMage(wm3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> a1.equippedByWhiteMage(wm3));
    }
}