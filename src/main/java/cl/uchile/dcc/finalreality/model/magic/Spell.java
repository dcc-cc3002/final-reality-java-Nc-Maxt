package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;

public interface Spell {

  void useSpell(Mages mgs, GameCharacter gma, int mgdmg) throws InvalidStatValueException;

  void BM_trytosetSpll(BlackMage BMmg) throws UnsupportedEquipmentException;

  void WM_trytosetSpll(WhiteMage WMmg) throws UnsupportedEquipmentException;

  int getManacost();
}
