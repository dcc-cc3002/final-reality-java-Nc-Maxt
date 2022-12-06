package cl.uchile.dcc.finalreality.model.States;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

public class ParalyzedState extends AbstractState{

  protected ParalyzedState() {}

  @Override
  public void stateattack(GameCharacter Pc, int damage) { System.out.println("The Enemy is paralyzed, they can't attack right now"); }

  @Override
  public void toparalyze() {error();}

  @Override
  public boolean isParalyzed() {return true;}

}
