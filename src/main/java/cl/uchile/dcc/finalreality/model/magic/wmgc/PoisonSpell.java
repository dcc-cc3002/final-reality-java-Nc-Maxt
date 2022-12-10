package cl.uchile.dcc.finalreality.model.magic.wmgc;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.WhiteMagic;

/**
 * A {@link WhiteMagic} Spell used to cause {@code PoisonState}.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class PoisonSpell extends AbstractWMSpell implements WhiteMagic {
  /**
   * Creates a new PoisonSpell.
   *
   */
  public PoisonSpell() {
    super(40);
  }

  @Override
  public void useSpell(Mages mgs, GameCharacter gma) throws UnsupportedEquipmentException {
    int mgdmg = (int) mgs.getEquippedWeapon().getMagicDamage();
    gma.toPoison(mgdmg);
  }
}
