package cl.uchile.dcc.finalreality.model.magic.BMgc;


import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class FireSpell extends AbstractBMSpell{
  public FireSpell() {
    super(81);
  }

  @Override
  public void castspell(GameCharacter gmcha, int mgdmg, int numalea) {
    if (numalea>getProbrequired()) {
      gmcha.Burn(mgdmg);
    }
    gmcha.reduceHp(mgdmg);
  }
}
