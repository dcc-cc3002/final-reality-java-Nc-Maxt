package cl.uchile.dcc.finalreality.model.character;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */


import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.Require;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class Enemy extends AbstractCharacter {
  private ScheduledExecutorService scheduledExecutor;
  private final int weight;

  /**
   * Creates a new Enemy.
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
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
  }

  // region : ACCESSORS

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  // endregion

  // region : UTILITY METHODS

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor.schedule(
              /* command = */ this::addToQueue,
              /* delay = */ enemy.getWeight() / 10,
              /* unit = */ TimeUnit.SECONDS);
    }

  /**
   * Adds this character to the turns queue.
   * this method is <b>private</b>, beacuse it'll be used by
   * the instance of the class.
   */
  private void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  /**
   * Returns a boolean that indicates if 2 Enemies are equals
   *
   * @param obj
   *    the object that will be compared with "this"
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
        && name.equals(enemy.name)
        && getCurrentHp() == enemy.getCurrentHp()
        && maxHp == enemy.maxHp
        && defense == enemy.defense
        && weight == enemy.weight;
  }
  /**
   * Returns the Enemy hash.
   */
  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, name, weight, maxHp, getCurrentHp(), defense);
  }

  @Override
  public String toString() {
    return "Enemy{name='%s', currentHp=%d, maxHp=%d, defense=%d, weight=%d}"
            .formatted(name, getCurrentHp(), maxHp, defense, weight);
  }
}
