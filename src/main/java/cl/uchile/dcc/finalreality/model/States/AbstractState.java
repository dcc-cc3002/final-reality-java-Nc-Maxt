package cl.uchile.dcc.finalreality.model.States;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

public abstract class AbstractState implements State {

  protected Enemy Pj;

  public void setChar(Enemy enem) {
    this.Pj = enem;
  }

  protected void changeState(State state) {
    Pj.setState(state);
  }

  @Override
  public void stateattack(PlayerCharacter Pc, int damage) {
    Pc.getattack(damage);
  }

  protected void error() { throw new AssertionError("Wrong State");}

  public void topoison(int dmg) {this.changeState(new PoisonedState(dmg));}
  public void toparalyze() {this.changeState(new ParalyzedState());}
  public void tonormal() {this.changeState(new NormalState());}
  public void toburn(int dmg) {this.changeState(new BurningState(dmg));}

  public boolean isNormal() {return false;}
  public boolean isPoisoned() {return false;}
  public boolean isParalyzed() {return false;}
  public boolean isBurning() {return false;}

}
