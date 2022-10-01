package cl.uchile.dcc.finalreality.model.weapon;

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
   * Creates an Axe with a name, a base damage, and it's type.
   */
  protected AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
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
