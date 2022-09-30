package cl.uchile.dcc;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.*;
import cl.uchile.dcc.finalreality.model.character.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainCharacters {
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
        /**try {
         Thief Tf_1 = new Thief("Balze", 30, 15, queue1);
         } catch (InvalidStatValueException inv){
         System.out.println(badp1.getName()+" died");
         }*/
        System.out.println();

        System.out.println("--- Black Mage ---");
        BlackMage Bm_1 = new BlackMage("Azrael", 20, 35, 40 ,queue1);
        BlackMage Bm_2 = new BlackMage("Azrael", 20, 35, 40 ,queue1);
        BlackMage Bm_3 = new BlackMage("Thomas", 45, 28, 50 ,queue2);
        System.out.println();

        System.out.println("--- White Mage ---");
        WhiteMage Wm_1 = new WhiteMage("Judas", 56, 64, 32 ,queue1);
        WhiteMage Wm_2 = new WhiteMage("Judas", 56, 64, 32 ,queue1);
        WhiteMage Wm_3 = new WhiteMage("Kvote", 435, 13, 130 ,queue2);
        System.out.println();

        System.out.println("--- Equals ---");
        System.out.println("Is Enemy badp1 equal to Enemy badp2?"+badp1.equals(badp2));
        System.out.println("Is simetric?"+badp2.equals(badp1));
        System.out.println("Is Enemy badcroissant2_0 equal to Enemy badp2?"+badcroissant2_0.equals(badp2));
        System.out.println();

        System.out.println("Is Engineer Eng_1 equal to Engineer Eng_2?"+Egn_1.equals(Egn_2));
        System.out.println("Is simetric?"+Egn_2.equals(Egn_1));
        System.out.println("Is Engineer Eng_2 equal to Engineer Eng_3?"+Egn_2.equals(Egn_3));
        System.out.println();

        System.out.println("Is Knight Kgt_1 equal to Knight Kgt_2?"+Kgt_1.equals(Kgt_2));
        System.out.println("Is simetric?"+Kgt_2.equals(Kgt_1));
        System.out.println("Is Knight Kgt_2 equal to Knight Kgt_3?"+Kgt_2.equals(Kgt_3));
        System.out.println();

        System.out.println("Is Thief Tf_1 equal to Thief Tf_2?"+Tf_1.equals(Tf_2));
        System.out.println("Is simetric?"+Tf_2.equals(Tf_1));
        System.out.println("Is Thief Tf_2 equal to Thief Tf_4?"+Tf_2.equals(Tf_4));
        System.out.println();

        System.out.println("Is BlackMage Bm_1 equal to BlackMage Bm_2?"+Bm_1.equals(Bm_2));
        System.out.println("Is simetric?"+Bm_2.equals(Bm_1));
        System.out.println("Is BlackMage Bm_2 equal to BlackMage Bm_3?"+Bm_2.equals(Bm_3));
        System.out.println();

        System.out.println("Is WhiteMage Wm_1 equal to WhiteMage Wm_2?"+Wm_1.equals(Wm_2));
        System.out.println("Is simetric?"+Wm_2.equals(Wm_1));
        System.out.println("Is WhiteMage Wm_2 equal to WhiteMage Wm_3?"+Wm_2.equals(Wm_3));
        System.out.println();

        System.out.println("--- Equals between different Classes ---");
        System.out.println("Is Enemy badcroissant equal to WhiteMage Wm_3?"+badcroissant.equals(Wm_3));
        System.out.println("Is WhiteMage Wm_3 equal to Enemy badcroissant?"+Wm_3.equals(badcroissant));
        System.out.println("Is Thief Tf_2 equal to Knight Kgt_1?"+Tf_2.equals(Kgt_1));
        System.out.println("Is Knight Kgt_1 equal to Thief tf_2?"+Kgt_1.equals(Tf_2));
        System.out.println("Is BlackMage Bm_1 to Engineer Eng_3 ?"+Bm_1.equals(Egn_3));
        System.out.println("Is Engineer Eng_3 equal to BlackMage Bm_1 ?"+Egn_3.equals(Bm_1));
        System.out.println();

        System.out.println("--- Equals between same instance ---");
        System.out.println("Is Enemy badcroissant equal to Enemy badcroissant?"+badcroissant.equals(badcroissant));
        System.out.println("Is Thief Tf_4 equal to Thief Tf_4?"+Tf_4.equals(Tf_4));
        System.out.println("Is Knight Kgt_3 equal to Knight Kgt_3?"+Kgt_3.equals(Kgt_3));
        System.out.println("Is Engineer Egn_2 equal to Engineer Egn_2?"+Egn_2.equals(Egn_2));
        System.out.println("Is WhiteMage Wm_2 asw equal to WhiteMage Wm_2?"+Wm_2.equals(Wm_2));
        System.out.println("Is BlackMage Bm_3 equal to BlackMage Bm_3 ?"+Bm_3.equals(Bm_3));
        System.out.println();


        try {
            badp1.setCurrentHp(badp1.getCurrentHp()-51);
        }
        catch (InvalidStatValueException inv){
            System.out.println(badp1.getName()+" died");
            badp1.setCurrentHp(0);
        }
    }
}
