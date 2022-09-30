package cl.uchile.dcc.finalreality.model.weapon;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import java.util.Objects;

/**
 * A class that holds all the information of a Bow (weapon),
 * that can be equipped by a character.
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class Bow extends AbstractWeapon{
    /**
     * Creates a new Bow.
     * This constructor is <b>public</b>, because it'll be used in testing and the programe.
     *
     * @param name
     *     the weapon's name
     * @param damage
     *     the weapon's damage
     * @param weight
     *     the weapon's weight
     *
     */
    public Bow(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }
    // region : UTILITY METHODS

    /**
     * Returns a boolean that indicates if 2 Bows are equals
     *
     * @param obj
     *    the object that will be compared with "this"
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof final Bow that)) {
            return false;
        }
        return hashCode() == that.hashCode()
                && getName().equals(that.getName())
                && getDamage() == that.getDamage()
                && getWeight() == that.getWeight();
    }

    /**
     * Returns the hashcode of the Bow.
     */
    public int hashCode() {
        return Objects.hash(Bow.class, getName(), getDamage(), getWeight());
    }

    /**
     * Returns the Bow and it´s data in a String format.
     */
    @Override
    public String toString() {
        return "Bow{name='%s', damage=%d, weight=%d}"
                .formatted(getName(), getDamage(), getWeight());
    }
    // endregion    }
}
