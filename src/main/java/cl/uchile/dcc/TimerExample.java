package cl.uchile.dcc;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.*;
import cl.uchile.dcc.finalreality.model.character.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Testing methods that implies Weapons and Characters
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class TimerExample {

  public static void main(String[] args)
      throws InterruptedException{
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    WhiteMage Wm_3 = new WhiteMage("Kvote", 435, 13, 130 ,queue);
    Enemy badcroissant2_0 = new Enemy("Stif", 40, 234, 20, queue);
    Axe ba = new Axe("DemonKiller",10 , 5);
    Knife ck = new Knife("Moon Knife", 3, 6);
    Bow cb = new Bow("Bone Bow", 22, 9);
    Staff bst = new Staff("Bonk",1000 , 2);
    ArrayList<Weapons> Bag = new ArrayList<Weapons>();
    Bag.add(ck);
    Bag.add(ba);
    Bag.add(cb);
    Bag.add(bst);
    for (int i = 0; i < 4; i++) {
      System.out.println(Wm_3.getEquippedWeapon());
      Wm_3.equip(Bag.get(i));
      System.out.println(Wm_3.getEquippedWeapon());
      System.out.println(Wm_3.getName()+" Attacks "+ badcroissant2_0.getName());
      badcroissant2_0.setCurrentHp(badcroissant2_0.getCurrentHp()-Wm_3.getEquippedWeapon().getDamage());
      System.out.println(badcroissant2_0.getCurrentHp());
    }
    Wm_3.waitTurn();
    badcroissant2_0.waitTurn();
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(queue.poll().toString());
    }
  }
}
