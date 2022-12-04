package cl.uchile.dcc.finalreality.model.character.player.Magicusers;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

public interface Mages extends PlayerCharacter {
  void channelmana(GameCharacter gmCha, int magicdamage) throws InvalidStatValueException;

  void reduceMp(int value);
}
