package cl.uchile.dcc.finalreality.model.magic.WMgc;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.WhiteMagic;

public class ParalyzeSpell extends AbstractWMSpell implements WhiteMagic {

  public ParalyzeSpell() {
    super(25);
  }

  @Override
  public void useSpell(Mages mgs, GameCharacter gma, int mgdmg) {
    gma.Paralyze();
  }
}
