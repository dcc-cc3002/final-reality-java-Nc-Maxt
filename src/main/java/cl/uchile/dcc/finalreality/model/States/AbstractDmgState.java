package cl.uchile.dcc.finalreality.model.States;

public abstract class AbstractDmgState extends AbstractState{
  private int magicdmg;

  protected AbstractDmgState(int dmg) {
    double dmgxturn = (dmg/3);
    this.magicdmg = (int) dmgxturn;
  }

  public int getMagicdmg() {
    return magicdmg;
  }

}
