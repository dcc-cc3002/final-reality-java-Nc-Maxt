package cl.uchile.dcc.finalreality.model.States;

import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.States.MainStates.InactiveState;
import cl.uchile.dcc.finalreality.model.States.alteredState.NormalState;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class TestingMainStates {


  private BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

  private BlackMage bmgs = new BlackMage("Stif", 234, 64, 120, queue);
  private WhiteMage wmgs = new WhiteMage("Henderson", 120, 60, 80, queue);
  private Enemy enem3 = new Enemy("Steven", 80, 502, 2, 12, queue);

  @BeforeEach
  void setUp() {
    bmgs.setMainState(new InactiveState());
    enem3.setMainState(new InactiveState());
  }

  @Test
  void setState() {
    assertTrue(enem3.isInactive(), "When created a Character should be in a Inactive State");
    assertFalse(enem3.isActive(), "When created a Character shouldn't be in a Active State");
    assertFalse(enem3.isDead(), "When created a Character shouldn't be in a Dead State");
    enem3.toActive();
    assertFalse(enem3.isInactive(), "When a Character changed to Active State shouldn't be in a Inactive State");
    assertTrue(enem3.isActive(), "When a Character changed to Active State should be in a Inactive State");
    assertFalse(enem3.isDead(), "When a Character changed to Active State shouldn't be in a Dead State");
    enem3.toDead();
    assertFalse(enem3.isInactive(), "When a Character changed to Dead State shouldn't be in a Inactive State");
    assertFalse(enem3.isActive(), "When a Character changed to Dead State shouldn't be in a Inactive State");
    assertTrue(enem3.isDead(), "When a Character changed to Dead State should be in a Dead State");
  }


  @Test
  void setStateError() {
    assertTrue(bmgs.isInactive(), "When created a Character should be in a Inactive State");
    assertThrows(AssertionError.class,() -> bmgs.toInactive(),
        "When Inactive a character shouldn't change to Inactive State");
    System.out.println(bmgs.getMainState());
    bmgs.toDead();
    assertThrows(AssertionError.class,() -> bmgs.toInactive(),
        "When dead a character shouldn't change to Inactive State");
    System.out.println(bmgs.getMainState());
    assertTrue(wmgs.isInactive(), "When created a Character should be in a Inactive State");
    wmgs.toDead();
    assertThrows(AssertionError.class,() -> bmgs.toActive(),
        "When dead a character shouldn't change to Active State");
    System.out.println(bmgs.getMainState());
    assertTrue(enem3.isInactive(), "When created a Character should be in a Inactive State");
    enem3.toDead();
    assertThrows(AssertionError.class,() -> enem3.toDead(),
        "When dead a character shouldn't change to Dead State");


  }

  @Test
  void testchangestates() {
    assertTrue(bmgs.isInactive(), "When created a Character should be in a Inactive State");
    bmgs.toActive();
    assertTrue(bmgs.isActive(), "from Inactive to Active State should change");
    bmgs.toInactive();
    assertTrue(bmgs.isInactive(), "from Active to Inactive State should change");
    bmgs.toDead();
    assertTrue(bmgs.isDead(), "from Inactive to Dead State should change");
    enem3.toActive();
    assertTrue(enem3.isActive(), "from Active to Active State should change");
    enem3.toActive();
    enem3.toDead();
    assertTrue(bmgs.isDead(), "from Active to Dead State should change");
  }

}
