package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;

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
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param blackmage the Black Mage who used equip
   */
  void equippedByBlackMage(BlackMage blackmage) throws UnsupportedEquipmentException;

  /**
   * This method resolve the action to do: if equip the weapon or throw an Exception.
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param whitemage the White Mage who used equip
   */
  void equippedByWhiteMage(WhiteMage whitemage) throws UnsupportedEquipmentException;

  /**
   * This method resolve the action to do: if equip the weapon or throw an Exception.
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param knight the Knight who used equip
   */
  void equippedByKnight(Knight knight) throws UnsupportedEquipmentException;

  /**
   * This method resolve the action to do: if equip the weapon or throw an Exception.
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param engineer the Engineer who used equip
   */
  void equippedByEngineer(Engineer engineer) throws UnsupportedEquipmentException;

  /**
   * This method resolve the action to do: if equip the weapon or throw an Exception.
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param thief the Thief who used equip
   */
  void equippedByThief(Thief thief) throws UnsupportedEquipmentException;

  /**
   * This method resolve the action to do: if equip the weapon or throw an Exception.
   * it's part of the implementation of Double Dispatch for equip.
   *
   * @param Mage the Mage who is trying to channel their magic through the Weapon
   * @param gmCha the Gamecharacter that could recieve the Spell
   */
  void trytochannel(Mages Mage, GameCharacter gmCha) throws UnsupportedEquipmentException, InvalidStatValueException;

  /**
   * Returns this weapons's MagicDamage.
   */
  int getMagicDamage() throws UnsupportedEquipmentException;

  // endregion
}
