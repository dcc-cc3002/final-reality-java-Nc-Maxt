/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.exceptions.InvalidWeaponEquipException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;
import cl.uchile.dcc.finalreality.model.weapon.interfacedd.UsedByWhiteMage;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Staff}s and use <i>white magic</i>.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class WhiteMage extends AbstractMage {
  /**
   * Creates a new White Mage.
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
   *
   */
  public WhiteMage(final @NotNull String name, final int maxHp, final int defense,
                     int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  // region : UTILITY METHODS

  /**
   * Returns a boolean that indicates if 2 White Mages are equals.
   *
   * @param obj
   *     the object that will be compared with "this"
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
            && name.equals(that.name)
            && maxHp == that.maxHp
            && defense == that.defense
            && maxMp == that.maxMp;
  }

  /**
   * return the White Mage's hash number.
   */
  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, name, maxHp, defense, maxMp);
  }

  /**
   * Returns the character class and it´s data in a String format.
   */
  @Override
  public String toString() {
    return "WhiteMage{ name='%s', currentHp=%d, maxHp=%d, currentMp=%d, maxMp=%d, defense=%d }"
            .formatted(name, getCurrentHp(), maxHp, currentMp, maxMp, defense);
  }

  public void equip(Weapons weapon) {
    try {
      weapon.equippedByWhiteMage(this);
    } catch (InvalidWeaponEquipException iwep) {
      System.out.println(iwep);
    }
  }

  public void equipusedbywhitemage(UsedByWhiteMage ubw) {
    this.underequip(ubw);
  }

  // endregion
}
