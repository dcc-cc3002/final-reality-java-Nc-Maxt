package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Axe implements Weapons {
    private final String name;
    private final int damage;
    private final int weight;
    /**
     * Creates an Axe with a name, a base damage, and it's type.
     */
    public Axe(final String name, final int damage, final int weight) {
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
        Axe other = (Axe) obj;
        return hashCode() == other.hashCode()
                && damage == other.getDamage()
                && weight == other.getWeight()
                && name.equals(other.getName());
    }

    /**
     * Returns the hashcode of the weapon.
     */
    public int hashCode() {
        return Objects.hash(Axe.class, name, damage, weight);
    }

    @Override
    public String toString() {
        return "Sword{name='%s', damage=%d, weight=%d}"
                .formatted(name, damage, weight);
    }
}
