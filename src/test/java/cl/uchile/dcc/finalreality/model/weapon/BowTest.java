package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.exceptions.InvalidWeaponEquipException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class BowTest extends KnifeTest {
    private Bow b1 = new Bow("Large Bow", 34, 15);
    protected Bow b2 = new Bow("Large Bow", 34, 15);
    private Bow b3 = new Bow("Bone Bow", 22, 9);
    private Knife k01 = new Knife("DemonKiller", 10, 5);
    private Knife k11 = new Knife("Bone Bow", 22, 9);
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
    void testequippedByEngineer() {
        b3.equippedByEngineer(eng3);
        assertEquals(b3, eng3.getEquippedWeapon(), "The weapond equipped should be a Bow called 'Copper Axe'");
        b2.equippedByEngineer(eng3);
        assertEquals(b2, eng3.getEquippedWeapon(), "The weapond equipped should be a Axe called 'DemonKiller'");
        b1.equippedByEngineer(eng3);
        assertEquals(b1, eng3.getEquippedWeapon(), "The weapond equipped should be a Axe called 'DemonKiller'");
    }

    @Test
    void testequippedByThief() {
        b3.equippedByThief(t3);
        assertEquals(b3, t3.getEquippedWeapon(), "The weapond equipped should be a Axe called 'Copper Axe'");
        b2.equippedByThief(t3);
        assertEquals(b2, t3.getEquippedWeapon(), "The weapond equipped should be a Axe called 'DemonKiller'");
        b1.equippedByThief(t3);
        assertEquals(b1, t3.getEquippedWeapon(), "The weapond equipped should be a Axe called 'DemonKiller'");
    }

    @Test
    void testequippedByBlackMage() {
        assertThrows(InvalidWeaponEquipException.class,
            () -> b3.equippedByBlackMage(bmg3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> b2.equippedByBlackMage(bmg3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> b1.equippedByBlackMage(bmg3));
    }

    @Test
    void testequippedByWhiteMage() {
        assertThrows(InvalidWeaponEquipException.class,
            () -> b3.equippedByWhiteMage(wm3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> b2.equippedByWhiteMage(wm3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> b1.equippedByWhiteMage(wm3));
    }

    @Test
    void testequippedByKnight() {
        assertThrows(InvalidWeaponEquipException.class,
            () -> b3.equippedByKnight(knt3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> b2.equippedByKnight(knt3));
        assertThrows(InvalidWeaponEquipException.class,
            () -> b1.equippedByKnight(knt3));
    }
}