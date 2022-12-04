package cl.uchile.dcc.finalreality.model.magic.BMgc;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class ThunderSpell extends AbstractBMSpell{
  public ThunderSpell() {
    super(71);
  }

  @Override
  public void castspell(GameCharacter gmcha, int mgdmg, int numalea) {
    if (numalea>getProbrequired()) {
      gmcha.Thunder(mgdmg);
    }
    gmcha.reduceHp(mgdmg);
  }

}
