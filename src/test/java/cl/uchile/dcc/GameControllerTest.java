package cl.uchile.dcc;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.Controller.GameController;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.magic.bmgc.FireSpell;
import cl.uchile.dcc.finalreality.model.magic.bmgc.ThunderSpell;
import cl.uchile.dcc.finalreality.model.magic.wmgc.CureWounds;
import cl.uchile.dcc.finalreality.model.magic.wmgc.ParalyzeSpell;
import cl.uchile.dcc.finalreality.model.magic.wmgc.PoisonSpell;
import cl.uchile.dcc.finalreality.model.weapon.magical.Staff;
import cl.uchile.dcc.finalreality.model.weapon.nomagical.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

  private BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private GameController gm = new GameController(772559217);
  private BlackMage bm_3 = gm.createBlackMage("Pouker");
  private Engineer eng0 = gm.createEngineer("Azazel");
  private Knight knt3 = gm.createKnight("Hellmont");
  private Thief t0 = gm.createThief("Bas");
  private WhiteMage wm2 = gm.createWhiteMage("Simon");
  private Enemy badg = gm.createEnemy("Steve");
  private Enemy enem3 = gm.createEnemy("Harvey");


  @BeforeEach
  void setUp() {
    wm2.setCurrentMp(wm2.getMaxMp());
    bm_3.setCurrentMp(bm_3.getMaxMp());
  }

  @Test
  void setseedcorrect() {
    assertEquals(gm.getseed(), 772559217, "when used a seed it must be exaclty the same");
    Enemy enem3_1 = new Enemy("Harvey", 47, 505, 120, 37, queue);
    assertEquals(enem3_1, enem3);
    Enemy badg2 = new Enemy("Steve", 25, 541, 110, 40, queue);
    assertEquals(badg2, badg);
    BlackMage bm2 = new BlackMage("Pouker", 94, 88, 84, queue);
    assertEquals(bm2, bm_3);
    WhiteMage wm12 = new WhiteMage("Simon", 129, 159, 68, queue);
    assertEquals(wm12, wm2);
    Engineer en01 = new Engineer("Azazel", 224, 92, queue);
    assertEquals(en01, eng0);
    Knight kng3 = new Knight("Hellmont", 371, 151, queue);
    assertEquals(kng3, knt3);
    Thief tfs = new Thief("Bas", 171, 51, queue);
    assertEquals(tfs, t0);
  }

  @Test
  void setseedcorrect2() {
    Staff bmst = new Staff("Common Staff", 21, 36, 11);
    assertEquals(bmst, bm_3.getEquippedWeapon());
    Staff wmst = new Staff("Common Staff", 20, 36, 10);
    assertEquals(wmst, wm2.getEquippedWeapon());
    Axe engax = new Axe("Common Axe", 34, 43);
    assertEquals(engax, eng0.getEquippedWeapon());
    Sword knsw = new Sword("Common Sword", 36, 20);
    assertEquals(knsw, knt3.getEquippedWeapon());
    Knife tfkn = new Knife("Common Knife", 12, 6);
    assertEquals(tfkn, t0.getEquippedWeapon());
  }


  @Test
  void attack() {
    gm.nextchar();
    assertTrue(t0.isActive(), "Actual character should be Active ");
    assertNotEquals(null, gm.getActualchar(), "after using for firs time nextchar, this should have a gamecharacter");
    gm.attack(gm.getActualchar(), badg);

    GameCharacter st2 = gm.getActualchar();
    assertTrue(st2.isActive(), "Actual character should be Active ");
    gm.attack(st2, badg);
    assertTrue(st2.isInactive(), "After attack a character should be Inactive ");

    GameCharacter st3 = gm.getActualchar();
    assertTrue(st3.isActive(), "Actual character should be Active ");
    gm.attack(st3, badg);
    assertTrue(st3.isInactive(), "After attack a character should be Inactive ");

    GameCharacter st4 = gm.getActualchar();
    assertTrue(st4.isActive(), "Actual character should be Active ");
    gm.attack(st4, badg);
    assertTrue(st4.isInactive(), "After attack a character should be Inactive ");

    GameCharacter st5 = gm.getActualchar();
    assertTrue(st5.isActive(), "Actual character should be Active ");
    gm.attack(st5, badg);
    assertTrue(st5.isInactive(), "After attack a character should be Inactive ");
  }

  @RepeatedTest(20)
  void useMagicFire() {
    bm_3.toActive();
    gm.setspell(bm_3, new FireSpell());
    gm.useMagic(bm_3, badg);
    int acthp = badg.getCurrentHp();
    assertNotEquals(acthp, badg.getMaxHp(), "");
    if (badg.isBurning()) {
      badg.toActive();
      assertTrue(badg.isBurning(), "");
      assertNotEquals(badg.getCurrentHp(), acthp, "When recieve a thunder spell the Hp should decrease");
    }
  }

  @RepeatedTest(20)
  void useMagicThunder() {
    bm_3.toActive();
    gm.setspell(bm_3, new ThunderSpell());
    gm.useMagic(bm_3, badg);
    assertNotEquals(badg.getCurrentHp(), badg.getMaxHp(), "When recieve a thunder spell the Hp should decrease");
    if (badg.isParalyzed()) {
      badg.toActive();
      assertFalse(badg.isParalyzed(), "When burning a character should lose Hp when its their turn");
      assertTrue(badg.isNormal(), "When burning a character should lose Hp when its their turn");
    }
  }

  @Test
  void useMagicParalyzed() {
    wm2.toActive();
    gm.setspell(wm2, new ParalyzeSpell());
    gm.useMagic(wm2, badg);
    badg.toActive();
    assertTrue(badg.isInactive(), "When burning a character should lose Hp when its their turn");
  }

  @Test
  void useMagicPoison() {
    wm2.toActive();
    gm.setspell(wm2, new PoisonSpell());
    gm.useMagic(wm2, badg);
    assertEquals(badg.getCurrentHp(), badg.getMaxHp(), "When poisoned a character should loose Hp when active");
    badg.toActive();
    assertNotEquals(badg.getCurrentHp(), badg.getMaxHp(), "When poisoned a character should loose Hp when active");
  }

  @Test
  void WrongMagicequippments() {
    GameController gm0 = new GameController();
    BlackMage bm = gm0.createBlackMage("Andres");
    Enemy am = gm0.createEnemy("Manu");
    gm0.nextchar();
    gm0.setspell(bm, new CureWounds());
    assertTrue(bm.isActive(), "When trying to set a Spell thats not for the Class the turn shouldn't end");
    gm0.setspell(bm, new PoisonSpell());
    assertTrue(bm.isActive(), "When trying to set a Spell thats not for the Class the turn shouldn't end");
    gm0.setspell(bm, new ParalyzeSpell());
    assertTrue(bm.isActive(), "When trying to set a Spell thats not for the Class the turn shouldn't end");
  }

  @Test
  void WrongMagicequippments2() {
    GameController gm0 = new GameController();
    WhiteMage wm = gm0.createWhiteMage("Miguel");
    Enemy am = gm0.createEnemy("Manu");
    gm0.nextchar();
    gm0.setspell(wm, new FireSpell());
    assertTrue(wm.isActive(), "When trying to set a Spell thats not for the Class the turn shouldn't end");
    gm0.setspell(wm, new ThunderSpell());
    assertTrue(wm.isActive(), "When trying to set a Spell thats not for the Class the turn shouldn't end");
  }

  @Test
  void Wrongequippments() {
    GameController gm0 = new GameController();
    WhiteMage wm = gm0.createWhiteMage("Miguel");
    Enemy am = gm0.createEnemy("Manu");
    gm0.nextchar();
    gm0.equip(wm, gm.createBow("Common Bow"));
    assertTrue(wm.isActive(), "When trying to equip a Weapon thats not for the Class the turn shouldn't end");
    gm0.equip(wm, gm.createAxe("Common Axe"));
    assertTrue(wm.isActive(), "When trying to equip a Weapon thats not for the Class the turn shouldn't end");
    gm0.equip(wm, gm.createSword("Common Sword"));
    assertTrue(wm.isActive(), "When trying to equip a Weapon thats not for the Class the turn shouldn't end");
    gm0.equip(wm, gm.createKnife("Common Knife"));
    assertTrue(wm.isActive(), "When trying to equip a Weapon thats not for the Class the turn shouldn't end");
  }

  @Test
  void onPlayerWin() {
    GameController gm1 = new GameController();
    WhiteMage lc = gm1.createWhiteMage("Claudio");
    Enemy xa = gm1.createEnemy("Axel");
    Enemy am = gm1.createEnemy("Manu");
    am.reduceHp(am.getMaxHp()-1);
    xa.reduceHp(xa.getMaxHp()-1);
    gm1.nextchar();
    System.out.println(gm1.getActualchar());
    gm1.setspell(lc, new PoisonSpell());
    assertTrue(lc.isActive(), "When setting a Spell the main state should still be Active");
    gm1.useMagic(lc, am);
    gm1.attack(gm1.getActualchar(), lc);
    gm1.attack(lc, xa);
  }


  @Test
  void onEnemyWin() {
    GameController gm2 = new GameController();
    Enemy en2 = gm2.createEnemy("Marco");
    WhiteMage wm2 = gm2.createWhiteMage("Claudio");
    wm2.reduceHp(wm2.getMaxHp() - 1);
    gm2.nextchar();
    gm2.attack(gm2.getActualchar(), en2);
    if (en2.isActive()) {
      gm2.attack(gm2.getActualchar(), wm2);
      assertTrue(wm2.isDead(), "When Killed a character must be in Dead State" );
    }
    assertEquals(gm2.getWinner(), "Enemy Wins", "When Enemy wins the winner must be the Enemy");
  }
}