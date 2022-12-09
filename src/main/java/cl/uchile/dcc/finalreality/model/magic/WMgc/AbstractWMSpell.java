package cl.uchile.dcc.finalreality.model.magic.WMgc;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.AbstractSpell;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.WhiteMagic;

/**
 * A class that holds the common behavior of a WhiteMage Spell.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractWMSpell extends AbstractSpell implements WhiteMagic {

  /**
   * Creates a new WhiteMage Spell.
   *
   * @param cost  The Mp needed to use the Spell.
   */
  protected AbstractWMSpell(int cost) {
    super(cost);
  }

  @Override
  public void BM_trytosetSpll(BlackMage BMmg) throws UnsupportedEquipmentException {
    throw new UnsupportedEquipmentException("Spell", "this Class", "Tried to equip a Black Mage Spell");
  }

  @Override
  public void WM_trytosetSpll(WhiteMage WMmg) {
    WMmg.equipwhitemagic(this);
  }
}
