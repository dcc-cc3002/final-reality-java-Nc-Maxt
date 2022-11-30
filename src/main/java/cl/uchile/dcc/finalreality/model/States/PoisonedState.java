package cl.uchile.dcc.finalreality.model.States;

public class PoisonedState extends AbstractDmgState {

  protected PoisonedState(int dmg) {
    super(dmg);
  }

  @Override
  public void topoison(int dmg) {error();}

  @Override
  public boolean isPoisoned() {return true;}
}
