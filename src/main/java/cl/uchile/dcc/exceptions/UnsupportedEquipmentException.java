/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.exceptions;

/**
 * This error is used to represent a try to use an invalid weapon/spell to certain action.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */

public class UnsupportedEquipmentException extends Exception {
  /**
   * Creates a new {@code UnsupportedEquipmentException} with a {@code description} of the
   * error.
   *
   * @param tip         the type of the equipment
   * @param reason      complementary info
   * @param description the description of the exception
   */

  public UnsupportedEquipmentException(String tip, String reason, String description) {
    super(("The provided '%s' is not a valid '%s' for '%s'. "
        .formatted(tip, tip, reason)) + description);
  }

}
