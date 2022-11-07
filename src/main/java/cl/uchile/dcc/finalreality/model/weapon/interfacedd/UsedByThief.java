package cl.uchile.dcc.finalreality.model.weapon.interfacedd;

import cl.uchile.dcc.finalreality.model.character.player.Thief;


/**
 * An interface that set an obligatory for the Weapons used by Thiefs.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public interface UsedByThief {
  /**
   * Define a methods to implement Double Dispatch for equip.
   *
   * @param thief
   *     the Thief who used equip
   *
   */
  void equippedByThief(Thief thief);

}
