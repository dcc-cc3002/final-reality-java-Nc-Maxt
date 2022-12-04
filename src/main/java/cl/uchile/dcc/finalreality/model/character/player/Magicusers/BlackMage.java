package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.InvalidSpellsetException;
import cl.uchile.dcc.exceptions.InvalidWeaponEquipException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magic.Spell;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.BlackMagic;
import cl.uchile.dcc.finalreality.model.magic.interfaceddmg.WhiteMagic;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;
import cl.uchile.dcc.finalreality.model.weapon.interfacedd.UsedByBlackMage;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can cast black magic, equip {@code Staff}s and {@code Knife}s.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class BlackMage extends AbstractMage {
  /**
   * Creates a new Black Mage.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param maxMp      the character's max mp
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  public BlackMage(final @NotNull String name, final int maxHp, final int defense,
                   int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  // region : UTILITY METHODS

  /**
   * Returns a boolean that indicates if 2 Black Mages are equals.
   *
   * @param obj the object that will be compared with "this"
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final BlackMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense
        && maxMp == that.maxMp;
  }

  /**
   * return the Black Mage's hash number.
   */
  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, name, getCurrentHp(), maxHp, defense, maxMp, currentMp);
  }

  /**
   * Returns the character class and it's data in a String format.
   */
  @Override
  public String toString() {
    return "BlackMage{ name='%s', currentHp=%d, maxHp=%d, currentMp=%d, maxMp=%d, defense=%d }"
        .formatted(name, getCurrentHp(), maxHp, currentMp, maxMp, defense);
  }

  // endregion

  // region : Double Dispatch equip methods

  @Override
  public void equip(Weapons weapon) {
    try {
      weapon.equippedByBlackMage(this);
    } catch (InvalidWeaponEquipException iwep) {
      System.out.println(iwep);
    }
  }

  /**
   * Call the method that sets the {@code equippedWeapon} of the character to {@code ubb}.
   *
   * <p> This method is <b>public</b>, beacuse it'll be used
   * by the Weapon Classes.</p>
   *
   * @param ubb the weapon that will be equipped
   */
  public void equipusedbyblackmage(UsedByBlackMage ubb) {
    this.underequip(ubb);
  }
  // end region

  @Override
  public void setSpell(Spell spl) throws InvalidSpellsetException {
    spl.BM_trytosetSpll(this);
  }

  public void equipblackmagic(BlackMagic bm) {
    this.actualspell = bm;
  }

}
