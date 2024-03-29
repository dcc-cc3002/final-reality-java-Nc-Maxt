package cl.uchile.dcc.finalreality.model.character.player.magicusers;

/*
 * "Final Reality" (c) by R8V and MN
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.Require;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.magic.Spell;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can cast magic.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractMage extends AbstractPlayerCharacter implements Mages {
  protected int currentMp;
  protected final int maxMp;
  protected Spell actualspell;

  /**
   * Creates a new Mage.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param maxMp      the character's max mp
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  public AbstractMage(final @NotNull String name, final int maxHp, final int defense,
                      int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
    int mpval = maxMp;
    try {
      Require.statValueAtLeast(0, maxMp, "Max Mp");
    } catch (InvalidStatValueException inv) {
      System.out.println("Maximum Mp can't be lower than 0, automatically setted to 0");
      mpval = 1;
    }
    this.maxMp = mpval;
    this.currentMp = mpval;
  }

  // region : ACCESSORS

  /**
   * Returns the {@code maxMp} of the Mage.
   */
  public int getMaxMp() {
    return maxMp;
  }

  /**
   * Returns the {@code currentMp} of the Mage.
   */
  public int getCurrentMp() {
    return currentMp;
  }

  /**
   * Sets the {@code currentMp} of the character to {@code value}.
   *
   * <p>This method is <b>private</b>, because it must be only used
   * by methods in the class to change value of {@code MP}
   * when casting a spell.</p>
   */
  public void setCurrentMp(final int newMp) {
    int value = newMp;
    try {
      Require.statValueAtLeast(0, newMp, "Current MP");
    } catch (InvalidStatValueException inv) {
      System.out.println(this.getName() + "can't afford that spell");
      value = currentMp;
    }
    try {
      Require.statValueAtMost(maxMp, newMp, "Current MP");
    } catch (InvalidStatValueException inv) {
      System.out.println(this.getName() + "can't afford that amount of magic");
      value = maxMp;
    }
    this.currentMp = value;
  }

  @Override
  public void reduceMp(int value) {
    setCurrentMp(getCurrentMp() - value);
  }

  // endregion

  // region : Magic Double Dispatch
  @Override
  public void useSpell(GameCharacter gmCha)
      throws UnsupportedEquipmentException, InvalidStatValueException {
    getEquippedWeapon().trytochannel(this, gmCha);
  }

  @Override
  public void channelmana(GameCharacter gmCha)
      throws InvalidStatValueException, UnsupportedEquipmentException {
    if (currentMp - actualspell.getManacost() < 0) {
      throw new InvalidStatValueException("The Character has no Mana for this Spell");
    }
    actualspell.useSpell(this, gmCha);
    reduceMp(actualspell.getManacost());

  }

  // endregion
}
