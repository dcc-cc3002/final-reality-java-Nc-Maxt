package cl.uchile.dcc.finalreality.model.character;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.States.State;

import java.beans.PropertyChangeListener;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public interface GameCharacter {

  // region : ACCESSORS

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's current HP.
   */
  int getCurrentHp();

  /**
   * Returns this character's max HP.
   */
  int getMaxHp();

  /**
   * Returns this character's defense.
   */
  int getDefense();

  /**
   * Sets this character's {@code CurrentHp} to {@code hp}.
   */
  void setCurrentHp(int hp) throws InvalidStatValueException;

  /**
   * Changes the {@code CurrentHp} substracting {@code dmg} to it.
   */
  void reduceHp(int dmg);

  /**
   * Add a Suscriptor.
   */
  void addlistener(PropertyChangeListener resp);

  // endregion

  // region : Utilities

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Method that is used by this character to attack another.
   *
   * @param gmch the {@code GameCharacter} that will recieve the attack.
   */
  void attack(GameCharacter gmch);


  /**
   * Method that is used by this character to recieve an attack from another.
   *
   * @param damage the damage.
   */
  void getattack(int damage);

  // endregion

  // region : State Pattern for Altered States

  /**
   * Change the State of the Character to {@code NormalState}.
   *
   */
  void Normal();

  /**
   * Change the State of the Character to {@code ParalyzedState}.
   *
   * @param mgdmg the damage that {@code GameCharacter} will recieve from the Spell.
   */
  void Thunder(int mgdmg);

  /**
   * Change the State of the Character to {@code BurningState}.
   *
   * @param mgdmg the damage that {@code GameCharacter} will recieve from the Spell.
   */
  void Burn(int mgdmg);
  /**
   * Change the State of the Character to {@code ParalyzedState}.
   *
   */
  void Paralyze();

  /**
   * Change the State of the Character to {@code PoisonedState}.
   *
   * @param mgdmg the damage that {@code GameCharacter} will recieve from the Spell.
   */
  void Poison(int mgdmg);

  /**
   * Return a Boolean depending on the {@code state} of the Character.
   *
   */
  boolean isNormal();

  /**
   * Return a Boolean depending on the {@code state} of the Character.
   *
   */
  boolean isPoisoned();

  /**
   * Return a Boolean depending on the {@code state} of the Character.
   *
   */
  boolean isParalyzed();

  /**
   * Return a Boolean depending on the {@code state} of the Character.
   *
   */
  boolean isBurning();

  void setState(State state);

  // endregion
}
