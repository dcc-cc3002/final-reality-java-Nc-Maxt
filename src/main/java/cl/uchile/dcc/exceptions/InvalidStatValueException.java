/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.exceptions;

/**
 * This error is used to represent an invalid stat value.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class InvalidStatValueException extends Exception {

  /**
   * Creates a new {@code InvalidStatValueException} with a {@code description} of the
   * error.
   */
  public InvalidStatValueException(String description) {
    super("The provided value is not a valid stat value. " + description);
  }
}