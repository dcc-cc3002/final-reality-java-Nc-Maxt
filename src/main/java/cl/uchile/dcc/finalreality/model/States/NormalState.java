package cl.uchile.dcc.finalreality.model.States;

public class NormalState extends AbstractState{

  @Override
  public void tonormal() {error();}

  @Override
  public boolean isNormal() {return true;}

}
