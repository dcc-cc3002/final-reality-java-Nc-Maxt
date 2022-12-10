package cl.uchile.dcc.finalreality.model.States.alteredState;

import cl.uchile.dcc.finalreality.model.States.AbstractState;

public abstract class AbstractAlteredState extends AbstractState {
  protected final int maxtimeeffect;
  protected int actualtime;


  protected AbstractAlteredState(int count) {
    maxtimeeffect = count;
    actualtime = count;
  }

  protected void timereduce() {
    if (actualtime == 0) {
      tonormal();
    }
    else {
    actualtime -= 1;
    }
  }

}
