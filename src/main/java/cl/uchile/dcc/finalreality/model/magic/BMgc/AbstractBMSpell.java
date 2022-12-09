package cl.uchile.dcc.finalreality.model.magic.BMgc;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.magic.AbstractSpell;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.BlackMagic;
import cl.uchile.dcc.finalreality.model.weapon.magical.ChannelingMgWp;

import java.util.Random;

/**
 * A class that holds the common behavior of a BlackMage Spell.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractBMSpell extends AbstractSpell implements BlackMagic {
  private final int probrequired;

  /**
   * Creates a new BlackMage Spell.
   *
   * @param reqpro  The percentage needed to apply an Altered State.
   */
  protected AbstractBMSpell( int reqpro) {
    super(15);
    this.probrequired = reqpro;
  }

  /**
   * Return the {@code probrequired} of the spell to apply an Altered State.
   *
   */
  protected int getProbrequired() {
    return probrequired;
  }

  @Override
  public void useSpell(Mages mgs, GameCharacter Gmcha) throws UnsupportedEquipmentException {
    int mgdmg = (int) mgs.getEquippedWeapon().getMagicDamage();
    Random rand = new Random();
    int numalea = rand.nextInt(100)+1;
    castspell(Gmcha, mgdmg, numalea);
  }

  /**
   * The Spell cast itself.
   *
   * @param gmcha  The character that will recieve the Spell.
   * @param mgdmg  The damage dealed with the Spell.
   * @param numalea  The percentage of the Spell.
   */
  abstract public void castspell(GameCharacter gmcha, int mgdmg, int numalea);


  @Override
  public void BM_trytosetSpll(BlackMage BMmg) {
    BMmg.equipblackmagic(this);
  }

  @Override
  public void WM_trytosetSpll(WhiteMage WMmg) throws UnsupportedEquipmentException {
    throw new UnsupportedEquipmentException("Spell", "this Class", "Tried to equip a White Mage Spell");
  }
}
