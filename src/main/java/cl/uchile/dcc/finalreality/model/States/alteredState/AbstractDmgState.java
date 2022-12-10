package cl.uchile.dcc.finalreality.model.States.alteredState;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

/**
 * A class that holds the common behavior of a Spell that deals damage.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractDmgState extends AbstractApplicableState {
  private int magicdmg;

  /**
   * Creates a new DmgState.
   *
   * @param dmg    The magicDamage deal by the Spell saved in the State.
   * @param count  The times that the State can be applied to a Character.
   * @param n      the number that divides the dmg.
   */
  protected AbstractDmgState(int dmg, int count, int n) {
    super(count);
    double dmgxturn = (dmg / n);
    this.magicdmg = (int) dmgxturn;
  }

  public void applyState() {
    pj.reduceHp(magicdmg);
    this.timereduce();
  }

  /**
   * Return the damage of the State.
   *
   */
  public int getMagicdmg() {
    return magicdmg;
  }

}
