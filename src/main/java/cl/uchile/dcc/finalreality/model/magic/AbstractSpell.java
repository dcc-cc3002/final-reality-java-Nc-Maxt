package cl.uchile.dcc.finalreality.model.magic;

public abstract class AbstractSpell implements Spell {
  private int Manacost;

  protected AbstractSpell (int cost) {
    this.Manacost = cost;
  }

  public int getManacost() {
    return Manacost;
  }


}
