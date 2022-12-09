package cl.uchile.dcc.finalreality.model.States;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

/**
 * A {@link State} that Poison the Character.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class PoisonedState extends AbstractDmgState {

  /**
   * Create a new PoisonedState.
   *
   * @param dmg  The magicDamage deal by the Spell saved in the State.
   */
  protected PoisonedState(int dmg) {
    super(dmg);
  }

  @Override
  public void topoison(int dmg) {error();}

  @Override
  public boolean isPoisoned() {return true;}
}
