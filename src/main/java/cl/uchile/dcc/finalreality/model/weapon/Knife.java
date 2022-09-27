package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;
/**
 * A Knife Class that can be used to create instances of Axe's
 * and implements methods to work with that instance of the class.
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author ~Matias Nunez~
 */
public class Knife implements Weapons{
    private final String name;
    private final int damage;
    private final int weight;

    /**
     * Creates a weapon with a name, a base damage, speed, and it's type.
     */
    public Knife(final String name, final int damage, final int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }

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
}
