package cl.uchile.dcc.finalreality.Controller;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.Mages;
import cl.uchile.dcc.finalreality.model.character.player.Magicusers.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
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

public class GameController implements PropertyChangeListener {

  private String winner;
  private BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();
  private ArrayList<PlayerCharacter> listapc = new ArrayList<>();
  private ArrayList<Enemy> listaen = new ArrayList<>();
  private final int seed;
  private Random generator;


  public GameController() {
    this(new Random().nextInt());
  }

  public GameController(int kernel) {
    this.seed = kernel;
    this.generator = new Random(kernel);
    for (int i = 1; i <= (generator.nextInt(2) + 5); i = i + 1) {
      Enemy en = createEnemy("Enemy" + Integer.toString(i));
      en.addlistener(this);
      listaen.add(en);
      en.waitTurn();
    }
  }

  public String getWinner() {
    return winner;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    if (evt.getPropertyName() == "dead") {
      queue1.remove(evt.getSource());
      if (onPlayerWin()) {
        winner = "Player Wins";
      } else if (onEnemyWin()) {
        winner = "Enemy Wins";
      }
    } else if (evt.getPropertyName() == "Inactive") {
      System.out.println("Salio activo");
    } else if (evt.getPropertyName() == "Active") {
      System.out.println("Salio activo");
    }
  }

  public int getseed() {
    return seed;
  }

  private int[] twoStatConstructor(int a, int b, int c, int d) {
    int ab = generator.nextInt(a) + b;
    int cd = generator.nextInt(c) + d;
    return new int[]{ab, cd};
  }

  private int[] tripleStatConstructor(int a, int b, int c, int d, int e, int f) {
    int[] abcd = twoStatConstructor(a, b, c, d);
    int ef = generator.nextInt(e) + f;
    return new int[]{abcd[0], abcd[1], ef};
  }

  public Engineer createEngineer(String name) {
    int[] hpdef = twoStatConstructor(40, 200, 30, 90);
    return new Engineer(name, hpdef[0], hpdef[1], queue1);
    // hp = 200, def 70
    // , Weapons weapon
  }

  public Knight createKnight(String name) {
    int[] hpdef = twoStatConstructor(80, 300, 25, 150);
    return new Knight(name, hpdef[0], hpdef[1], queue1);
    // hp = 300, def 150
    // , Weapons weapon
  }

  public Thief createThief(String name) {
    int[] hpdef = twoStatConstructor(40, 160, 35, 25);
    return new Thief(name, hpdef[0], hpdef[1], queue1);
    // hp 250, def 25
    // , Weapons weapon
  }

  public BlackMage createBlackMage(String name) {
    int[] hpmpdef = tripleStatConstructor(60, 70, 40, 80, 30, 80);
    return new BlackMage(name, hpmpdef[0], hpmpdef[1], hpmpdef[2], queue1);
    // hp 100, def 50, mp 70
    // , Weapons weapon
  }

  public WhiteMage createWhiteMage(String name) {
    int[] hpmpdef = tripleStatConstructor(50, 80, 40, 120, 30, 60);
    return new WhiteMage(name, hpmpdef[0], hpmpdef[1], hpmpdef[2], queue1);
    // Falta añadir el arma y crearla
    // hp 100, def 50, mp 80
  }

  public Enemy createEnemy(String name) {
    int[] wghp = twoStatConstructor(30, 50, 100, 500);
    int[] defat = twoStatConstructor(50, 80, 30, 20);
    return new Enemy(name, wghp[0], wghp[1], defat[0], defat[1], queue1);
    // hp 500, def 100, weight 50
  }

  public Staff createStaff(String name) {
    int[] dmmgwg = tripleStatConstructor(10, 15, 20, 20, 15, 10);
    return new Staff(name, dmmgwg[0], dmmgwg[1], dmmgwg[2]);
  }

  public Sword createSword(String name) {
    int[] dmwg = twoStatConstructor(35, 20, 20, 15);
    return new Sword(name, dmwg[0], dmwg[1]);
  }

  public Knife createKnife(String name) {
    int[] dmwg = twoStatConstructor(10, 10, 10, 5);
    return new Knife(name, dmwg[0], dmwg[1]);
  }

  public Bow createBow(String name) {
    int[] dmwg = twoStatConstructor(30, 15, 15, 15);
    return new Bow(name, dmwg[0], dmwg[1]);
  }

  public Axe createAxe(String name) {
    int[] dmwg = twoStatConstructor(50, 15, 45, 15);
    return new Axe(name, dmwg[0], dmwg[1]);
  }

  public void attack(GameCharacter attacker, GameCharacter target) {
    attacker.attack(target);
  }

  public void useMagic(Mages attacker, GameCharacter target)
      throws UnsupportedEquipmentException, InvalidStatValueException {
    attacker.useSpell(target);

  }

  public void equip(PlayerCharacter pc, Weapons wp) throws UnsupportedEquipmentException {
    pc.equip(wp);
  }

  public void waitTurn(GameCharacter character) {
    character.waitTurn();
  }

  public boolean onPlayerWin() {
    boolean pwin = true;
    for (Enemy enemy : listaen) {
      if (enemy.getCurrentHp() != 0) {
        pwin = false;
      }
    }
    return pwin;
  }

  public boolean onEnemyWin() {
    boolean ewin = true;
    for (PlayerCharacter pc : listapc) {
      if (pc.getCurrentHp() != 0) {
        ewin = false;
      }
    }
    return ewin;
  }


}
