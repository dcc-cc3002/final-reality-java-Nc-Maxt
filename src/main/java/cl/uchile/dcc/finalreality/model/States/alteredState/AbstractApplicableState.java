package cl.uchile.dcc.finalreality.model.States.alteredState;

public abstract class AbstractApplicableState extends AbstractAlteredState {
  protected final int maxtimeeffect;
  protected int actualtime;


  protected AbstractApplicableState(int count) {
    maxtimeeffect = count;
    actualtime = count;
  }

  protected void timereduce() {
    if (actualtime == 0) {
      tonormal();
    } else {
      actualtime -= 1;
    }
  }

}
