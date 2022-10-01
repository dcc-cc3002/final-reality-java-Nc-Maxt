package cl.uchile.dcc.finalreality.model.weapon;

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

  // endregion
}
