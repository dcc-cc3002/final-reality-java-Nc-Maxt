package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.exceptions.InvalidWeaponEquipException;
import cl.uchile.dcc.finalreality.model.character.player.*;

/**
 * An interface that set obligatory getters and double dispatch methods for the weapons.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */

public interface Weapons {

  // region : ACCESSORS

  /**
   * Returns this weapon's name.
   */
  String getName();

  /**
   * Returns this weapons's damage.
   */
  int getDamage();

  /**
   * Returns this weapons's weight.
   */
  int getWeight();

  // endregion

  // region : Double Dispatch for equip

  /**
   * This method resolve the action to do: if equip the weapon or throw an Exception.
   *
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param blackmage
   *     the Black Mage who used equip
   */
  void equippedByBlackMage(BlackMage blackmage) throws InvalidWeaponEquipException;

  /**
   * This method resolve the action to do: if equip the weapon or throw an Exception.
   *
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param whitemage
   *     the White Mage who used equip
   */
  void equippedByWhiteMage(WhiteMage whitemage) throws InvalidWeaponEquipException;

  /**
   * This method resolve the action to do: if equip the weapon or throw an Exception.
   *
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param knight
   *     the Knight who used equip
   */
  void equippedByKnight(Knight knight) throws InvalidWeaponEquipException;

  /**
   * This method resolve the action to do: if equip the weapon or throw an Exception.
   *
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param engineer
   *     the Engineer who used equip
   */
  void equippedByEngineer(Engineer engineer) throws InvalidWeaponEquipException;

  /**
   * This method resolve the action to do: if equip the weapon or throw an Exception.
   *
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param thief
   *     the Thief who used equip
   */
  void equippedByThief(Thief thief) throws InvalidWeaponEquipException;

  // endregion
}
