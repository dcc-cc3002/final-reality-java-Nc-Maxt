package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.AxeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

public class EquipTests extends AxeTest {
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
    void EquipTestBlackMage() {
        assertNull(bmg3.getEquippedWeapon(), "After created, a character shouldn't have a weapon equipped");
        bmg3.equip(st3);
        assertEquals(st3, bmg3.getEquippedWeapon(), "The weapond equipped should be a Staff called 'Bonk'");
        bmg3.equip(k2);
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped should be a Knife called 'Moon Knife'");
        bmg3.equip(b2);
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped shouldn´t change if the weapon isn´t a Knife or Staff");
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped should be a Knife called 'Moon Knife'");
        bmg3.equip(a2);
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped shouldn´t change if the weapon isn´t a Knife or Staff");
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped should be a Knife called 'Moon Knife'");
        bmg3.equip(s2);
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped shouldn´t change if the weapon isn´t a Knife or Staff");
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped should be a Knife called 'Moon Knife'");
    }

    @Test
    void EquipTestWhiteMage() {
        assertNull(wm3.getEquippedWeapon(), "After created, a character shouldn't have a weapon equipped");
        wm3.equip(st3);
        assertEquals(st3, wm3.getEquippedWeapon(), "The weapond equipped should be a Staff called 'Bonk'");
        wm3.equip(k2);
        assertNotEquals(k2, wm3.getEquippedWeapon(), "The weapond equipped shouldn't be a Knife");
        assertEquals(st3, wm3.getEquippedWeapon(), "The weapond equipped should be a Staff called 'Bonk'");
        wm3.equip(b2);
        assertNotEquals(b2, wm3.getEquippedWeapon(), "The weapond equipped shouldn´t change if the weapon isn´t a Staff");
        assertEquals(st3, wm3.getEquippedWeapon(), "The weapond equipped should be a Staff called 'Bonk'");
        wm3.equip(a2);
        assertNotEquals(a2, wm3.getEquippedWeapon(), "The weapond equipped shouldn´t change if the weapon isn´t a Staff");
        assertEquals(st3, wm3.getEquippedWeapon(), "The weapond equipped should be a Staff called 'Bonk'");
        wm3.equip(s2);
        assertNotEquals(s2, wm3.getEquippedWeapon(), "The weapond equipped shouldn´t change if the weapon isn´t a Staff");
        assertEquals(st3, wm3.getEquippedWeapon(), "The weapond equipped should be a Staff called 'Bonk'");
    }
    @Test
    void EquipTestEngineering() {
        assertNull(eng3.getEquippedWeapon(), "After created, a character shouldn't have a weapon equipped");
        eng3.equip(st3);
        assertNotEquals(st3, eng3.getEquippedWeapon(), "The weapond equipped shouldn't change if the weapon isn't a Bow or Axe");
        assertNull(eng3.getEquippedWeapon(), "The weapond equipped should be null");
        eng3.equip(a2);
        assertEquals(a2, eng3.getEquippedWeapon(), "The weapond equipped should be an Axe called 'DemonKiller'");
        eng3.equip(k2);
        assertNotEquals(k2, eng3.getEquippedWeapon(), "The weapond equipped shouldn't change if the weapon isn't a Bow or Axe");
        assertEquals(a2, eng3.getEquippedWeapon(), "The weapond equipped shouldn be an Axe called 'DemonKiller'");
        eng3.equip(b2);
        assertEquals(b2, eng3.getEquippedWeapon(), "The weapond equipped should be a Bow called 'Large Bow'");
        eng3.equip(s2);
        assertNotEquals(s2, eng3.getEquippedWeapon(), "The weapond equipped shouldn't change if the weapon isn't a Bow or Axe");
        assertEquals(b2, eng3.getEquippedWeapon(), "The weapond equipped should be a Bow called 'Large Bow'");
    }
    @Test
    void EquipTestKnight() {
        assertNull(knt3.getEquippedWeapon(), "After created, a character shouldn't have a weapon equipped");
        knt3.equip(st3);
        assertNotEquals(st3, knt3.getEquippedWeapon(), "The weapond equipped shouldn't change if the weapon isn't a Sword, Axe or Knife");
        assertNull(knt3.getEquippedWeapon(), "The weapond equipped should be null");
        knt3.equip(a2);
        assertEquals(a2, knt3.getEquippedWeapon(), "The weapond equipped should be an Axe called 'DemonKiller'");
        knt3.equip(k2);
        assertEquals(k2, knt3.getEquippedWeapon(), "The weapond equipped should be a Knife called 'Moon Knife'");
        knt3.equip(b2);
        assertNotEquals(b2, knt3.getEquippedWeapon(), "The weapond equipped shouldn't change if the weapon isn't a Sword, Axe or Knife");
        assertEquals(k2, knt3.getEquippedWeapon(), "The weapond equipped should be a Knife called 'Moon Knife'");
        knt3.equip(s2);
        assertEquals(s2, knt3.getEquippedWeapon(), "The weapond equipped shouldn't change if the weapon isn't a Sword, Axe or Knife");
    }

    @Test
    void EquipTestThief() {
        assertNull(t3.getEquippedWeapon(), "After created, a character shouldn't have a weapon equipped");
        t3.equip(s2);
        assertEquals(s2, t3.getEquippedWeapon(), "The weapond equipped should be a Sword called 'Longsword'");
        t3.equip(st3);
        assertNotEquals(st3, t3.getEquippedWeapon(), "The weapond equipped shouldn't change if the weapon isn't a Sword or Knife");
        assertEquals(s2, t3.getEquippedWeapon(), "The weapond equipped should be a Sword called 'Longsword'");
        t3.equip(a2);
        assertNotEquals(a2, t3.getEquippedWeapon(), "The weapond equipped shouldn't change if the weapon isn't a Sword or Knife'");
        assertEquals(s2, t3.getEquippedWeapon(), "The weapond equipped should be a Sword called 'Longsword'");
        t3.equip(k2);
        assertEquals(k2, t3.getEquippedWeapon(), "The weapond equipped should be a Knife called 'Moon Knife'");
        t3.equip(b2);
        assertEquals(b2, t3.getEquippedWeapon(), "The weapond equipped should be a Bow called 'Large Bow'");
    }

}
