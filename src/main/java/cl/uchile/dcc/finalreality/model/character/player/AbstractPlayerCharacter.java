package cl.uchile.dcc.finalreality.model.character.player;

/**
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * <p>All player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link Weapons}.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements
    PlayerCharacter {
  private ScheduledExecutorService scheduledExecutor;
  private Weapons equippedWeapon = null;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractPlayerCharacter(@NotNull final String name, final int maxHp,
      final int defense, @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */

  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var player = (PlayerCharacter) this;
    scheduledExecutor.schedule(
              /* command = */ this::addToQueue,
              /* delay = */ player.getEquippedWeapon().getWeight() / 10,
              /* unit = */ TimeUnit.SECONDS);
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public void equip(Weapons weapon) {
    this.equippedWeapon = weapon;
  }

  @Override
  public Weapons getEquippedWeapon() {
    return equippedWeapon;
  }
}
