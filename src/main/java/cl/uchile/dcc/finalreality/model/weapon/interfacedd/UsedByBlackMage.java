package cl.uchile.dcc.finalreality.model.weapon.Equipinterfaces;

import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;


/**
 * An interface that set an obligatory for the Weapons used by Black Mages.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */

public interface UsedByBlackMage extends Weapons {

    /**
     * To use Double Dispatch in equip
     * @param blackmage a Black Mage
     */
    void equippedByBlackMage(BlackMage blackmage);
}
