package cl.uchile.dcc.finalreality.model.States.MainStates;

public class ActiveState extends AbstractMainState {

  @Override
  public void toactive() {
    this.changeState(new ActiveState());
  }

  @Override
  public void toinactive() {
    this.changeState(new InactiveState());
  }

  @Override
  public void todead() {
    this.changeState(new DeadState());
  }

  @Override
  public boolean isActive() {
    return true;
  }

}
