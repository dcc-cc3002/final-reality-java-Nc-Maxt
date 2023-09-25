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
 * The usual {@link State} of a Character.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class NormalState extends AbstractAlteredState {

  @Override
  public void applyState() {
  }

  @Override
  public void tonormal() {
    error();
  }

  @Override
  public boolean isNormal() {
    return true;
  }

}
