package cl.uchile.dcc.finalreality.model.states.alteredstate;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.states.AbstractState;
import cl.uchile.dcc.finalreality.model.states.State;
import cl.uchile.dcc.finalreality.model.states.mainstates.MainStates;

/**
 * A class that holds the common behavior of an AlteredState.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractAlteredState extends AbstractState implements AlteredStates {

  /**
   * Change the State of the Character to {@code state}.
   *
   * @param state the new State of the Pj.
   */
  protected void changeState(State state) {
    state.setAlteredState(this, pj);
  }

  @Override
  public void setMainState(MainStates mainstate, GameCharacter gm) {
    error();
  }

  @Override
  public void setAlteredState(AlteredStates alteredstate, GameCharacter pj) {
    pj.setAlteredState(this);
  }

  @Override
  public void topoison(int dmg) {
    this.changeState(new PoisonedState(dmg));
  }

  @Override
  public void toparalyze() {
    this.changeState(new ParalyzedState());
  }

  @Override
  public void tonormal() {
    this.changeState(new NormalState());
  }

  @Override
  public void toburn(int dmg) {
    this.changeState(new BurningState(dmg));
  }

  @Override
  public boolean isNormal() {
    return false;
  }

  @Override
  public boolean isPoisoned() {
    return false;
  }

  @Override
  public boolean isParalyzed() {
    return false;
  }

  @Override
  public boolean isBurning() {
    return false;
  }

}
