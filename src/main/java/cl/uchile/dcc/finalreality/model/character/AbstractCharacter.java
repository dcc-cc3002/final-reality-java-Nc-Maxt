package cl.uchile.dcc.finalreality.model.character;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.Require;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractCharacter implements GameCharacter {

  protected final String name;
  protected final int maxHp;
  private int currentHp;
  protected int defense;
  protected final BlockingQueue<GameCharacter> turnsQueue;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
      @NotNull BlockingQueue<GameCharacter> turnsQueue) throws InvalidStatValueException {
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.name = name;
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
  }

  // region : ACCESSORS

  /**
   * Returns the name of the character.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Returns the current Hp of the character.
   */
  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  /**
   * Returns the max Hp of the character.
   */
  @Override
  public int getMaxHp() {
    return maxHp;
  }

  /**
   * Returns the defense of the character.
   */
  @Override
  public int getDefense() {
    return defense;
  }

  /**
   * Set the current Hp of the character.
   */
  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, hp, "Current HP");
    Require.statValueAtMost(maxHp, hp, "Current HP");
    currentHp = hp;
  }
  // endregion
}
