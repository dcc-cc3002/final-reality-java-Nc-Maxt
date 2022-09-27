package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public abstract class AbstractWeapon implements Weapons {
    private final String name;
    private final int damage;
    private final int weight;

    /**
     * Creates a weapon with a name, a base damage, speed, and it's type.
     */
    public AbstractWeapon(final String name, final int damage, final int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass(), name, damage, weight);
    }

    @Override
    public String toString() {
        return "Weapon{name='%s', damage=%d, weight=%d}"
                .formatted(name, damage, weight);
    }
}

