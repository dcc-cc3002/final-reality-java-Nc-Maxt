package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestingStates {

  private BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

  private BlackMage Bm_3 = new BlackMage("Kvote", 435, 13, 130, queue);
  private Engineer eng0 = new Engineer("Steven", 80, 502, queue);
  private Knight knt3 = new Knight("Simon", 90, 70, queue);
  private Thief t0 = new Thief("Simon", 90, 70, queue);
  private WhiteMage wm2 = new WhiteMage("Azrael", 20, 35, 40, queue);
  private Enemy badg = new Enemy("Stif", 40, 234, 20, 26, queue);
  private Enemy enem3 = new Enemy("Steven", 80, 502, 2, 12,queue);

}
