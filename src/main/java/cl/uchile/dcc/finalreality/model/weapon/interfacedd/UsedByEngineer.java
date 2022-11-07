package cl.uchile.dcc.finalreality.model.weapon.interfacedd;

import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;

/**
 * An interface that set an obligatory for the Weapons used by Engineers.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public interface UsedByEngineer extends Weapons {
  /**
   * Define a methods to implement Double Dispatch for equip.
   *
   * @param engineer
   *     the Engineer who used equip
   *
   */
  void equippedByEngineer(Engineer engineer);

}
