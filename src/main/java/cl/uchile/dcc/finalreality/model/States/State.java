package cl.uchile.dcc.finalreality.model.States;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

public interface State {

  void setChar(Enemy enem);

  void stateattack(GameCharacter Pc, int damage);

  void topoison(int dmg);

  void toparalyze();

  void tonormal();

  void toburn(int dmg);

  boolean isBurning();

  boolean isParalyzed();

  boolean isPoisoned();

  boolean isNormal();
}
