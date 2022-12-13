package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.AxeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Attackingeveryone extends AxeTest {
  private BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private BlackMage Bm_3 = new BlackMage("Kvote", 435, 13, 130, queue);
  private Engineer eng0 = new Engineer("Steven", 80, 502, queue);
  private Knight knt3 = new Knight("Simon", 90, 70, queue);
  private Thief t0 = new Thief("Simon", 90, 70, queue);
  private WhiteMage wm2 = new WhiteMage("Azrael", 20, 35, 40, queue);
  private Enemy badg = new Enemy("Stif", 40, 234, 20, 26, queue);
  private Enemy enem3 = new Enemy("Steven", 80, 502, 2, 12,queue);

  @BeforeEach
  void setUp() {
    badg.setCurrentHp(badg.getMaxHp());
    enem3.setCurrentHp(eng0.getMaxHp());
    Bm_3.equip(k2);
    eng0.equip(b2);
    knt3.equip(a2);
    t0.equip(s2);
    wm2.equip(st3);
  }

  @Test
  void testattack() {
    assertEquals(badg.getCurrentHp(), badg.getMaxHp(), "When created the current Hp of a character should be the maxHp");
    Bm_3.attack(badg);
    assertNotEquals(badg.getCurrentHp(),badg.getMaxHp(), "When attacked the Hp should change");
    int badghp = badg.getCurrentHp();
    eng0.attack(badg);
    assertNotEquals(badghp,badg.getCurrentHp(), "When attacked the Hp should change");
    int badghp2 = badg.getCurrentHp();
    knt3.attack(badg);
    assertNotEquals(badghp2,badg.getCurrentHp(), "When attacked the Hp should change");
    int badghp3 = badg.getCurrentHp();
    t0.attack(badg);
    assertNotEquals(badghp3,badg.getCurrentHp(), "When attacked the Hp should change");
    wm2.attack(enem3);
    assertNotEquals(enem3.getCurrentHp(),enem3.getMaxHp(), "When attacked the Hp should change");
    enem3.attack(wm2);
    assertNotEquals(wm2.getCurrentHp(), wm2.getMaxHp(), "When attacked the Hp should change");
  }

}
