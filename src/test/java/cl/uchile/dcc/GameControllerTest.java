package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.Controller.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void createGmContrl() {
    GameController ads = new GameController();
    System.out.println(ads.getseed());
    System.out.println(ads.getseed());
    int das = (int) ads.getseed();
    System.out.println(das);
    assertEquals(das, ads.getseed());

  }

  @Test
  void createEngineer() {
  }

  @Test
  void createKnight() {
  }

  @Test
  void createThief() {
  }

  @Test
  void createBlackMage() {
  }

  @Test
  void createWhiteMage() {
  }

  @Test
  void createEnemy() {
  }

  @Test
  void attack() {
  }

  @Test
  void useMagic() {
  }

  @Test
  void waitTurn() {
  }

  @Test
  void onPlayerWin() {
  }

  @Test
  void onEnemyWin() {
  }
}