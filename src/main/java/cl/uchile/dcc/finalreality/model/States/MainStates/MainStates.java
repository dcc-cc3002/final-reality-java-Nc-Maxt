package cl.uchile.dcc.finalreality.model.States.MainStates;

import cl.uchile.dcc.finalreality.model.States.State;
import cl.uchile.dcc.finalreality.model.States.alteredState.AlteredStates;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public interface MainStates extends State {

  public void toinactive();

  public void toactive();

  public void todead();

  public boolean isActive();

  public boolean isInactive();

  public boolean isDead();

}
