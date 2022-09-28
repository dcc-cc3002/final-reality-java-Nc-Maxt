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
 * A class that holds all the information of a Knife (weapon),
 * that can be equipped by a character.
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class Knife implements Weapons{
    private final String name;
    private final int damage;
    private final int weight;

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
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }

    // region : ACCESSORS

    /**
     * Returns the name of the weapon.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the damage of the weapon.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Returns the weight of the weapon.
     */
    public int getWeight() {
        return weight;
    }

    // endregion

    // region : UTILITY METHODS

    /**
     * Returns a boolean that indicates if 2 Knifes are equals
     *
     * @param obj
     *    the object that will be compared with "this"
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(this.getClass() == obj.getClass())) {
            return false;
        }
        Knife other = (Knife) obj;
        return hashCode() == other.hashCode()
                && damage == other.getDamage()
                && weight == other.getWeight()
                && name.equals(other.getName());
    }

    /**
     * Returns the hashcode of the weapon.
     */
    public int hashCode() {
        return Objects.hash(Sword.class, name, damage, weight);
    }

    /**
     * Returns the weapon and it´s data in a String format.
     */
    public String toString() {
        return "Knife{name='%s', damage=%d, weight=%d}"
                .formatted(name, damage, weight);
    }
    // endregion
}
