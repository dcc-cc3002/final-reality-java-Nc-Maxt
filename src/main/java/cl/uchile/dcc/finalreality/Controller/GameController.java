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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController implements PropertyChangeListener {

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

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    if (evt.getPropertyName() == "dead") {
      queue1.remove(evt.getSource());
    }
  }

  public int getseed() {
    return seed;
  }


  public Engineer createEngineer(String name) {
    int maxHp = generator.nextInt(40) + 200;
    int def = generator.nextInt(30) + 90;
    return new Engineer(name, maxHp, def, queue1);
    // hp = 200, def 70
    // , Weapons weapon
  }

  public Knight createKnight(String name) {
    int maxHp = generator.nextInt(80) + 300;
    int def = generator.nextInt(25) + 150;
    return new Knight(name, maxHp, def, queue1);
    // hp = 300, def 150
    // , Weapons weapon
  }

  public Thief createThief(String name) {
    int maxHp = generator.nextInt(40) + 160;
    int def = generator.nextInt(35) + 25;
    return new Thief(name, maxHp, def, queue1);
    // hp 250, def 25
    // , Weapons weapon
  }

  public BlackMage createBlackMage(String name) {
    int maxMp = generator.nextInt(60) + 70;
    int maxHp = generator.nextInt(40) + 80;
    int def = generator.nextInt(30) + 80;
    return new BlackMage(name, maxHp, def, maxMp, queue1);
    // hp 100, def 50, mp 70
    // , Weapons weapon
  }

  public WhiteMage createWhiteMage(String name) {
    int maxMp = generator.nextInt(50) + 80;
    int maxHp = generator.nextInt(40) + 120;
    int def = generator.nextInt(30) + 60;
    return new WhiteMage(name, maxHp, def, maxMp, queue1);
    // Falta añadir el arma y crearla
    // hp 100, def 50, mp 80
  }

  public Enemy createEnemy(String name) {
    int weight = generator.nextInt(30) + 50;
    int maxHp = generator.nextInt(100) + 500;
    int def = generator.nextInt(50) + 80;
    int attack = generator.nextInt(30) + 20;
    return new Enemy(name, weight, maxHp, def, attack, queue1);
    // hp 500, def 100, weight 50
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
    // TODO: Handle the player winning the game
  }

  public boolean onEnemyWin() {
    boolean ewin = true;
    for (PlayerCharacter pc : listapc) {
      if (pc.getCurrentHp() != 0) {
        ewin = false;
      }
    }
    return ewin;
    // TODO: Handle the enemy winning the game
  }


}
