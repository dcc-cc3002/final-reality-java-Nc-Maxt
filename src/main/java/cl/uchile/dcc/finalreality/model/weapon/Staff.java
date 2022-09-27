package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Staff extends AbstractWeapon{
    private final String type = "Staff";

    /**
     * Creates a weapon with a name, a base damage, speed, and it's type.
     */
    public Staff(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public String toString() {
        String fp = super.toString();
        return type+fp;
    }
}
