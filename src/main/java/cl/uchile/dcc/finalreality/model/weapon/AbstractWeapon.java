package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.Require;

/**
 * An abstract class that holds the common behaviour of all the weapons in the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractWeapon implements Weapons {

  protected final String name;
  protected final int damage;
  protected final int weight;


  /**
   * Creates a new Weapon.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name        the weapon's name
   * @param damage      the weapon's damage
   * @param weight      the weapon's weight
   */
  protected AbstractWeapon(final String name, final int damage, final int weight) {
    int atk = damage;
    try {
      Require.statValueAtLeast(0, damage, "damage of the Weapon");
    } catch (InvalidStatValueException inv) {
      System.out.println("The damage of a Weapon can't be negative, automatically setted to 0");
      atk = 0;
    }
    this.name = name;
    this.weight = weight;
    this.damage = atk;
  }

  // region : ACCESSORS

  /**
   * Returns the name of the weapon.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the damage of the weapon.
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }

  // endregion
}
