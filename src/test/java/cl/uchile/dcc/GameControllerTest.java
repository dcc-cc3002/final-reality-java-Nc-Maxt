package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.Controller.GameController;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

  private GameController gm = new GameController();
  private BlackMage Bm_3 = gm.createBlackMage("Pouker");
  private Engineer eng0 = gm.createEngineer("Azazel");
  private Knight knt3 =  gm.createKnight("Hellmont");
  private Thief t0 = gm.createThief("Bas");
  private WhiteMage wm2 = gm.createWhiteMage("Simon");
  private Enemy badg = gm.createEnemy("Steve");
  private Enemy enem3 = gm.createEnemy("Harvey") ;


  @BeforeEach
  void setUp() {
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