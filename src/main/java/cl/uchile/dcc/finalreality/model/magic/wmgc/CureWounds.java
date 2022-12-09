package cl.uchile.dcc.finalreality.model.magic.wmgc;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.WhiteMagic;

/**
 * A {@link WhiteMagic} Spell used to cure an Ally.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class CureWounds extends AbstractWMSpell implements WhiteMagic {

  /**
   * Creates a new CureWoundsSpell.
   *
   */
  public CureWounds() {
    super(15);
  }

  @Override
  public void useSpell(Mages mgs, GameCharacter gma) throws InvalidStatValueException {
    Require.statValueAtLeast(1, gma.getCurrentHp(), "Current HP");
    Require.statValueAtMost(gma.getMaxHp() - 1, gma.getCurrentHp(), "Current HP");
    double act = gma.getMaxHp() * 0.3;
    gma.setCurrentHp(gma.getCurrentHp() + (int) act);
  }
}
