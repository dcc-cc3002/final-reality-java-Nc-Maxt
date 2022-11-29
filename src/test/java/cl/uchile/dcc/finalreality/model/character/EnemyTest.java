package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {
    private BlockingQueue<GameCharacter> queue1;
    private Enemy enem1 = new Enemy("Steven", 50, 32, 10, 4 ,queue1);
    private Enemy enem2 = new Enemy("Steven", 50, 32, 10, 4,queue1);
    private Enemy enem3 = new Enemy("Steven", 80, 502, 2, 12,queue1);
    private Enemy enem4 = new Enemy("Stif", 40, 19, 40, 42,queue1);
    private Engineer eng0 = new Engineer("Steven", 80, 502, queue1);
    private Engineer eng3 = new Engineer("Mark", 41, 30, queue1);

    @BeforeEach
    void setUp() {
        this.queue1 =  new LinkedBlockingQueue<>();
        enem4 = new Enemy("Stif", 40, 19, 40, 42,queue1);
    }

    @Test
    void testequals() {
        assertTrue(enem4.equals(enem4),"The same instances should be equal to itself" );
        assertTrue(enem1.equals(enem2),"Two different instances with equal data should be equals");
        assertTrue(enem2.equals(enem1),"Equal should be symmetric");
        assertFalse(enem4.equals(enem3),"Two different instances with different data shouldn´t be equals" );
        assertFalse(enem2.equals(eng3), "Two different Objects should be different");
        assertFalse(enem3.equals(eng0), "Two different Objects with same data should be different");
    }

    @Test
    void testToString() {
        assertEquals(enem4.toString(), enem4.toString(), "toString get correct the data of the enemy?");
        assertNotEquals(enem3.toString(), enem4.toString(), "Is the data of 2 different intances equal?");
        assertEquals(enem3.toString(), enem3.toString(), "Is the data of 2 equal intances equal?");
    }

    @Test
    void testResolutionExceptioninConstructors() {
        Enemy en0_test = new Enemy("Elias", -3, 64, 32,12 ,queue1);
        assertNotEquals(-3, en0_test.getWeight(), "Weight shouldn´t be negative even if given a negative to the constructor");
        Enemy en1_test = new Enemy("Isaias", 64, -3, 32, 14,queue1);
        assertNotEquals(-3, en1_test.getMaxHp(), "MaxHp shouldn´t be negative even if given a negative to the constructor");
        Enemy en2_test = new Enemy("Lucy", 42, 0, 10, 14,queue1);
        assertNotEquals(0, en2_test.getMaxHp(), "MaxHp shouldn´t be 0 if it's a new character even if given 0 to the constructor");
        Enemy en3_test = new Enemy("Fer", 13, 13, -10, 28, queue1);
        assertNotEquals(-10, en3_test.getDefense(), "Defense Shouldn´t be negative even if given a negative to the constructor");

        Enemy en4_test = new Enemy("Neks", 42, 12, 10, 3,queue1);
        assertNotEquals(3, en4_test.getDamage(), "Attack shouldn´t be lower than 5 even if given a lower number to the constructor");
        Enemy en5_test = new Enemy("Lemmon", 13, 13, -10, 28, queue1);
        assertNotEquals(-10, en5_test.getDamage(), "Defense Shouldn´t be negative even if given a negative to the constructor");
    }

    @Test
    void testResolutionExceptioninHp() {
        enem4.setCurrentHp(-10);
        assertNotEquals(-10,enem4.getCurrentHp(), "The current Hp of a Character shoul't be negative");
        enem4.setCurrentHp(enem4.getMaxHp()+10);
        assertNotEquals(enem4.getMaxHp()+10,enem4.getCurrentHp(), "The current Hp of a Character shoul't be higher than it´s maxHp");
        enem4.setCurrentHp(1);
        assertEquals(1, enem4.getCurrentHp(), "Every change in the currentHP, that's between 0 and maxHp should change correctly");
    }
}