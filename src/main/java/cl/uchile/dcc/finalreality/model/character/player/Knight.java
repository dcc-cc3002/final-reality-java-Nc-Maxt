package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;
import cl.uchile.dcc.finalreality.model.weapon.interfacedd.UsedByKnight;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Sword}s,{@code Knife}s and
 * {@code Axe}s.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class Knight extends AbstractPlayerCharacter {

  /**
   * Creates a new Knight.
   *
   * @param name       the character's name
   * @param maxHp      the character's maximum health points
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  public Knight(@NotNull final String name, int maxHp, int defense,
                @NotNull final BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
  }

  // region : UTILITY METHODS

  /**
   * Returns a boolean that indicates if 2 Knights are equals.
   *
   * @param obj the object that will be compared with "this"
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Knight that)) {
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
    return Objects.hash(Knight.class, name, getCurrentHp(), maxHp, defense);
  }

  /**
   * Returns the character class and it´s data in a String format.
   */
  @Override
  public String toString() {
    return "Knight{ name='%s', currentHp=%d, maxHp=%d, defense=%d }"
        .formatted(name, getCurrentHp(), maxHp, defense);
  }

  // endregion

  // region : Double Dispatch for equip

  @Override
  public void equip(Weapons weapon) {
    try {
      weapon.equippedByKnight(this);
    } catch (UnsupportedEquipmentException usep) {
      System.out.println(usep);
    }
  }

  /**
   * Call the method that sets the {@code equippedWeapon} of the character to {@code ubb}.
   *
   * <p> This method is <b>public</b>, beacuse it'll be used
   * by the Weapon Classes.</p>
   *
   * @param ubk the weapon that will be equipped
   */
  public void equipusedbyknight(UsedByKnight ubk) {
    this.underequip(ubk);
  }

  // endregion
}
