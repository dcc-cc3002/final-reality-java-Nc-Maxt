package cl.uchile.dcc.finalreality.model.magic.bmgc;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.BlackMagic;

/**
 * A {@link BlackMagic} Spell that can cause {@code ParalyzedState}, and deals
 * Magic Damage.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class ThunderSpell extends AbstractBMSpell {
  /**
   * Creates a new ThunderSpell.
   *
   */
  public ThunderSpell() {
    super(70);
  }

  @Override
  public void castspell(GameCharacter gmcha, int mgdmg, int numalea) {
    if (numalea > getProbrequired()) {
      gmcha.toThunder(mgdmg);
    }
    gmcha.reduceHp(mgdmg);
  }

}
