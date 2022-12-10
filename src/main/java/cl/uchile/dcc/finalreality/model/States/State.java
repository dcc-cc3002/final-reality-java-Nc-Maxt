package cl.uchile.dcc.finalreality.model.States;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.States.MainStates.MainStates;
import cl.uchile.dcc.finalreality.model.States.alteredState.AlteredStates;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * An interface represent a State in the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public interface State {

  void setMainState(MainStates mainstate, GameCharacter pj);

  void setAlteredState(AlteredStates alteredstate, GameCharacter pj);

  void setChar(GameCharacter Gc);

}
