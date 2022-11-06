package cl.uchile.dcc.finalreality.model.weapon.Equipinterfaces;

import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;

public interface UsedByKnight extends Weapons {
    /**
     * To use Double Dispatch in equip
     * @param knight a Knight
     */
    void equippedByKnight(Knight knight);

}
