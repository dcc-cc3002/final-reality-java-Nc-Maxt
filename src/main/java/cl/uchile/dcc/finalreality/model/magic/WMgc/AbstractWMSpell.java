package cl.uchile.dcc.finalreality.model.magic.WMgc;

import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.AbstractSpell;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.WhiteMagic;

public abstract class AbstractWMSpell extends AbstractSpell implements WhiteMagic {

  protected AbstractWMSpell(int cost) {
    super(cost);
  }

  @Override
  public void BM_trytosetSpll(BlackMage BMmg) throws UnsupportedEquipmentException {
    throw new UnsupportedEquipmentException("Spell", "this Class", "Tried to equip a Black Mage Spell");
  }

  @Override
  public void WM_trytosetSpll(WhiteMage WMmg) {
    WMmg.equipwhitemagic(this);
  }
}
