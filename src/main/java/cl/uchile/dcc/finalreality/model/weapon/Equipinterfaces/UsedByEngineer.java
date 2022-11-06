package cl.uchile.dcc.finalreality.model.weapon.Equipinterfaces;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;

public interface UsedByEngineer extends Weapons {
    /**
     * To use Double Dispatch in equip
     * @param engineer an Engineer
     */
    void equippedByEngineer(Engineer engineer);

}
