package cl.uchile.dcc.exceptions;


/**
 * This error is used to represent an invalid stat value.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */

public class InvalidWeaponEquipException  extends Exception {
  /**
   * Creates a new {@code InvalidStatValueException} with a {@code description} of the
   * error.
   */
  public InvalidWeaponEquipException(String description) {
    super("The provided Weapon is not a valid Weapon for this Class. " + description);
  }
}
