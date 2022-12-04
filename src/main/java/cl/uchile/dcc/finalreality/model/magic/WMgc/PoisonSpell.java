package cl.uchile.dcc.finalreality.model.magic.WMgc;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.WhiteMagic;

public class PoisonSpell extends AbstractWMSpell implements WhiteMagic {
  public PoisonSpell() {
    super(40);
  }

  @Override
  public void useSpell(Mages mgs, GameCharacter gma, int mgdmg) {
    gma.Poison(mgdmg);
  }
}
