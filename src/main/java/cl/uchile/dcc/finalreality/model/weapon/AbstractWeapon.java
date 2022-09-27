package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public abstract class AbstractWeapon implements Weapons {
    private final int damage;
    private final int weight;
    private final String name;

    /**
     * Creates a new Weapon.
     * This constructor is <b>protected</b>, because it'll only be used by subclasses.
     *
     * @param name
     *     the weapon's name
     * @param damage
     *     the weapon's max hp
     * @param weight
     *     the weapon's defense
     */
    protected AbstractWeapon(final String name, final int damage, final int weight) {
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

    /**
     * Returns a boolean depending on if the 2 instances are the same or not.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(this.getClass() == o.getClass())) {
            return false;
        }
        Weapons other = (Weapons) o;
        return hashCode() == other.hashCode()
                && damage == other.getDamage()
                && weight == other.getWeight()
                && name.equals(other.getName());
    }
    /**
     * Returns the hashcode of the weapon.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getClass(), name, damage, weight);
    }
    /**
     * Returns the weapon without it´s type in a String format.
     */
    @Override
    public String toString() {
        return "{name='%s', damage=%d, weight=%d}"
                .formatted(name, damage, weight);
    }
}

