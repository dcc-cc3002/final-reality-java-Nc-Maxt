package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.AxeTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

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
    Bm_3.setCurrentHp(Bm_3.getMaxHp());
    eng0.setCurrentHp(eng0.getMaxHp());
    knt3.setCurrentHp(knt3.getMaxHp());
    t0.setCurrentHp(t0.getMaxHp());
    wm2.setCurrentHp(wm2.getMaxHp());
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
    Bm_3.attack(badg);
    eng0.attack(badg);
    knt3.attack(badg);
    t0.attack(badg);
    enem3.attack(knt3);
    badg.attack(Bm_3);
    wm2.attack(enem3);
  }
}
