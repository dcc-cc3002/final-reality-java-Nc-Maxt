/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Staff}s and use <i>white magic</i>.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class WhiteMage extends AbstractPlayerCharacter {
  private int currentMp;
  private final int maxMp;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param maxMp
   *     the character's max mp
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected WhiteMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  // region : ACCESSORS

  /**
   * Returns the max MP of the character.
   */
  public int getMaxMp() {
    return maxMp;
  }

  /**
   * Returns the current MP of the character.
   */
  public int getCurrentMp() {
    return currentMp;
  }

  /**
   * Sets the current MP of the character to {@code newMp}.
   *
   * <p>This method should be <b>private</b>, because it must be only used by methods in the class
   * to change value of {@code MP} when casting a spell but for testing it will be public.</p>
   */
  public void setCurrentMp(final int newMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, newMp, "Current MP");
    Require.statValueAtMost(maxMp, newMp, "Current MP");
    this.currentMp = newMp;
  }

  // endregion

  // region : UTILITY METHODS

  /**
   * Returns a boolean that indicates if 2 White Mages are equals
   *
   * @param obj
   *    the object that will be compared with "this"
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final WhiteMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && maxMp == that.maxMp
        && currentMp == that.currentMp
        && maxHp == that.maxHp
        && name.equals(that.name)
        && defense == that.defense;
  }

  /**
   * return the White Mage's hash number.
   */
  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, currentMp, getCurrentHp(), name, maxHp, defense, maxMp);
  }
  /**
   * return a string with information about the White Mage.
   */
  @Override
  public String toString() {
    return "BlackMage{currentMp=%d, currentHp=%d, maxMp=%d, maxHp=%d, defense=%d, name='%s'}"
            .formatted(currentMp, getCurrentHp(), maxMp, maxHp, defense, name);
  }
  // endregion
}
