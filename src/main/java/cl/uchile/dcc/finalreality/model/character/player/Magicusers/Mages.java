package cl.uchile.dcc.finalreality.model.character.player.Magicusers;

import cl.uchile.dcc.exceptions.InvalidStatValueException;
import cl.uchile.dcc.exceptions.UnsupportedEquipmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.magic.Spell;

public interface Mages extends PlayerCharacter {
  /**
   * This method check out different conditions before the use and effect of the equipped spell.
   *
   * <p>This method is <b>public</b>, because it will be called
   * by methods in the {@code ChannelingMgWp} classes.</p>
   */
  void channelmana(GameCharacter gmCha)
      throws InvalidStatValueException, UnsupportedEquipmentException;

  /**
   * Start the implementation of double dispatch disambiguating the type
   * of the {@code Spell}, calling a method implemented into it.
   *
   * @param spl the Spell that it's trying to set to the Mage.
   */
  void setSpell(Spell spl) throws UnsupportedEquipmentException;

  /**
   * Reduce the {@code currentMp} of the character the amount given in {@code value}.
   *
   * <p>This method is <b>public</b>, because it will be called
   * by methods in the Spell classes to change value of {@code MP}
   * when casting a spell.</p>
   */
  void reduceMp(int value);

  /**
   * Method that is used by this character to cast a Spell onto another.
   *
   * @param target the {@code GameCharacter} that will recieve the Spell.
   */
  void useSpell(GameCharacter target)
      throws UnsupportedEquipmentException, InvalidStatValueException;

}
