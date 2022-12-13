package cl.uchile.dcc.finalreality.model.Magic;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.states.alteredstate.NormalState;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.bmgc.FireSpell;
import cl.uchile.dcc.finalreality.model.magic.bmgc.ThunderSpell;
import cl.uchile.dcc.finalreality.model.magic.wmgc.CureWounds;
import cl.uchile.dcc.finalreality.model.magic.wmgc.ParalyzeSpell;
import cl.uchile.dcc.finalreality.model.magic.wmgc.PoisonSpell;
import cl.uchile.dcc.finalreality.model.weapon.AxeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MagicTests extends AxeTest {
  private BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private BlackMage Bm_3 = new BlackMage("Kvote", 435, 13, 130, queue);
  private Engineer eng0 = new Engineer("Steven", 80, 502, queue);
  private Knight knt3 = new Knight("Simon", 90, 70, queue);
  private Thief t0 = new Thief("Simon", 90, 70, queue);
  private WhiteMage wm2 = new WhiteMage("Azrael", 20, 35, 80, queue);
  private Enemy badg = new Enemy("Stif", 40, 234, 20, 26, queue);
  private Enemy enem3 = new Enemy("Steven", 80, 502, 2, 12,queue);


  @BeforeEach
  void setUp() {
    badg.setAlteredState(new NormalState());
    enem3.setAlteredState(new NormalState());
    badg.setCurrentHp(badg.getMaxHp());
    enem3.setCurrentHp(enem3.getMaxHp());
    Bm_3.setCurrentHp(Bm_3.getMaxHp());
    Bm_3.setCurrentMp(Bm_3.getMaxMp());
    wm2.setCurrentMp(wm2.getMaxMp());
    Bm_3.equip(st3);
    wm2.equip(st3);
  }

  @Test
  void useSpellsTest() throws UnsupportedEquipmentException, InvalidStatValueException {
    Bm_3.setSpell(new FireSpell());
    Bm_3.useSpell(badg);
    assertEquals(Bm_3.getMaxMp()-15 , Bm_3.getCurrentMp(), "Use FireSpell should only cost 15 maná");
    int curhp = badg.getCurrentHp();
    assertNotEquals(badg.getMaxHp(), curhp, "After being hitted by a FireSpell the Hp should be lower");
    Bm_3.setSpell(new ThunderSpell());
    Bm_3.useSpell(badg);
    assertEquals(Bm_3.getMaxMp()-30 , Bm_3.getCurrentMp(), "Use ThunderSpell should only cost 15 maná");
    assertNotEquals(curhp, badg.getCurrentHp(), "After being hitted by a ThunderSpell the Hp should be lower than before it");
    Bm_3.setCurrentHp(100);
    wm2.setSpell(new CureWounds());
    wm2.useSpell(Bm_3);
    assertEquals(wm2.getMaxMp()-15 ,wm2.getCurrentMp(), "Use HealingSpell should only cost 15 maná");
    assertNotEquals(100, Bm_3.getCurrentHp(), "Use HealingSpell on a Companion with less tha maximum health should increase it");
    wm2.setSpell(new ParalyzeSpell());
    wm2.useSpell(enem3);
    assertTrue(enem3.isParalyzed(), "After being Paralyzed by ParalyzeSpell the state should be Paralyzed");
    assertEquals(wm2.getMaxMp()-40 ,wm2.getCurrentMp(), "Use ParalyzeSpell should only cost 25 maná");
    wm2.setSpell(new PoisonSpell());
    wm2.useSpell(enem3);
    assertTrue(enem3.isPoisoned(), "After being Poisoned by PoisonSpell the state should be Poisoned");
    assertEquals(wm2.getMaxMp()-80 ,wm2.getCurrentMp(), "Use PoisonSpell should only cost 40 maná");
  }

  @Test
  void SpellWithEffectTest() {
    ThunderSpell thspll = new ThunderSpell();
    FireSpell frspll = new FireSpell();
    thspll.castspell(badg, 18,50);
    assertTrue(badg.isNormal());
    thspll.castspell(badg, 18, 71);
    assertTrue(badg.isParalyzed());
    frspll.castspell(enem3,18,80);
    assertTrue(enem3.isNormal());
    frspll.castspell(enem3, 18, 90);
    assertTrue(enem3.isBurning());
  }


  @Test
  void borderHealTest() throws UnsupportedEquipmentException, InvalidStatValueException {
    eng0.setCurrentHp(-13);
    wm2.setSpell(new CureWounds());
    assertThrows(InvalidStatValueException.class, () -> wm2.useSpell(eng0),
        "Trying to heal a character 0 health should fail");
    assertEquals(wm2.getMaxMp(),wm2.getCurrentMp(), "When a spell can't be cast the Mp shouln't change ");
    assertEquals(0, eng0.getCurrentHp(), "After dead a character shouldn't be healed by HealingSpell");
    assertThrows(InvalidStatValueException.class, () -> wm2.useSpell(knt3),
        "Trying to heal a character with maximum health should fail");
    assertEquals(wm2.getMaxMp(),wm2.getCurrentMp(), "When a spell can't be cast the Mp shouln't change");
  }

  @Test
  void Magicexceptions() throws UnsupportedEquipmentException {
    Bm_3.equip(k2);
    Bm_3.setSpell(new FireSpell());
    assertThrows(UnsupportedEquipmentException.class,() -> Bm_3.useSpell(eng0),
        "A weapon thats not part of ChannelingMgWp should fail when castinng a spell");
    assertThrows(UnsupportedEquipmentException.class,() -> Bm_3.setSpell(new CureWounds()),
        "A weapon thats not part of ChannelingMgWp should fail when castinng a spell");
    assertThrows(UnsupportedEquipmentException.class,() -> wm2.setSpell(new FireSpell()),
        "A weapon thats not part of ChannelingMgWp should fail when castinng a spell");
  }

}
