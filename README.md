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

The first change was create new classes, one for every weapon to eventually replace the WeaponType class.
The reason behind this change it's that use an enum to separate the different types 
of weapons, it's a bad implementation that can break the O in SOLID (Open to add, Close to changes), using the 
Weapon class: 
If one of the Weapons has a particularity, then you have to change some methods to implement it.

Following the creation of Classes for every single Weapon, i made an interface called "Weapons" and
an AbstractWeapon Class. The first one can be used when you declare a variable in a methods like equip.
And the Second one is to have the getters, setters and the data defined in the same place without 
code replication (Those methods and data are general for every weapon). This way the weapon classes
enden having only Constructor, Equals, Hashcode and ToString methods.

I didn't create an interface and an AbstractClass for the MagicWeapons (only Staff for now), beacuse it's not 
part of the requerimets yet, and since there's still no methods that requires that separation it only be unusefull
in this part.

**This part concludes with the erradication of WeaponTypes and Weapon Classes.**

When i ended this changes in the Weapon part, i started to read and analyze the Characters code and it´s
implementations.

The first problem i detected was in AbstractCharacter, in this Class the method WaitTurn used instanceof
to distinguish between Enemies, and PlayerCharacter. To resolve this i refactored this method and addToQeue with 
the parameter ScheduleExcecutorService (this to avoid breaking something with the methods that i didn´t
understand how worked, but in the end addToQeue and the parameter should have stayed without changes
to avoid code duplication this error it´s fixed in the lastest update), to both Classes.

Other thing that i added was a AbstractMage Class to refactor the common methods and behavior
of Black and White Mage Classes (getters, setters and constructors).

After this i started to add documentation, and testing. With the Testing Classes, i started to implement exceptions
and handling those in the constructors and setters when required.

**End of Part 1**

Part 2: Testing and Weapon Restrictions
---
The second part of this semestral Project was oriented to Testing and the implementation of the different
restriccions that the Weapons had. 

The first thing that i did in this part was change and refactor all the thest that were in main classes
 to the TestClass that correspond depending on the class in wich the method was implemented or inherited.

After most of the test were refactored and created, i implemented the restrictions using double dispatch:
For this i create a interface for every set of weapons for the differents PlayerCharacter, this to be instanciated by 
methods in ther contract, and a new exception class that's throwed when u try to equip a weapon that's not part of 
the interface for a PlayerCharacter called "InvalidStatValueException".

The implementation of Double Dispatch used a lot of new methods and it will be explained by how are called, using 
by example the names of the BlackMage Class and it's methods (the implementation in the other Player Character classes
are analogous):

First equip was changed from directly equip the weapon to call a method in the Weapons called like 
"equippedByBlackMage" (changing the last part depending on the PlayerCharacter Class), and handle an Excepction in case 
some is thrown by the other method. The message to the method equippedByBlackMage desambiguates the weapon. This method
throws an InvalidStatValueException or call a method in the BlackMage Class depending 
if the Weapon it´s not part of the set of equippable Weapons for this class (that are grouped in the interface 
"UsedByBlackMage"). If it is the method in the weapon message the method "equipusedbyblackmage" in BlackMage Class.
And this one mesagge the method underequip that's in AbstractPlayerCharacter and aquip the Weapon.

All the methods except for underequip are public, beacuse it will be called by other classes. The method underequip is
protected, the reason is to "equipusedbyblackmage" (and it's analogous) recieve first the weapon and only accept like 
parameter weapons that are part of the interface that corresponds. If it's not in this way, a user could 
use directly underequip and end with a weapon that shouldn´t be equipped by certain character.

**End of Part 2**

