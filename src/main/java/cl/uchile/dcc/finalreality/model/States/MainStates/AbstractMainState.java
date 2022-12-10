package cl.uchile.dcc.finalreality.model.States.MainStates;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */


import cl.uchile.dcc.finalreality.model.States.AbstractState;
import cl.uchile.dcc.finalreality.model.States.State;
import cl.uchile.dcc.finalreality.model.States.alteredState.AlteredStates;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

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

  public void setMainState(MainStates mainstate, GameCharacter pj) {
    pj.setMainState(this);
  }

  public void setAlteredState(AlteredStates alteredstate, GameCharacter pj) {
    error();
  }
  public void toinactive() {
    error();
  }

  public void toactive() {
    error();
  }

  public void todead() {
    error();
  }

  public boolean isActive() {
    return false;
  }

  public boolean isInactive() {
    return false;
  }

  public boolean isDead() {
    return false;
  }

}
