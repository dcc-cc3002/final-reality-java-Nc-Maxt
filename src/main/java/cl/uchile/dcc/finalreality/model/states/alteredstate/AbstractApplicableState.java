package cl.uchile.dcc.finalreality.model.states.alteredstate;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

/**
 * A class that holds the common behavior of a AplicableState.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractApplicableState extends AbstractAlteredState {
  protected final int maxtimeeffect;
  protected int actualtime;


  /**
   * Creates a new ApplicableState.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param count       the times that the State can affect a Character.
   */
  protected AbstractApplicableState(int count) {
    maxtimeeffect = count;
    actualtime = count;
  }

  /**
   * Reduce the times left that the state can be applied to a Character.
   *
   */
  protected void timereduce() {
    if (actualtime == 1) {
      tonormal();
    } else {
      actualtime -= 1;
    }
  }

}
