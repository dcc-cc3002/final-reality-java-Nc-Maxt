package cl.uchile.dcc.finalreality.model.magic;

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
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;

/**
 * An interface represent a Spell in the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public interface Spell {

  /**
   * Return the mana cost of the Spell.
   *
   */
  int getManacost();

  /**
   * Cast a Spell.
   *
   * @param mgs The Mage that cast the Spell.
   * @param gma The GameCharacter that will be affected by the Spell.
   */
  void useSpell(Mages mgs, GameCharacter gma) throws InvalidStatValueException, UnsupportedEquipmentException;

  /**
   * This method resolve the action to do: if set the spell or throw an Exception.
   * it's part of the implementation of Double Dispatch for Magic.
   *
   * @param BMmg the BlackMage who used setSpell.
   */
  void BM_trytosetSpll(BlackMage BMmg) throws UnsupportedEquipmentException;

  /**
   * This method resolve the action to do: if set the spell or throw an Exception.
   * it's part of the implementation of Double Dispatch for Magic.
   *
   * @param WMmg the BlackMage who used setSpell.
   */
  void WM_trytosetSpll(WhiteMage WMmg) throws UnsupportedEquipmentException;


}
