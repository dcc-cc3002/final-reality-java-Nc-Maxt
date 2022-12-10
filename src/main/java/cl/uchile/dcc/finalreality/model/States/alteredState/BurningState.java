package cl.uchile.dcc.finalreality.model.States.alteredState;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.States.MainStates.MainStates;
import cl.uchile.dcc.finalreality.model.States.State;
import cl.uchile.dcc.finalreality.model.States.alteredState.AbstractDmgState;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A {@link State} that burn the Character.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class BurningState extends AbstractDmgState {

  /**
   * Create a new BurningState.
   *
   * @param dmg  The magicDamage deal by the Spell saved in the State.
   */
  public BurningState(int dmg) {
    super(dmg, 3, 2);
  }

  @Override
  public void toburn(int dmg) {
    error();
  }

  @Override
  public boolean isBurning() {
    return true;
  }


}
