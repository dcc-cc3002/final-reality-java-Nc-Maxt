package cl.uchile.dcc.finalreality.model.States;

public class BurningState extends AbstractDmgState {
  protected BurningState(int dmg) {
    super(dmg);
  }

  @Override
  public void toburn(int dmg) {error();}

  @Override
  public boolean isBurning() {return true;}
}
