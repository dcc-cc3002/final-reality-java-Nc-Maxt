package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.InvalidWeaponEquipException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;

/**
 * A {@link GameCharacter} that can equip a weapon.
 */
public interface PlayerCharacter extends GameCharacter {

  /**
   * Start the implementation of double dispatch disambiguating the type,
   * calling a method implemented into the weapon class.
   *
   * @param weapon the weapon that it's trying to equip to the White Mage
   */
  void equip(Weapons weapon);

  /**
   * Return this character's equipped weapon.
   */
  Weapons getEquippedWeapon();
}
