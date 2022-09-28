package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;


/**
 * A class that holds all the information of a Sword (weapon),
 * that can be equipped by a character.
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author ~Matias Nunez~
 */
public class Sword implements Weapons{
    private final String name;
    private final int damage;
    private final int weight;

    /**
     * Creates a new Sword.
     *
     * @param name
     *     the weapon's name
     * @param damage
     *     the weapon's damage
     * @param weight
     *     the weapon's weight
     */
    public Sword(final String name, final int damage, final int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }

    /**
     * Returns the name of the Sword.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the damage of the Sword.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Returns the weight of the Sword.
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
        Sword other = (Sword) obj;
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
        return "Sword{name='%s', damage=%d, weight=%d}"
                .formatted(name, damage, weight);
    }
}
