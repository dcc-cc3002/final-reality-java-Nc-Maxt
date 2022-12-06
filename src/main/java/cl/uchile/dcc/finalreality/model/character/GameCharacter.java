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
   * Sets this character's current HP to {@code valuehp}.
   */
  void setCurrentHp(int hp) throws InvalidStatValueException;

  void reduceHp(int mgdmg);

  void getattack(int damage);
  
  void Thunder(int mgdmg);

  void Burn(int mgdmg);

  void Paralyze();

  void Poison(int mgdmg);

  void attack(GameCharacter gmch);

  void useSpell(GameCharacter target) throws UnsupportedEquipmentException, InvalidStatValueException;

  void waitTurn();

  // endregion
}
