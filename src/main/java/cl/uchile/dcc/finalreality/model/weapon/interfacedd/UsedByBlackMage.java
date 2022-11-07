package cl.uchile.dcc.finalreality.model.weapon.interfacedd;

import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;


/**
 * An interface that set an obligatory method for the Weapons used by Black Mages.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */

public interface UsedByBlackMage extends Weapons {
  /**
   * Define a methods to implement Double Dispatch for equip.
   *
   * @param blackmage
   *     the Black Mage who used equip
   *
   */
  void equippedByBlackMage(BlackMage blackmage);

}
