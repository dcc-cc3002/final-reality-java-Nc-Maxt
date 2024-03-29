package cl.uchile.dcc.finalreality.model.weapon.magical;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.Mages;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.weapon.interfacedd.UsedByBlackMage;
import cl.uchile.dcc.finalreality.model.weapon.interfacedd.UsedByWhiteMage;
import java.util.Objects;

/**
 * A class that holds all the information of a Staff (weapon),
 * that can be equipped by a character.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class Staff extends AbstractMagicWeapon
    implements UsedByBlackMage, UsedByWhiteMage, ChannelingMgWp {

  /**
   * Creates a new Staff.
   * This constructor is <b>public</b>, because it'll be used in testing and in the program.
   *
   * @param name   the weapon's name
   * @param damage the weapon's damage
   * @param weight the weapon's weight
   */
  public Staff(final String name, final int damage, final int magicdamage, final int weight) {
    super(name, damage, magicdamage, weight);
  }

  // region : UTILITY METHODS

  /**
   * Returns a boolean that indicates if 2 Staffs are equals.
   *
   * @param obj the object that will be compared with "this"
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Staff that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && getName().equals(that.getName())
        && getDamage() == that.getDamage()
        && getWeight() == that.getWeight()
        && getMagicDamage() == that.getMagicDamage();
  }

  /**
   * Returns the hashcode of the Staff.
   */
  public int hashCode() {
    return Objects.hash(Staff.class, getName(), getDamage(), getMagicDamage(), getWeight());
  }

  /**
   * Returns the Staff and it´s data in a String format.
   */
  @Override
  public String toString() {
    return "Staff{name='%s', damage=%d, magicdamage=%d, weight=%d}"
        .formatted(getName(), getDamage(), getMagicDamage(), getWeight());
  }

  // endregion

  // region : Double Dispatch for equip

  @Override
  public void equippedByBlackMage(BlackMage blackmage) {
    blackmage.equipusedbyblackmage(this);
  }

  @Override
  public void equippedByWhiteMage(WhiteMage whitemage) {
    whitemage.equipusedbywhitemage(this);
  }

  @Override
  public void equippedByKnight(Knight knight) throws UnsupportedEquipmentException {
    String info = "Staffs aren't part of the equippable Weapons of a Knight";
    throw new UnsupportedEquipmentException("Weapon", "this Class", info);
  }

  @Override
  public void equippedByEngineer(Engineer engineer) throws UnsupportedEquipmentException {
    String info = "Staffs aren't part of the equippable Weapons of a Engineer";
    throw new UnsupportedEquipmentException("Weapon", "this Class", info);
  }

  @Override
  public void equippedByThief(Thief thief) throws UnsupportedEquipmentException {
    String info = "Staffs aren't part of the equippable Weapons of a Thief";
    throw new UnsupportedEquipmentException("Weapon", "this Class", info);
  }

  // endregion

  @Override
  public void trytochannel(Mages Mage, GameCharacter gmCha)
      throws InvalidStatValueException, UnsupportedEquipmentException {
    Mage.channelmana(gmCha);
  }
}