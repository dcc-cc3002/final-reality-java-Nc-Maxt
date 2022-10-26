package cl.uchile.dcc;

/*
 * "Final Reality" (c) by R8V and NM
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.*;
import cl.uchile.dcc.finalreality.model.character.player.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Testing methods that only implies Characters.
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 *
 */
public class MainCharacters {
  /**
   *   Test using Characters and methods that only use Characters.
   *
   */
  public static void main(String[] args) throws InvalidStatValueException {
    System.out.println("--- Character testing---");
    System.out.println("--- Constructors ---");

    BlockingQueue<GameCharacter> queue1 = new LinkedBlockingQueue<>();
    BlockingQueue<GameCharacter> queue2 = new LinkedBlockingQueue<>();

    System.out.println("--- Enemy ---");
    Enemy badp1 = new Enemy("Steven", 50, 32, 10, queue1);
    Enemy badp2 = new Enemy("Steven", 50, 32, 10, queue2);
    Enemy badcroissant = new Enemy("Steven", 80, 502, 2, queue1);
    Enemy badcroissant2_0 = new Enemy("Stif", 40, 19, 40, queue1);
    System.out.println();

    System.out.println("--- Engineer ---");
    Engineer Egn_1 = new Engineer("Tim", 30, 15, queue1);
    Engineer Egn_2 = new Engineer("Mark", 41, 30, queue2);
    Engineer Egn_3 = new Engineer("Mark", 41, 30, queue1);
    System.out.println();

    System.out.println("--- Knight ---");
    Knight Kgt_1 = new Knight("Petrick", 120, 40, queue1);
    Knight Kgt_2 = new Knight("Petrick", 120, 40, queue1);
    Knight Kgt_3 = new Knight("Simon", 90, 70, queue2);
    System.out.println();

    System.out.println("--- Thief ---");
    Thief Tf_1 = new Thief("Balze", 30, 15, queue1);
    Thief Tf_2 = new Thief("Balze", 30, 15, queue1);
    Thief Tf_4 = new Thief("Mathew", 60, 3, queue2);
    System.out.println();

    System.out.println("--- Black Mage ---");
    BlackMage Bm_1 = new BlackMage("Azrael", 20, 35, 40, queue1);
    BlackMage Bm_2 = new BlackMage("Azrael", 20, 35, 40, queue1);
    BlackMage Bm_3 = new BlackMage("Thomas", 45, 28, 50, queue2);
    System.out.println();

    System.out.println("--- White Mage ---");
    WhiteMage Wm_1 = new WhiteMage("Judas", 56, 64, 32, queue1);
    WhiteMage Wm_2 = new WhiteMage("Judas", 56, 64, 32, queue1);
    WhiteMage Wm_3 = new WhiteMage("Kvote", 435, 13, 130, queue2);
    System.out.println();

    System.out.println("--- Equals ---");
    System.out.println("Is Enemy badp1 equal to Enemy badp2?" + badp1.equals(badp2));
    System.out.println("Is Enemy badp2 equal to Enemy badp1?" + badp2.equals(badp1));
    System.out.print("Is Enemy badcroissant2_0 equal to Enemy badp2?");
    System.out.println(badcroissant2_0.equals(badp2));
    System.out.println();

    System.out.println("Is Engineer Eng_1 equal to Engineer Eng_2?" + Egn_1.equals(Egn_2));
    System.out.println("Is Engineer Eng_2 equal to Engineer Eng_1?" + Egn_2.equals(Egn_1));
    System.out.println("Is Engineer Eng_2 equal to Engineer Eng_3?" + Egn_2.equals(Egn_3));
    System.out.println();

    System.out.println("Is Knight Kgt_1 equal to Knight Kgt_2?" + Kgt_1.equals(Kgt_2));
    System.out.println("Is simetric?" + Kgt_2.equals(Kgt_1));
    System.out.println("Is Knight Kgt_2 equal to Knight Kgt_3?" + Kgt_2.equals(Kgt_3));
    System.out.println();

    System.out.println("Is Thief Tf_1 equal to Thief Tf_2?" + Tf_1.equals(Tf_2));
    System.out.println("Is simetric?" + Tf_2.equals(Tf_1));
    System.out.println("Is Thief Tf_2 equal to Thief Tf_4?" + Tf_2.equals(Tf_4));
    System.out.println();

    System.out.println("Is BlackMage Bm_1 equal to BlackMage Bm_2?" + Bm_1.equals(Bm_2));
    System.out.println("Is simetric?" + Bm_2.equals(Bm_1));
    System.out.println("Is BlackMage Bm_2 equal to BlackMage Bm_3?" + Bm_2.equals(Bm_3));
    System.out.println();

    System.out.println("Is WhiteMage Wm_1 equal to WhiteMage Wm_2?" + Wm_1.equals(Wm_2));
    System.out.println("Is simetric?" + Wm_2.equals(Wm_1));
    System.out.println("Is WhiteMage Wm_2 equal to WhiteMage Wm_3?" + Wm_2.equals(Wm_3));
    System.out.println();

    System.out.println("--- Equals between different Classes ---");
    System.out.print("Is Enemy badcroissant equal to WhiteMage Wm_3?");
    System.out.println(badcroissant.equals(Wm_3));
    System.out.print("Is WhiteMage Wm_3 equal to Enemy badcroissant?");
    System.out.println(Wm_3.equals(badcroissant));
    System.out.print("Is Thief Tf_2 equal to Knight Kgt_1?");
    System.out.println(Tf_2.equals(Kgt_1));
    System.out.print("Is Knight Kgt_1 equal to Thief tf_2?");
    System.out.println(Kgt_1.equals(Tf_2));
    System.out.print("Is BlackMage Bm_1 to Engineer Eng_3 ?");
    System.out.println(Bm_1.equals(Egn_3));
    System.out.print("Is Engineer Eng_3 equal to BlackMage Bm_1 ?");
    System.out.println(Egn_3.equals(Bm_1));
    System.out.println();

    System.out.println("--- Equals between same instance ---");
    System.out.println("Is Enemy badcroissant equal to Enemy badcroissant?" + badcroissant.equals(badcroissant));
    System.out.println("Is Thief Tf_4 equal to Thief Tf_4?" + Tf_4.equals(Tf_4));
    System.out.println("Is Knight Kgt_3 equal to Knight Kgt_3?" + Kgt_3.equals(Kgt_3));
    System.out.println("Is Engineer Egn_2 equal to Engineer Egn_2?" + Egn_2.equals(Egn_2));
    System.out.println("Is WhiteMage Wm_2 asw equal to WhiteMage Wm_2?" + Wm_2.equals(Wm_2));
    System.out.println("Is BlackMage Bm_3 equal to BlackMage Bm_3 ?" + Bm_3.equals(Bm_3));
    System.out.println();
    /* Listo */
    System.out.println("--- Getters and toString ---");
    System.out.print("Data of Enemy badp1 : " + badp1.getName() + ", " + badp1.getCurrentHp() + ", " + badp1.getMaxHp());
    System.out.println(", " + badp1.getDefense() + ", " + badp1.getWeight());
    System.out.println(badp1);
    System.out.println();
    System.out.print("Data of Engineer Egn_3 : " + Egn_3.getName() + ", " + Egn_3.getCurrentHp() + ", " + Egn_3.getMaxHp());
    System.out.println(", " + Egn_3.getDefense());
    System.out.println(Egn_3);
    System.out.println();
    System.out.print("Data of Knight Kgt_2: " + Kgt_2.getName() + ", " + Kgt_2.getCurrentHp() + ", " + Kgt_2.getMaxHp());
    System.out.println(", " + Kgt_2.getDefense());
    System.out.println(Kgt_2);
    System.out.println();
    System.out.print("Data of Thief Tf_4: " + Tf_4.getName() + ", " + Tf_4.getCurrentHp() + ", " + Tf_4.getMaxHp());
    System.out.println(", " + Tf_4.getDefense());
    System.out.println(Tf_4);
    System.out.println();
    System.out.print("Data of BlackMage Bm_1: " + Bm_1.getName() + ", " + Bm_1.getCurrentHp() + ", " + Bm_1.getMaxHp());
    System.out.println(", " + Bm_1.getCurrentMp() + ", " + Bm_1.getMaxMp() + ", " + Bm_1.getDefense());
    System.out.println(Bm_1);
    System.out.println();
    System.out.print("Data of WhiteMage Wm_3: " + Wm_3.getName() + ", " + Wm_3.getCurrentHp() + ", " + Wm_3.getMaxHp());
    System.out.println(", " + Wm_3.getCurrentMp() + ", " + Wm_3.getMaxMp() + ", " + Wm_3.getDefense());
    System.out.println(Wm_3);
    System.out.println();

    System.out.println("--- Exceptions ---");
    System.out.println("--- Exceptions in Constructors  ---");
    WhiteMage Wm_test = new WhiteMage("Elias", -3, 64, 32, queue1);
    BlackMage Bm_test = new BlackMage("Isaias", 64, -3, 32, queue1);
    WhiteMage Wm_test2 = new WhiteMage("Lucy", 42, 0, -10, queue1);
    BlackMage Bm_test2 = new BlackMage("Fer", 13, 13, 0, queue1);
    Enemy Ey_test0 = new Enemy("nevets", -5, 32, 10, queue1);
    System.out.println();

    System.out.println("--- Setters and Exceptions in Hp ---");
    System.out.println(badp1.getCurrentHp());
    badp1.setCurrentHp(badp1.getCurrentHp() - 51);
    System.out.println(badp1.getCurrentHp());
    badp1.setCurrentHp(badp1.getCurrentHp() + 52);
    System.out.println(badp1.getCurrentHp());
    badp1.setCurrentHp(15);
    System.out.println(badp1.getCurrentHp());
    System.out.println();

    System.out.println("--- Setters and Exceptions in Mp ---");
    System.out.println(Wm_3.getCurrentMp());
    Wm_3.setCurrentMp(Wm_3.getCurrentMp() - 1000);
    System.out.println(Wm_3.getCurrentMp());
    Wm_3.setCurrentMp(Wm_3.getCurrentMp() + 1);
    System.out.println(Wm_3.getCurrentMp());
    Wm_3.setCurrentMp(Wm_3.getCurrentMp() - 250);
    System.out.println(Wm_3.getCurrentMp());
  }
}
