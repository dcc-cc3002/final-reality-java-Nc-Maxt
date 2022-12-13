package cl.uchile.dcc.finalreality.model.states.mainstates;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.states.State;

/**
 * An interface represent a MainState in the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public interface MainStates extends State {

  /**
   * Change the mainState of the Character to {@code InactiveState}.
   *
   */
  void toinactive();

  /**
   * Change the mainState of the Character to {@code ActiveState}.
   *
   */
  void toactive();

  /**
   * Change the mainState of the Character to {@code DeadState}.
   *
   */
  void todead();

  /**
   * Return a Boolean depending on the {@code mainstate} of the Character.
   */
  boolean isActive();

  /**
   * Return a Boolean depending on the {@code mainstate} of the Character.
   */
  boolean isInactive();

  /**
   * Return a Boolean depending on the {@code mainstate} of the Character.
   */
  boolean isDead();

}
