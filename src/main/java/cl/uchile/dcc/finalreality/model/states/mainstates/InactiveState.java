package cl.uchile.dcc.finalreality.model.states.mainstates;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

/**
 * An interface represent an InactiveState in the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class InactiveState extends AbstractMainState {

  @Override
  public void toactive() {
    this.changeState(new ActiveState());
  }


  @Override
  public void todead() {
    this.changeState(new DeadState());
  }

  @Override
  public boolean isInactive() {
    return true;
  }
}
