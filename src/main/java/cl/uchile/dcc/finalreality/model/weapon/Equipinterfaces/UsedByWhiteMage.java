package cl.uchile.dcc.finalreality.model.weapon.Equipinterfaces;

import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;

public interface UsedByWhiteMage {
    /**
     * To use Double Dispatch in equip
     * @param whitemage a WhiteMage
     */
    void equippedByWhiteMage(WhiteMage whitemage);
}
