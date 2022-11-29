package cl.uchile.dcc.finalreality.model.weapon.magical;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.Require;
import cl.uchile.dcc.finalreality.model.weapon.AbstractWeapon;

/**
 * An abstract class that holds the common behaviour of all the magicweapons in the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */

public abstract class AbstractMagicWeapon extends AbstractWeapon {
  protected final int magicdamage;

  /**
   * Creates a new MagicWeapon.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name        the weapon's name
   * @param damage      the weapon's damage
   * @param magicdamage the weapon's magic damage
   * @param weight      the weapon's weight
   */
  protected AbstractMagicWeapon(final String name, final int damage, final int magicdamage,final int weight) {
    super(name, damage, weight);
    int matk = magicdamage;
    try {
      Require.statValueAtLeast(1, magicdamage, "Magic Damage of the Weapon");
    } catch (InvalidStatValueException inv) {
      System.out.println("The Magic damage of a MagicWeapon can't be lower than 1, automatically setted to 1");
      matk = 1;
    }
    this.magicdamage = matk;
  }
}
