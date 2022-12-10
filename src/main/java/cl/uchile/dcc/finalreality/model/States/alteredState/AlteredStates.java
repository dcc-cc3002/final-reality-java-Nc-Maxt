package cl.uchile.dcc.finalreality.model.States.alteredState;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.States.State;
/**
 * An interface represent a State in the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public interface AlteredStates extends State {

  /**
   * Applies the effect of the State.
   */
  void applyState();

  /**
   * Change the State of the Character to {@code PoisonedState}.
   *
   * @param dmg The magicDamage deal by the Spell saved in the State.
   */
  void topoison(int dmg);

  /**
   * Change the State of the Character to {@code ParalyzedState}.
   */
  void toparalyze();

  /**
   * Change the State of the Character to {@code NormalState}.
   */
  void tonormal();

  /**
   * Change the State of the Character to {@code BurningState}.
   *
   * @param dmg The magicDamage deal by the Spell saved in the State.
   */
  void toburn(int dmg);

  /**
   * Return a Boolean depending on the {@code state} of the Character.
   */
  boolean isNormal();

  /**
   * Return a Boolean depending on the {@code state} of the Character.
   */
  boolean isPoisoned();

  /**
   * Return a Boolean depending on the {@code state} of the Character.
   */
  boolean isParalyzed();

  /**
   * Return a Boolean depending on the {@code state} of the Character.
   */
  boolean isBurning();

}

