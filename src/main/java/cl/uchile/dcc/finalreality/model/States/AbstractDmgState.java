package cl.uchile.dcc.finalreality.model.States;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A class that holds the common behavior of a Spell that deals damage.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractDmgState extends AbstractState{
  private int magicdmg;

  /**
   * Creates a new DmgState.
   *
   * @param dmg  The magicDamage deal by the Spell saved in the State.
   */
  protected AbstractDmgState(int dmg) {
    double dmgxturn = (dmg/3);
    this.magicdmg = (int) dmgxturn;
  }


  public void stateattack(GameCharacter Pc, int damage) {
    Pc.getattack(damage);
  }


  /**
   * Return the damage of the State.
   *
   */
  public int getMagicdmg() {
    return magicdmg;
  }

}
