package cl.uchile.dcc.finalreality.model.weapon.interfacedd;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;


/**
 * An interface that set an obligatory for the Weapons used by Thiefs.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public interface UsedByThief extends Weapons {
  /**
   * Define a methods to implement Double Dispatch for equip.
   *
   * @param thief
   *     the Thief who used equip
   *
   */
  void equippedByThief(Thief thief);

}
