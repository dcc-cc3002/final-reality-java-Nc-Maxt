package cl.uchile.dcc.finalreality.model.weapon;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.weapon.interfacedd.UsedByBlackMage;
import cl.uchile.dcc.finalreality.model.weapon.interfacedd.UsedByKnight;
import cl.uchile.dcc.finalreality.model.weapon.interfacedd.UsedByThief;
import java.util.Objects;

/**
 * A class that holds all the information of a Knife (weapon),
 * that can be equipped by a character.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 *
 */
public class Knife extends AbstractWeapon implements UsedByBlackMage, UsedByKnight, UsedByThief {
  /**
   * Creates a new Knife.
   *
   * @param name
   *     the weapon's name
   * @param damage
   *     the weapon's damage
   * @param weight
   *     the weapon's weight
   *
   */
  public Knife(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }


  // region : UTILITY METHODS
  @Override
  public void equippedByBlackMage(BlackMage blackmage) {
    blackmage.equipKnife(this);
  }

  /**
   * Returns a boolean that indicates if 2 Knifes are equals.
   *
   * @param obj
   *     the object that will be compared with "this"
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Knife that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && getName().equals(that.getName())
            && getDamage() == that.getDamage()
            && getWeight() == that.getWeight();
  }

  /**
   * Returns the hashcode of the Knife.
   */
  public int hashCode() {
    return Objects.hash(Knife.class, getName(), getDamage(), getWeight());
  }

  /**
   * Returns the Knife and it´s data in a String format.
   */
  @Override
  public String toString() {
    return "Knife{name='%s', damage=%d, weight=%d}"
            .formatted(getName(), getDamage(), getWeight());
  }

  @Override
  public void equippedByKnight(Knight knight) {
    knight.equipKnife(this);
  }

  @Override
  public void equippedByThief(Thief thief) {
    thief.equipKnife(this);
  }

  // endregion
}
