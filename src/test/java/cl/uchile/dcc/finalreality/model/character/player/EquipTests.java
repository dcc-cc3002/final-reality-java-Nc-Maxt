package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class EquipTests extends EngineerTest{
    private BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();

    @BeforeEach
    void setUp() {
        bmg3 = new BlackMage("Thomas", 45, 28, 50, queue1);
        eng3 = new Engineer("Mark", 41, 30, queue1);
        knt3 = new Knight("Simon", 90, 70, queue1);
        wm3 = new WhiteMage("Thomas", 45, 28, 50, queue1);
        t3 = new Thief("Mathew", 60, 3, queue1);
    }

    @Test
    void EquipTestBlackMage() {
        assertNull(bmg3.getEquippedWeapon(), "After created, a character shouldn't have a weapon" +
                " equipped");
        bmg3.equip(st3);
        assertEquals(st3, bmg3.getEquippedWeapon(), "The weapond equipped should be a Staff called 'Bonk'");
        bmg3.equip(k2);
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped should be a Knife called 'Moon Knife'");
        bmg3.equip(b2);
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped shouldn´t change if the weapon isn´t a Knife or Staff");
        bmg3.equip(a2);
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped shouldn´t change if the weapon isn´t a Knife or Staff");
        bmg3.equip(s2);
        assertEquals(k2, bmg3.getEquippedWeapon(), "The weapond equipped shouldn´t change if the weapon isn´t a Knife or Staff");

    }

    @Test
    void EquipTestWhiteMage() {

    }
    @Test
    void EquipTestEngineering() {

    }
    @Test
    void EquipTestKnight() {

    }
    @Test
    void EquipTestThief() {

    }




}
