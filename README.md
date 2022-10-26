Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

**This implementation uses a base repository wich is facilitated by dcc-cc3002.**

The repository given had a lot of bad practices, and i implemented some changes that i think could
help improving the implementations and the code.

I started looking and making changes in the package that contains the weapons:

The first change was create new classes, one every weapon to eventually replace class WeaponType.
The reason behind this change it's that use an enum to separate the different types 
of weapons, it's a bad implementation that can break the O in SOLID (Open to add, Close to changes) using the 
Weapon class: 
If one of the Weapons has a particularity, then you have to change methods to implement it without changing the others
beacuse all of their methods are implemented in the Weapon class.

Following the creation of Classes for every single Weapon, i made an interface Weapons and
an AbstractWeapon Class, the first one can be used when you declare a variable in a methods like equip.
And the Second one is to have the getters, setters and the data defined in the same place without 
code replication (Those methods and data are general for every weapon). This way the weapon classes
only have the methods: Constructor, Equals, Hashcode and ToString.

I didn't create an interface and an AbstractClass for the MagicWeapons (only Staff for now), beacuse it's not 
part of the requerimets yet, and since there's still no methods that requires that separation it only be usefull
in this part.



