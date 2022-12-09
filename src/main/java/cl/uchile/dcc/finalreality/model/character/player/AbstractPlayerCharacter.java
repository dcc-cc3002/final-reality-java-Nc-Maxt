package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and MN
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * <p>All player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link Weapons}.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements PlayerCharacter {
  private Weapons equippedWeapon = null;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  protected AbstractPlayerCharacter(@NotNull final String name, final int maxHp,
                                    final int defense, @NotNull final BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
  }

  // region : UTILITY METHODS

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
        /* command = */ this::addToQueue,
        /* delay = */ this.getEquippedWeapon().getWeight() / 10,
        /* unit = */ TimeUnit.SECONDS);
  }

  @Override
  public Weapons getEquippedWeapon() {
    return equippedWeapon;
  }

  // endregion

  // region : Double Dispatch for equip

  @Override
  public abstract void equip(Weapons weapon);

  /**
   * Sets the {@code equippedWeapon} of the character to {@code weapon}.
   *
   * <p>This is the final step in Double Dispatch for equip
   * (the method that equips the Weapon),
   * this method is <b>protected</b>, beacuse it'll be used only by the Classes
   * that extends from this one.</p>
   *
   * @param weapon the weapon that a character will use
   */
  protected void underequip(Weapons weapon) {
    this.equippedWeapon = weapon;
  }

  // endregion

  // region : Utilities

  public void attack(GameCharacter en) {
    int dmg0 = equippedWeapon.getDamage();
    en.getattack(dmg0);
  }

  // endregion
}
