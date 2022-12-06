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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.States.State;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public abstract class AbstractCharacter implements GameCharacter {

  protected final String name;
  protected final int maxHp;
  private int currentHp;

  protected int defense;
  protected State state;
  protected final BlockingQueue<GameCharacter> turnsQueue;
  protected ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
                              @NotNull BlockingQueue<GameCharacter> turnsQueue) {
    int hpval = maxHp;
    int defval = defense;
    try {
      Require.statValueAtLeast(1, maxHp, "Max HP");
    } catch (InvalidStatValueException inv) {
      System.out.println("Maximum Hp can't be lower or equal to 0, automatically setted to 1");
      hpval = 1;
    }
    try {
      Require.statValueAtLeast(0, defense, "Defense");
    } catch (InvalidStatValueException inv) {
      System.out.println("Defense can't be lower than 0, automatically setted to 0");
      defval = 0;
    }
    this.name = name;
    this.maxHp = hpval;
    this.currentHp = maxHp;
    this.defense = defval;
    this.turnsQueue = turnsQueue;
  }

  // region : ACCESSORS

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  @Override
  public int getMaxHp() {
    return maxHp;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public void setCurrentHp(int hp) {
    int value = hp;
    try {
      Require.statValueAtLeast(0, hp, "Current HP");
    } catch (InvalidStatValueException inv) {
      System.out.println(this.getName() + " died");
      value = 0;
    }
    try {
      Require.statValueAtMost(maxHp, hp, "Current HP");
    } catch (InvalidStatValueException inv) {
      System.out.println(this.getName() + " overhealed");
      value = maxHp;
    }
    currentHp = value;
  }

  @Override
  public void reduceHp(int dmg) {
    setCurrentHp(currentHp-dmg);
  }

  /**
   * Adds this character to the turns queue.
   * this method is <b>protected</b>, beacuse it'll be used by
   * the subclasses of the class.
   */
  protected void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  public void getattack(int damage) {
    double armorreduc = (100 * 1.0) / (100 + getDefense());
    this.reduceHp((int) ((damage*1.0)*armorreduc));
  }
  // endregion

  abstract public void attack(GameCharacter PC);

  public void useSpell(GameCharacter target) throws UnsupportedEquipmentException, InvalidStatValueException {
    throw new UnsupportedEquipmentException("CharacterClass"," Magic use", "This class cannot use Magic"+this.toString() );
  }


  public void Poison(int mgdmg) {
    try{
      state.topoison(mgdmg);
    }catch (AssertionError As) {
      System.out.println("The Enemy is already Poisoned");
    }
  }
  public void Paralyze() {
    try{
      state.toparalyze();
    }catch (AssertionError As) {
      System.out.println("The Enemy is already Paralyzed");
    }
  }
  public void Normal() {
    try{
      state.tonormal();
    }catch (AssertionError As) {
      System.out.println("The Enemy is already in a Normal State");
    }
  }

  @Override
  public void Thunder(int mgdmg) {
    reduceHp(mgdmg);
    this.Paralyze();
  }

  public void Burn(int mgdmg) {
    reduceHp(mgdmg);
    try{
      state.toburn(mgdmg);
    } catch (AssertionError As) {
      System.out.println("The Enemy is already Burning");
    }
  }

  public boolean isNormal() {
    return state.isNormal();
  }
  public boolean isPoisoned() {
    return state.isPoisoned();
  }
  public boolean isParalyzed() {
    return state.isParalyzed();
  }
  public boolean isBurning() {
    return state.isBurning();
  }

}
