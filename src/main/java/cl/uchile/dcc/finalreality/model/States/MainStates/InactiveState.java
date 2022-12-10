package cl.uchile.dcc.finalreality.model.States.MainStates;

public class InactiveState extends AbstractMainState {

  @Override
  public void toactive() {
    this.changeState(new ActiveState());
  }


  @Override
  public void todead() {
    this.changeState(new DeadState());
  }

  @Override
  public boolean isInactive() {
    return true;
  }
}
