package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import cl.uchile.dcc.finalreality.model.weapon.Weapons;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Sword}s, {@code Knife}s and
 * {@code Bow}s.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 * @version 2.0
 */
public class Thief extends AbstractPlayerCharacter {

  /**
   * Creates a new Thief.
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
  public Thief(final @NotNull String name, final int maxHp, final int defense,
               final @NotNull BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public void equip(Weapons weapon) {

  }

  // region : UTILITY METHODS

  /**
   * Returns a boolean that indicates if 2 BlackMages are equals.
   *
   * @param o
   *     the object that will be compared with "this"
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Thief that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && name.equals(that.name)
            && getCurrentHp() == that.getCurrentHp()
            && maxHp == that.maxHp
            && defense == that.defense;
  }

  /**
   * return the Thief's hash number.
   */
  @Override
  public int hashCode() {
    return Objects.hash(Thief.class, name, getCurrentHp(), maxHp, defense);
  }

  /**
   * Returns the character class and it´s data in a String format.
   */
  @Override
  public String toString() {
    return "Thief{ name='%s', currentHp=%d, maxHp=%d, defense=%d }"
            .formatted(name, getCurrentHp(), maxHp, defense);
  }

  public void equipSword(Sword sword) {
    this.underequip(sword);
  }

  public void equipKnife(Knife knife) {
    this.underequip(knife);
  }

  public void equipBow(Bow bow) {
    this.underequip(bow);
  }

  // endregion
}
