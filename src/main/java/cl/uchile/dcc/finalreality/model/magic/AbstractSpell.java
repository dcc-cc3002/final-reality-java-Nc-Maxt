package cl.uchile.dcc.finalreality.model.magic;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

/**
 * A class that holds the common behavior of a Spell.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractSpell implements Spell {
  private int Manacost;

  /**
   * Creates a new Spell.
   *
   * @param cost  The Mp needed to use the Spell.
   */
  protected AbstractSpell (int cost) {
    this.Manacost = cost;
  }

  /**
   * Return the ManaCost of the Spell.
   *
   */
  public int getManacost() {
    return Manacost;
  }


}
