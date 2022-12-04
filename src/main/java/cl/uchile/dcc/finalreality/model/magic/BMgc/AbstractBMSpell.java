package cl.uchile.dcc.finalreality.model.magic.BMgc;

import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.AbstractSpell;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.BlackMagic;

import java.util.Random;

public abstract class AbstractBMSpell extends AbstractSpell implements BlackMagic {
  private final int probrequired;
  protected AbstractBMSpell( int reqpro) {
    super(15);
    this.probrequired = reqpro;
  }

  protected int getProbrequired() {
    return probrequired;
  }

  @Override
  public void useSpell(Mages mgs, GameCharacter Gmcha, int mgdmg) {
    Random rand = new Random();
    int numalea = rand.nextInt(100)+1;
    castspell(Gmcha, mgdmg, numalea);
  }

  abstract public void castspell(GameCharacter gmcha, int mgdmg, int numalea);


  @Override
  public void BM_trytosetSpll(BlackMage BMmg) {
    BMmg.equipblackmagic(this);
  }

  @Override
  public void WM_trytosetSpll(WhiteMage WMmg) throws UnsupportedEquipmentException {
    throw new UnsupportedEquipmentException("Spell", "this Class", "Tried to equip a White Mage Spell");
  }
}
