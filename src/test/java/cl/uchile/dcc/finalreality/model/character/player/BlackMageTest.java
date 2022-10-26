package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.AxeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageTest extends AxeTest {
    private BlockingQueue<GameCharacter> queue1;
    BlackMage bmg1 ;
    BlackMage bmg2 ;
    BlackMage bmg3 ;

    @BeforeEach
    void setUp() {
        this.queue1 =  new LinkedBlockingQueue<>();
        BlackMage Bm_1 = new BlackMage("Azrael", 20, 35, 40, queue1);
        BlackMage Bm_2 = new BlackMage("Azrael", 20, 35, 40, queue1);
        BlackMage Bm_3 = new BlackMage("Thomas", 45, 28, 50, queue1);
        System.out.println(queue1);
    }



    @Test
    void testToString1() {
    }
}