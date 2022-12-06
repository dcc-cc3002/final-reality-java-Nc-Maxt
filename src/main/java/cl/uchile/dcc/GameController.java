package cl.uchile.dcc;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapons;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.random.RandomGenerator;

public class GameController {

  private final BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();
  private final ArrayList<PlayerCharacter> listapc = new ArrayList<>() ;
  private final ArrayList<Enemy> listaen = new ArrayList<>() ;
  private final Random seed;

  public GameController() {
    this(new Random());
  }

  public GameController(Random kernel) {
    this.seed = kernel;
    //for(int i = 1; i <= (seed.nextInt(2)+5); i = i + 1){

      // TODO: Add enemies to the game
      // TODO: Add players to the game
      // TODO: Add characters to the turns queue
    //}
  }

  public RandomGenerator getseed() {
    return seed;
  }




  public void createEngineer(String name , int hp, int defense, Weapons weapon) {
    // TODO: Create a player character
    // hp = 200, def 70
  }
  public void createKnight(String name , int hp, int defense, Weapons weapon) {
    // TODO: Create a player character
    // hp = 300, def 150

  }
  public void createThief(String name , int hp, int defense, Weapons weapon) {
    // TODO: Create a player character
    // hp 250, def 25
  }
  public void createBlackMage(String name , int hp, int defense, Weapons weapon) {
    // TODO: Create a player character
    // hp 100, def 50, mp 70
  }

  public void createWhiteMage(String name , int hp, int defense, Weapons weapon) {
    // TODO: Create a player character
    // hp 100, def 50, mp 80
  }

  public void createEnemy(String name, int hp, int defense, int weight) {
    // TODO: Create an enemy character
    // hp 500, def 100, weight 50
  }

  public void attack(GameCharacter attacker, GameCharacter target) {
    attacker.attack(target);
  }

  public void useMagic(GameCharacter attacker, GameCharacter target) throws UnsupportedEquipmentException, InvalidStatValueException {
    attacker.useSpell(target);
  }

  public void waitTurn(GameCharacter character) {
    character.waitTurn();
    // TODO: Call the waitTurn method of the character
  }

  public void onPlayerWin() {
    // TODO: Handle the player winning the game
  }

  public void onEnemyWin() {
    // TODO: Handle the enemy winning the game
  }

}
