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


  public GameController() {
    this(new Random().nextInt());
  }

  public GameController(int kernel) {
    this.seed = kernel;
    this.generator = new Random(kernel);
    //for (int i = 1; i <= (generator.nextInt(2) + 3); i = i + 1) {
    //  Enemy en = createEnemy("Enemy" + Integer.toString(i));
    //}
  }

  public String getWinner() {
    return winner;
  }

  public GameCharacter getActualchar() {
    return actualchar;
  }

  private void deletechar(GameCharacter gm) {
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

  private void addchar(GameCharacter gm, ArrayList ars, ArrayList ars2) {
    ars.add(gm);
    ars2.add(gm);
    gm.addlistener(this);
    gm.waitTurn();
  }

  // for thest
  public void nextchar() {
    if (winner == "Player Wins" || winner == "Enemy Wins") {
      System.out.println(getWinner());
    } else {
      if (queue1.size() == 0) {
        try {
          Thread.sleep(6000);
        } catch (InterruptedException ie) {
        }
      }
      actualchar = queue1.poll();
      actualchar.toActive();
    }
  }

  private void endturn(GameCharacter gm) {
    gm.toInactive();
    waitTurn(gm);
    nextchar();
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    GameCharacter gms = (GameCharacter) evt.getSource();
    if (evt.getPropertyName() == "dead") {
      deletechar(gms);
      if (onPlayerWin()) {
        winner = "Player Wins";
      } else if (onEnemyWin()) {
        winner = "Enemy Wins";
      }
    } else if (evt.getPropertyName() == "InactivetoActive") {
      gms.applyState();
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
    Engineer eg = new Engineer(name, hpdef[0], hpdef[1], queue1);
    eg.equip(createAxe("Common Axe"));
    addchar(eg, listapcalive, listapc);
    return eg;
  }

  public Knight createKnight(String name) {
    int[] hpdef = twoStatConstructor(80, 300, 25, 150);
    Knight kg = new Knight(name, hpdef[0], hpdef[1], queue1);
    kg.equip(createSword("Common Sword"));
    addchar(kg, listapcalive, listapc);
    return kg;
  }

  public Thief createThief(String name) {
    int[] hpdef = twoStatConstructor(40, 160, 35, 25);
    Thief tf = new Thief(name, hpdef[0], hpdef[1], queue1);
    tf.equip(createKnife("Common Knife"));
    addchar(tf, listapcalive, listapc);
    return tf;
  }

  public BlackMage createBlackMage(String name) {
    int[] hpmpdef = tripleStatConstructor(60, 70, 40, 80, 30, 80);
    BlackMage bm = new BlackMage(name, hpmpdef[0], hpmpdef[1], hpmpdef[2], queue1);
    bm.equip(createStaff("Common Staff"));
    addchar(bm, listapcalive, listapc);
    return bm;

  }

  public WhiteMage createWhiteMage(String name) {
    int[] hpmpdef = tripleStatConstructor(50, 80, 40, 120, 30, 60);
    WhiteMage wm = new WhiteMage(name, hpmpdef[0], hpmpdef[1], hpmpdef[2], queue1);
    wm.equip(createStaff("Common Staff"));
    addchar(wm, listapcalive, listapc);
    return wm;
  }

  public Enemy createEnemy(String name) {
    int[] wghp = twoStatConstructor(25, 25, 100, 500);
    int[] defat = twoStatConstructor(50, 80, 30, 20);
    Enemy en = new Enemy(name, wghp[0], wghp[1], defat[0], defat[1], queue1);
    addchar(en, listaenalive, listaen);
    return en;
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
    int[] dmwg = twoStatConstructor(10, 10, 7, 5);
    return new Knife(name, dmwg[0], dmwg[1]);
  }

  public Bow createBow(String name) {
    int[] dmwg = twoStatConstructor(30, 15, 15, 15);
    return new Bow(name, dmwg[0], dmwg[1]);
  }

  public Axe createAxe(String name) {
    int[] dmwg = twoStatConstructor(50, 15, 20, 25);
    return new Axe(name, dmwg[0], dmwg[1]);
  }

  public void attack(GameCharacter attacker, GameCharacter target) {
    attacker.attack(target);
    endturn(attacker);
  }

  public void useMagic(Mages attacker, GameCharacter target) {
    try {
      attacker.useSpell(target);
      endturn(attacker);
    } catch (UnsupportedEquipmentException uns) {
      attacker.toActive();
    } catch (InvalidStatValueException inv) {
      attacker.toActive();
    }

  }

  public void setspell(Mages mg, Spell spl) {
    try {
      mg.setSpell(spl);
    } catch (UnsupportedEquipmentException usee) {
      System.out.println(usee);
    } finally {
      mg.toActive();
    }
  }

  public void equip(PlayerCharacter pc, Weapons wp) {
    pc.equip(wp);
    pc.toActive();
  }


  private void waitTurn(GameCharacter character) {
    queue1.remove(character);
    character.waitTurn();
  }

  public boolean onPlayerWin() {
    boolean pwin = false;
    System.out.println(listaenalive.size());
    if (listaenalive.size() == 0) {
      return true;
    } else {
      return pwin;
    }
  }

  public boolean onEnemyWin() {
    boolean ewin = false;
    if (listapcalive.size() == 0) {
      return true;
    } else {
      return ewin;
    }
  }
}
