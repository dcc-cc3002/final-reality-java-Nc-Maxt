package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Staff {
    private final String name;
    private final int damage;
    private final int weight;
    private final String type = "Staff";

    /**
     * Creates a weapon with a name, a base damage, speed, and it's type.
     */
    public Staff(final String name, final int damage, final int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }

    private String getName() {
        return name;
    }

    private int getDamage() {
        return damage;
    }

    /**
     * Returns the weight of the weapon.
     */
    public int getWeight() {
        return weight;
    }

    private String getType() {
        return type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Staff weapon)) {
            return false;
        }
        return hashCode() == weapon.hashCode()
                && damage == weapon.damage
                && weight == weapon.weight
                && name.equals(weapon.name)
                && type == weapon.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Weapon.class, name, damage, weight, type);
    }

    @Override
    public String toString() {
        return "Weapon{name='%s', damage=%d, weight=%d, type=%s}"
                .formatted(name, damage, weight, type);
    }
}
