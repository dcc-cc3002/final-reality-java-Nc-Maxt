package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Knife extends AbstractWeapon{
    private final String type = "Knife";

    /**
     * Creates a weapon with a name, a base damage, speed, and it's type.
     */
    public Knife(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public String toString() {
        String fp = super.toString();
        return type+fp;
    }
}
