/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.Magicusers;

import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.magic.Spell;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.WhiteMagic;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;
import cl.uchile.dcc.finalreality.model.weapon.interfacedd.UsedByWhiteMage;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
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
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param maxMp      the character's max mp
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  public WhiteMage(final @NotNull String name, final int maxHp, final int defense,
                   int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  // region : UTILITY METHODS

  /**
   * Returns a boolean that indicates if 2 White Mages are equals.
   *
   * @param obj the object that will be compared with "this"
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

  // endregion

  // region : Double Dispatch for equip

  @Override
  public void equip(Weapons weapon) {
    try {
      weapon.equippedByWhiteMage(this);
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
   * @param ubw the weapon that will be equipped
   */
  public void equipusedbywhitemage(UsedByWhiteMage ubw) {
    this.underequip(ubw);
  }

  // endregion

  @Override
  public void setSpell(Spell spl) throws UnsupportedEquipmentException {
    spl.WM_trytosetSpll(this);
  }

  public void equipwhitemagic(WhiteMagic wm) {
    this.actualspell = wm;
  }


}
