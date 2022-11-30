package cl.uchile.dcc.finalreality.model.States;

import cl.uchile.dcc.finalreality.model.States.BurningState;
import cl.uchile.dcc.finalreality.model.States.NormalState;
import cl.uchile.dcc.finalreality.model.States.ParalyzedState;
import cl.uchile.dcc.finalreality.model.States.PoisonedState;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class TestingStates {

  private BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

  private Enemy badg = new Enemy("Stif", 40, 234, 20, 26, queue);
  private Enemy enem3 = new Enemy("Steven", 80, 502, 2, 12,queue);

  @BeforeEach
  void setUp() {
    badg.setState(new NormalState());
    enem3.setState(new NormalState());
  }

  @Test
  void setState() {
    assertTrue(enem3.isNormal(), "When created an Enemy should be in a Normal State");
    assertFalse(enem3.isParalyzed(), "When created an Enemy shouldn't be in a Paralyzed State");
    assertFalse(enem3.isBurning(), "When created an Enemy shouldn't be in a Burn State");
    assertFalse(enem3.isPoisoned(), "When created an Enemy shouldn't be in a Poisoned State");
    enem3.Burn(10);
    assertFalse(enem3.isNormal(), "When an Enemy changed to Burn State shouldn't be in a Normal State");
    assertFalse(enem3.isParalyzed(), "When an Enemy changed to Burn State shouldn't be in a Paralyzed State");
    assertTrue(enem3.isBurning(), "When an Enemy changed to Burn State should be in a Burn State");
    assertFalse(enem3.isPoisoned(), "When an Enemy changed to Burn State shouldn't be in a Poisoned State");
    enem3.Poison(10);
    assertFalse(enem3.isNormal(), "When an Enemy changed to Posioned State shouldn't be in a Normal State");
    assertFalse(enem3.isParalyzed(), "When an Enemy changed to Posioned State shouldn't be in a Paralyzed State");
    assertFalse(enem3.isBurning(), "When an Enemy changed to Posioned State shouldn't be in a Burn State");
    assertTrue(enem3.isPoisoned(), "When an Enemy changed to Posioned State should be in a Poisoned State");
    enem3.Paralyze();
    assertFalse(enem3.isNormal(), "When an Enemy changed to Paralyzed State shouldn't be in a Normal State");
    assertTrue(enem3.isParalyzed(), "When an Enemy changed to Paralyzed State should be in a Paralyzed State");
    assertFalse(enem3.isBurning(), "When an Enemy changed to Paralyzed State shouldn't be in a Burn State");
    assertFalse(enem3.isPoisoned(), "When an Enemy changed to Paralyzed State shouldn't be in a Poisoned State");
  }

  @Test
  void setStateError() {
    badg.Normal();
    assertTrue(enem3.isNormal(), "When an Enemy try to change from Normal to Normal should end in a Normal State");
    assertFalse(enem3.isParalyzed(), "When an Enemy try to change from Normal to Normal shouldn't be in a Paralyzed State");
    assertFalse(enem3.isBurning(), "When an Enemy try to change from Normal to Normal shouldn't be in a Burn State");
    assertFalse(enem3.isPoisoned(), "When an Enemy try to change from Normal to Normal shouldn't be in a Poisoned State");
    enem3.Burn(10);
    enem3.Burn(10);
    assertFalse(enem3.isNormal(), "When an try to change from Burn to Burn State shouldn't be in a Normal State");
    assertFalse(enem3.isParalyzed(), "When an try to change from Burn to Burn State shouldn't be in a Paralyzed State");
    assertTrue(enem3.isBurning(), "When an try to change from Burn to Burn State should be in a Burn State");
    assertFalse(enem3.isPoisoned(), "When an try to change from Burn to Burn State shouldn't be in a Poisoned State");
    enem3.Poison(10);
    enem3.Poison(10);
    assertFalse(enem3.isNormal(), "When an try to change from Poisoned to Poisoned State shouldn't be in a Normal State");
    assertFalse(enem3.isParalyzed(), "When an try to change from Poisoned to Poisoned State shouldn't be in a Paralyzed State");
    assertFalse(enem3.isBurning(), "When an try to change from Poisoned to Poisoned State shouldn't be in a Burn State");
    assertTrue(enem3.isPoisoned(), "When an try to change from Poisoned to Poisoned State should be in a Poisoned State");
    enem3.Paralyze();
    enem3.Paralyze();
    assertFalse(enem3.isNormal(), "When an try to change from Paralyzed to Paralyzed State shouldn't be in a Normal State");
    assertTrue(enem3.isParalyzed(), "When an try to change from Paralyzed to Paralyzed State should be in a Paralyzed State");
    assertFalse(enem3.isBurning(), "When an try to change from Paralyzed to Paralyzed State shouldn't be in a Burn State");
    assertFalse(enem3.isPoisoned(), "When an try to change from Paralyzed to Paralyzed State shouldn't be in a Poisoned State");
  }

  @Test
  void testchangestates() {
    assertTrue(badg.isNormal(), "When created a Enemy should be in a Normal State");
    badg.Paralyze();
    assertTrue(badg.isParalyzed(), "from Normal to Paralyzed State should change");
    badg.Normal();
    assertTrue(badg.isNormal(), "from Paralyzed to Normal State should change");
    badg.Burn(20);
    assertTrue(badg.isBurning(), "from Normal to Burn State should change");
    badg.Normal();
    assertTrue(badg.isNormal(), "from Burn to Normal State should change");
    badg.Poison(15);
    assertTrue(badg.isPoisoned(), "from Normal to Poisoned State should change");
    badg.Normal();
    assertTrue(badg.isNormal(), "from Poisoned to Normal State should change");
  }

  @Test
  void testchangestates2() {
    assertTrue(enem3.isNormal(), "When created a Enemy should be in a Normal State");
    enem3.Paralyze();
    enem3.Burn(20);
    assertTrue(enem3.isBurning(), "from Paralyzed to Burn State should change");
    enem3.Paralyze();
    assertTrue(enem3.isParalyzed(), "from Burn to Paralyze State should change");
    enem3.Poison(15);
    assertTrue(enem3.isPoisoned(), "from Paralyzed to Poisoned State should change");
    enem3.Paralyze();
    assertTrue(enem3.isParalyzed(), "from Poisoned to Paralyzed State should change");
    enem3.Burn(50);
    enem3.Poison(30);
    assertTrue(enem3.isPoisoned(), "from Burn to Poisoned State should change");
    enem3.Burn(10);
    assertTrue(enem3.isBurning(), "from Poisoned to Burn State should change");
  }





}
