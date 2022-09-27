package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Axe extends AbstractWeapon {
    private final String type = "Axe";

    /**
     * Creates an Axe with a name, a base damage, and it's type.
     */
    public Axe(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public String toString() {
        String fp = super.toString();
        return type+fp;
    }
}
