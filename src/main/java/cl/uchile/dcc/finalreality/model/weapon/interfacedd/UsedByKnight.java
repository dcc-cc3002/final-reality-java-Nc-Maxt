package cl.uchile.dcc.finalreality.model.weapon.interfacedd;

import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;

/**
 * An interface that set an obligatory for the Weapons used by Knights.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */

public interface UsedByKnight extends Weapons {
  /**
   * Define a methods to implement Double Dispatch for equip.
   *
   * @param knight
   *     the Knight who used equip
   *
   */
  void equippedByKnight(Knight knight);

}
