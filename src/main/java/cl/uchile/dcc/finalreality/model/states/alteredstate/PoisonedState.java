package cl.uchile.dcc.finalreality.model.states.alteredstate;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.states.State;

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
  public PoisonedState(int dmg) {
    super(dmg, 4, 3);
  }

  @Override
  public boolean isPoisoned() {
    return true;
  }

}
