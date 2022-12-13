package cl.uchile.dcc.finalreality.model.states.mainstates;

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
import cl.uchile.dcc.finalreality.model.states.alteredstate.AlteredStates;

/**
 * A class that holds the common behavior of a MainState.
 * The MainStates are the states for the Character Turn behavior.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractMainState extends AbstractState implements MainStates {
  /**
   * Change the State of the Character to {@code state}.
   *
   * @param state the new State of the Pj.
   */
  protected void changeState(State state) {
    state.setMainState(this, pj);
  }

  @Override
  public void setMainState(MainStates mainstate, GameCharacter pj) {
    pj.setMainState(this);
  }

  @Override
  public void setAlteredState(AlteredStates alteredstate, GameCharacter pj) {
    error();
  }

  @Override
  public void toinactive() throws AssertionError {
    this.error();
  }

  @Override
  public void toactive() {
    error();
  }

  @Override
  public void todead() {
    error();
  }

  @Override
  public boolean isActive() {
    return false;
  }

  @Override
  public boolean isInactive() {
    return false;
  }

  @Override
  public boolean isDead() {
    return false;
  }

}
