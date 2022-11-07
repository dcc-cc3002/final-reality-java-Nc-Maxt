package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.exceptions.InvalidWeaponEquipException;
import cl.uchile.dcc.finalreality.model.character.player.*;

/**
 * An interface that set obligatory getters for the weapons.
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

  void equippedByBlackMage(BlackMage blackmage) throws InvalidWeaponEquipException;

  void equippedByWhiteMage(WhiteMage whitemage) throws InvalidWeaponEquipException;

  void equippedByKnight(Knight knight) throws InvalidWeaponEquipException;

  void equippedByEngineer(Engineer engineer) throws InvalidWeaponEquipException;

  void equippedByThief(Thief thief) throws InvalidWeaponEquipException;
  // endregion
}
