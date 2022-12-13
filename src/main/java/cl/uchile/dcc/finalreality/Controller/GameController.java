package cl.uchile.dcc.finalreality.Controller;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.Mages;
import cl.uchile.dcc.finalreality.model.character.player.magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.magic.Spell;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;
import cl.uchile.dcc.finalreality.model.weapon.magical.Staff;
import cl.uchile.dcc.finalreality.model.weapon.nomagical.Axe;
import cl.uchile.dcc.finalreality.model.weapon.nomagical.Bow;
import cl.uchile.dcc.finalreality.model.weapon.nomagical.Knife;
import cl.uchile.dcc.finalreality.model.weapon.nomagical.Sword;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class containing a series of methods to maintain the logic of the game
 * and be capable to play it without breaking the rules.
 * This is the link between the model and the vista.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class GameController implements PropertyChangeListener {

  private String winner = "None";
  private BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();
  private ArrayList<PlayerCharacter> listapc = new ArrayList<>();
  private ArrayList<Enemy> listaen = new ArrayList<>();
  private ArrayList<PlayerCharacter> listapcalive = new ArrayList<>();
  private ArrayList<Enemy> listaenalive = new ArrayList<>();
  private final int seed;
  private Random generator;
  private GameCharacter actualchar;

  /**
   * Creates a new GameController.
   * This constructor is <b>public</b>, because it'll be used to create the gamecontroller.
   */
  public GameController() {
    this(new Random().nextInt());
  }

  /**
   * Creates a new GameController.
   * This constructor is <b>protected</b>, because it'll be used for testing or recreate the initial
   * conditions for a game.
   *
   * @param kernel the seed that will be used on the generator.
   */
  public GameController(int kernel) {
    this.seed = kernel;
    this.generator = new Random(kernel);
  }

  // region : ACCESSORS

  /**
   * Returns the GameController seed.
   */
  public int getseed() {
    return seed;
  }

  /**
   * Returns the winner of the game.
   */
  public String getWinner() {
    return winner;
  }

  /**
   * Returns the GameCharacter that's in their Turn.
   */
  public GameCharacter getActualchar() {
    return actualchar;
  }

  // endregion

  // region : Utilities

  /**
   * Remove a character from the Blockingqueue, and see if the player
   * or the Cpu won the game.
   *
   * <p> This method is <b>private</b>, beacuse it'll be used by
   * other methods in this Class.</p>
   *
   * @param gm the character that will be deleted.
   */
  private void deletechar(GameCharacter gm) throws InterruptedException {
    boolean isA = gm.isActive();
    queue1.remove(gm);
    gm.toDead();
    int pal = listapcalive.indexOf(gm);
    int eal = listaenalive.indexOf(gm);
    if (eal >= 0) {
      listaenalive.remove(gm);
    } else if (pal >= 0) {
      listapcalive.remove(gm);
    }
    if (isA) {
      nextchar();
    }
  }

  /**
   * Add a character to the Blockingqueue, and add this class as an observer
   *
   * <p> This method is <b>private</b>, beacuse it'll be used by
   * other methods in this Class.</p>
   *
   * @param gm  the character that will be add.
   * @param ars the first array in wich the character will be added.
   * @param ars the second array in wich the character will be added.
   */
  private void addchar(GameCharacter gm, ArrayList ars, ArrayList ars2) {
    ars.add(gm);
    ars2.add(gm);
    gm.addlistener(this);
    gm.waitTurn();
  }

  /**
   * Pop the character of the current Turn from the Blockingqueue
   *
   * <p> This method is should be <b>private</b>, beacuse it'll be used by
   * other methods in this Class, but it's public for testing</p>
   */
  public void nextchar() throws InterruptedException {
    if (winner == "Player Wins" || winner == "Enemy Wins") {
      System.out.println(getWinner());
    } else {
      if (queue1.size() == 0) {
        Thread.sleep(6000);
      }
      actualchar = queue1.poll();
      actualchar.toActive();
    }
  }

  /**
   * End the character turns.
   *
   * <p> This method is <b>private</b>, beacuse it'll be used by
   * other methods in this Class.</p>
   *
   * @param gm the character that will end it's turn.
   */
  private void endturn(GameCharacter gm) throws InterruptedException {
    gm.toInactive();
    waitTurn(gm);
    nextchar();
  }

  // endregion

  // region: Observer Pattern

  /**
   * Excecute certain actions depending on the message recieved.
   *
   * @param evt the Event fired.
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    GameCharacter gms = (GameCharacter) evt.getSource();
    if (evt.getPropertyName() == "dead") {
      try {
        deletechar(gms);
      } catch (InterruptedException e) {
        // Intellij no me dejaba no hacer el try catch incluso poniendo throws InterruptedException
        throw new RuntimeException(e);
      }
      if (onPlayerWin()) {
        winner = "Player Wins";
      } else if (onEnemyWin()) {
        winner = "Enemy Wins";
      }
    } else if (evt.getPropertyName() == "InactivetoActive") {
      gms.applyState();
    }
  }

  /**
   * A method that creates 2 different values for the constructors of elements
   * with the seed and the generator of the class.
   *
   * <p> This method is <b>private</b>, beacuse it'll be used by
   * other methods in this Class.</p>
   */
  private int[] twoStatConstructor(int a, int b, int c, int d) {
    int ab = generator.nextInt(a) + b;
    int cd = generator.nextInt(c) + d;
    return new int[]{ab, cd};
  }

  /**
   * A method that creates 3 different values for the constructors of elements
   * with the seed and the generator of the class.
   *
   * <p> This method is <b>private</b>, beacuse it'll be used by
   * other methods in this Class.</p>
   */
  private int[] tripleStatConstructor(int a, int b, int c, int d, int e, int f) {
    int[] abcd = twoStatConstructor(a, b, c, d);
    int ef = generator.nextInt(e) + f;
    return new int[]{abcd[0], abcd[1], ef};
  }

  /**
   * Creates a new Engineer with random stats.
   *
   * @param name the name of the new Engineer.
   */
  public Engineer createEngineer(String name) {
    int[] hpdef = twoStatConstructor(40, 200, 30, 90);
    Engineer eg = new Engineer(name, hpdef[0], hpdef[1], queue1);
    eg.equip(createAxe("Common Axe"));
    addchar(eg, listapcalive, listapc);
    return eg;
  }

  /**
   * Creates a new Knight with random stats.
   *
   * @param name the name of the new Knight.
   */
  public Knight createKnight(String name) {
    int[] hpdef = twoStatConstructor(80, 300, 25, 150);
    Knight kg = new Knight(name, hpdef[0], hpdef[1], queue1);
    kg.equip(createSword("Common Sword"));
    addchar(kg, listapcalive, listapc);
    return kg;
  }

  /**
   * Creates a new Thief with random stats.
   *
   * @param name the name of the new Thief.
   */
  public Thief createThief(String name) {
    int[] hpdef = twoStatConstructor(40, 160, 35, 25);
    Thief tf = new Thief(name, hpdef[0], hpdef[1], queue1);
    tf.equip(createKnife("Common Knife"));
    addchar(tf, listapcalive, listapc);
    return tf;
  }

  /**
   * Creates a new BlackMage with random stats.
   *
   * @param name the name of the new BlackMage.
   */
  public BlackMage createBlackMage(String name) {
    int[] hpmpdef = tripleStatConstructor(60, 70, 40, 80, 30, 80);
    BlackMage bm = new BlackMage(name, hpmpdef[0], hpmpdef[1], hpmpdef[2], queue1);
    bm.equip(createStaff("Common Staff"));
    addchar(bm, listapcalive, listapc);
    return bm;

  }

  /**
   * Creates a new WhiteMage with random stats.
   *
   * @param name the name of the new WhiteMage.
   */
  public WhiteMage createWhiteMage(String name) {
    int[] hpmpdef = tripleStatConstructor(50, 80, 40, 120, 30, 60);
    WhiteMage wm = new WhiteMage(name, hpmpdef[0], hpmpdef[1], hpmpdef[2], queue1);
    wm.equip(createStaff("Common Staff"));
    addchar(wm, listapcalive, listapc);
    return wm;
  }

  /**
   * Creates a new Enemy with random stats.
   *
   * @param name the name of the new Enemy.
   */
  public Enemy createEnemy(String name) {
    int[] wghp = twoStatConstructor(25, 25, 100, 500);
    int[] defat = twoStatConstructor(50, 80, 30, 20);
    Enemy en = new Enemy(name, wghp[0], wghp[1], defat[0], defat[1], queue1);
    addchar(en, listaenalive, listaen);
    return en;
  }

  /**
   * Creates a new Staff with random stats.
   *
   * @param name the name of the new Staff.
   */
  public Staff createStaff(String name) {
    int[] dmmgwg = tripleStatConstructor(10, 15, 20, 20, 15, 10);
    return new Staff(name, dmmgwg[0], dmmgwg[1], dmmgwg[2]);
  }

  public Sword createSword(String name) {
    int[] dmwg = twoStatConstructor(35, 20, 20, 15);
    return new Sword(name, dmwg[0], dmwg[1]);
  }

  /**
   * Creates a new Knife with random stats.
   *
   * @param name the name of the new Knife.
   */
  public Knife createKnife(String name) {
    int[] dmwg = twoStatConstructor(10, 10, 7, 5);
    return new Knife(name, dmwg[0], dmwg[1]);
  }

  /**
   * Creates a new Bow with random stats.
   *
   * @param name the name of the new Bow.
   */
  public Bow createBow(String name) {
    int[] dmwg = twoStatConstructor(30, 15, 15, 15);
    return new Bow(name, dmwg[0], dmwg[1]);
  }

  /**
   * Creates a new Bow with random stats.
   *
   * @param name the name of the new Bow.
   */
  public Axe createAxe(String name) {
    int[] dmwg = twoStatConstructor(50, 15, 20, 25);
    return new Axe(name, dmwg[0], dmwg[1]);
  }

  /**
   * This method excecute an attack between 2 characters.
   *
   * @param attacker the Character that attacks.
   * @param target   the Character that recieves attacks.
   */
  public void attack(GameCharacter attacker, GameCharacter target) throws InterruptedException {
    attacker.attack(target);
    endturn(attacker);
  }

  /**
   * This method excecute a magic cast.
   *
   * @param attacker the Character that do the magic cast.
   * @param target   the Character that recieves the magic effect.
   */
  public void useMagic(Mages attacker, GameCharacter target) throws InterruptedException {
    try {
      attacker.useSpell(target);
      endturn(attacker);
    } catch (UnsupportedEquipmentException uns) {
      attacker.toActive();
    } catch (InvalidStatValueException inv) {
      attacker.toActive();
    }
  }

  /**
   * This method set a magic spel.
   *
   * @param mg  the Mage that will set the spell.
   * @param spl the Spell.
   */
  public void setspell(Mages mg, Spell spl) {
    try {
      mg.setSpell(spl);
    } catch (UnsupportedEquipmentException usee) {
      System.out.println(usee);
    } finally {
      mg.toActive();
    }
  }

  /**
   * This method set a Weapon.
   *
   * @param pc the PlayerCHaracter that will equip the weapon.
   * @param wp the Weapon.
   */
  public void equip(PlayerCharacter pc, Weapons wp) {
    pc.equip(wp);
    pc.toActive();
  }

  /**
   * This excecute the different steps to wait a turn.
   *
   * @param character the Character that will waitTurn.
   */
  private void waitTurn(GameCharacter character) {
    queue1.remove(character);
    character.waitTurn();
  }

  /**
   * This method check if the Player won.
   */
  public boolean onPlayerWin() {
    boolean pwin = false;
    System.out.println(listaenalive.size());
    if (listaenalive.size() == 0) {
      return true;
    } else {
      return pwin;
    }
  }

  /**
   * This method check if the Cpu won.
   */
  public boolean onEnemyWin() {
    boolean ewin = false;
    if (listapcalive.size() == 0) {
      return true;
    } else {
      return ewin;
    }
  }
}
