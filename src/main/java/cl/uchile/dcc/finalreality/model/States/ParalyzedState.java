package cl.uchile.dcc.finalreality.model.States;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

/**
 * A {@link State} that Paralyze the Character.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class ParalyzedState extends AbstractState{

  @Override
  public void toparalyze() {error();}

  @Override
  public boolean isParalyzed() {return true;}

}
