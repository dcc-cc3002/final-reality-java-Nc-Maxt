package cl.uchile.dcc.finalreality.model.weapon.interfacedd;

import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;

/**
 * An interface that set an obligatory for the Weapons used by White Mages.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public interface UsedByWhiteMage {
  /**
   * Define a methods to implement Double Dispatch for equip.
   *
   * @param whitemage
   *     the White Mage who used equip
   *
   */
  void equippedByWhiteMage(WhiteMage whitemage);
}
