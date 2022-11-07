package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import cl.uchile.dcc.finalreality.model.weapon.Weapons;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Axe}s and {@code Bow}s.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class Engineer extends AbstractPlayerCharacter {

  /**
   * Creates a new engineer.
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
  public Engineer(final @NotNull String name, final int maxHp, final int defense,
                  final @NotNull BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
  }

  // region : UTILITY METHODS

  /**
   * Returns a boolean that indicates if 2 BlackMages are equals.
   *
   * @param obj
   *     the object that will be compared with "this"
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Engineer that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && name.equals(that.name)
            && getCurrentHp() == that.getCurrentHp()
            && maxHp == that.maxHp
            && defense == that.defense;
  }

  /**
   * return the Engineer's hash number.
   */
  @Override
  public int hashCode() {
    return Objects.hash(Engineer.class, name, getCurrentHp(), maxHp, defense);
  }

  /**
   * Returns the character class and it´s data in a String format.
   */
  @Override
  public String toString() {
    return "Engineer{ name='%s', currentHp=%d, maxHp=%d, defense=%d }"
            .formatted(name, getCurrentHp(), maxHp, defense);
  }

  public void equipAxe(Axe axe) {
    this.underequip(axe);
  }

  public void equipBow(Bow bow) {
    this.underequip(bow);
  }

  @Override
  public void equip(Weapons weapon) {

  }

  // endregion
}
