package cl.uchile.dcc.finalreality.model.States;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A class that holds the common behavior of a State.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractState implements State {

  protected GameCharacter pj;

  /**
   * Change the State of the Character to {@code state}.
   * This could be a change in the MainState or in the Altered State,
   * it's resolved by Double Dispatch.
   *
   * @param state the new State of the Pj.
   */
  protected abstract void changeState(State state);


  @Override
  public void setChar(GameCharacter gc) {
    this.pj = gc;
  }

  /**
   * Throws a new error associated with the State pattern.
   *
   */
  protected void error() {
    throw new AssertionError("Wrong State");
  }

}
