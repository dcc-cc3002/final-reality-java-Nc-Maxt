package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.model.weapon.*;
/**
 * Testing methods that only implies Weapons
 *
 * @author <a href="https://github.com/Nc-Maxt">NM</a>
 * @author Matias Nunez
 */
public class MainWeapons {
    public static void main(String[] args) {
        System.out.println("--- Weapons testing---");
        System.out.println("--- Constructors ---");

        System.out.println("--- Axe ---");
        Axe aa = new Axe("DemonKiller",10 , 5);
        Axe ba = new Axe("DemonKiller",10 , 5);
        Axe ca = new Axe("Copper Axe", 1, 3);

        System.out.println("--- Bow ---");
        Bow ab = new Bow("Large Bow",34 , 15);
        Bow bb = new Bow("Large Bow",34 , 15);
        Bow cb = new Bow("Bone Bow", 22, 9);

        System.out.println("--- Knife ---");
        Knife ak = new Knife("DemonKiller", 10, 5);
        Knife bk = new Knife("Moon Knife", 3, 6);
        Knife ck = new Knife("Moon Knife", 3, 6);

        System.out.println("--- Staff ---");
        Staff ast = new Staff("Demon invoquer",3 , 6);
        Staff bst = new Staff("Bonk",1000 , 2);
        Staff cst = new Staff("Bonk",1000 , 2);

        System.out.println("--- Sword ---");
        Sword asw = new Sword("Greatsword",34 , 15);
        Sword bsw = new Sword("Longsword",10 , 5);
        Sword csw = new Sword("Longsword",10 , 5);
        System.out.println();

        System.out.println("--- Equals ---");
        System.out.println("Is Axe aa equal to Axe ba?"+aa.equals(ba));
        System.out.println("Is simetric?"+ba.equals(aa));
        System.out.println("Is Axe ba equal to Axe ca?"+ba.equals(ca));
        System.out.println();

        System.out.println("Is Bow ab equal to Bow bb?"+ab.equals(bb));
        System.out.println("Is simetric?"+bb.equals(ab));
        System.out.println("Is Bow bb equal to Bow cb?"+bb.equals(cb));
        System.out.println();

        System.out.println("Is Knife ak equal to Knife bk?"+ak.equals(bk));
        System.out.println("Is Knife bk equal to Knife ak?"+bk.equals(ak));
        System.out.println("Is Knife bk equal to Knife ck?"+bk.equals(ck));
        System.out.println();

        System.out.println("Is Staff ast equal to Staff bst?"+ast.equals(bst));
        System.out.println("Is Staff bst equal to Staff ast?"+bst.equals(ast));
        System.out.println("Is Staff bst equal to Staff cst?"+bst.equals(cst));
        System.out.println();

        System.out.println("Is Sword asw equal to Sword bsw?"+asw.equals(bsw));
        System.out.println("Is Sword bsw equal to Sword asw?"+bsw.equals(asw));
        System.out.println("Is Sword bst equal to Sword cst?"+bsw.equals(csw));
        System.out.println();

        System.out.println("--- Equals between different Classes ---");
        System.out.println("Is Knife ak equal to Axe aa?"+ak.equals(aa));
        System.out.println("Is Axe aa equal to Knife ak?"+aa.equals(ak));
        System.out.println("Is Sword asw equal to Bow bb ?"+asw.equals(bb));
        System.out.println("Is Bow bb equal to Sword asw ?"+bb.equals(asw));
        System.out.println("Is Staff ast equal to Bow cb ?"+ast.equals(cb));
        System.out.println("Is Bow cb equal to Staff ast ?"+cb.equals(ast));
        System.out.println();

        System.out.println("--- Equals between same instance ---");
        System.out.println("Is Axe aa equal to Axe aa?"+aa.equals(aa));
        System.out.println("Is Bow bb equal to Bow bb?"+bb.equals(bb));
        System.out.println("Is Knife ck equal to Knife ck?"+ck.equals(ck));
        System.out.println("Is Staff bst equal to Staff bst?"+bst.equals(bst));
        System.out.println("Is Sword asw equal to Sword asw?"+asw.equals(asw));
        System.out.println();

        System.out.println("--- Getters and toString ---");
        System.out.println("Data of Axe ba: "+ba.getName()+", "+ba.getDamage()+", "+ba.getWeight());
        System.out.println(ba);
        System.out.println("Data of Bow cb: "+cb.getName()+", "+cb.getDamage()+", "+cb.getWeight());
        System.out.println(cb);
        System.out.println("Data of Knife ak: "+ak.getName()+", "+ak.getDamage()+", "+ak.getWeight());
        System.out.println(ak);
        System.out.println("Data of Staff bst: "+bst.getName()+", "+bst.getDamage()+", "+bst.getWeight());
        System.out.println(bst);
        System.out.println("Data of Sword csw: "+csw.getName()+", "+csw.getDamage()+", "+csw.getWeight());
        System.out.println(csw);
    }
}
