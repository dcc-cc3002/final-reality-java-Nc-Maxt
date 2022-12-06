package cl.uchile.dcc.finalreality.model.magic.WMgc;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.WhiteMagic;

public class CureWounds extends AbstractWMSpell implements WhiteMagic {

  public CureWounds() {
    super(15);
  }

  @Override
  public void useSpell(Mages mgs, GameCharacter gma, int mgdmg) throws InvalidStatValueException {
    Require.statValueAtLeast(1, gma.getCurrentHp(), "Current HP");
    Require.statValueAtMost(gma.getMaxHp()-1, gma.getCurrentHp(), "Current HP");
    double act = gma.getMaxHp() * 0.3;
    gma.setCurrentHp(gma.getCurrentHp() + (int) act);
  }
}
