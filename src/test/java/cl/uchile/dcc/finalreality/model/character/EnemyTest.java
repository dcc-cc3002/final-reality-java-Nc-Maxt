package cl.uchile.dcc.finalreality.model.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    private BlockingQueue<GameCharacter> queue1;
    private Enemy enem1;
    private Enemy enem2;
    private Enemy enem3;
    private Enemy enem4;

    @BeforeEach
    void setUp() {
        this.queue1 =  new LinkedBlockingQueue<>();
        this.enem1 = new Enemy("Steven", 50, 32, 10, queue1);
        this.enem2 = new Enemy("Steven", 50, 32, 10, queue1);
        this.enem3 = new Enemy("Steven", 80, 502, 2, queue1);
        this.enem4 = new Enemy("Stif", 40, 19, 40, queue1);
    }

    @Test
    void getWeight() {
    }




    @Test
    void testToString() {
    }
}