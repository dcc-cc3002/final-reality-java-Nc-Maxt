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

import cl.uchile.dcc.finalreality.model.States.alteredState.AlteredStates;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class Enemy extends AbstractCharacter {
  private final int weight;
  private final int damage;

  /**
   * Creates a new Enemy.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param damage     the character's damage
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense, int damage,
               @NotNull final BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
    int damageval = damage;
    try {
      Require.statValueAtLeast(5, damage, "Attack");
    } catch (InvalidStatValueException inv) {
      System.out.println("Attack can't be lower than 5, automatically setted to 6");
      damageval = 6;
    }
    int weightval = weight;
    try {
      Require.statValueAtLeast(1, weight, "Weight");
    } catch (InvalidStatValueException inv) {
      System.out.println("Weight can't be lower than 1, automatically setted to 3");
      weightval = 3;
    }
    this.damage = damageval;
    this.weight = weightval;
  }

  // region : ACCESSORS

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the attack of this enemy.
   */
  public int getDamage() {
    return damage;
  }

  // endregion

  // region : UTILITY METHODS

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
        /* command = */ this::addToQueue,
        /* delay = */ this.getWeight() / 10,
        /* unit = */ TimeUnit.SECONDS);
  }

  @Override
  public void attack(GameCharacter gmch) {
    int dmg0 = damage;
    gmch.getattack(dmg0);
  }


  /**
   * Returns a boolean that indicates if 2 Enemies are equals.
   *
   * @param obj the object that will be compared with "this"
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
        && maxHp == enemy.maxHp
        && defense == enemy.defense
        && weight == enemy.weight;
  }

  /**
   * Returns the Enemy hash.
   */
  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, name, weight, maxHp, defense);
  }

  /**
   * Returns the character class and it´s data in a String format.
   */
  @Override
  public String toString() {
    return "Enemy{ name='%s', currentHp=%d, maxHp=%d, defense=%d, weight=%d}"
        .formatted(name, getCurrentHp(), maxHp, defense, weight);
  }

  // endregion



}
