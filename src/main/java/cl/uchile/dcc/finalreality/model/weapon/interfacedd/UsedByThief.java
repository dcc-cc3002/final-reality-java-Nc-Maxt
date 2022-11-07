package cl.uchile.dcc.finalreality.model.weapon.Equipinterfaces;

import cl.uchile.dcc.finalreality.model.character.player.Thief;

public interface UsedByThief {
    /**
     * To use Double Dispatch in equip
     * @param thief a Thief
     */
    void equippedByThief(Thief thief);

}
