package ege.ce.ci.age.eq.hc.model;

import ege.ce.ci.age.eq.hc.algorithm.HillClimbing;
import ege.ce.ci.age.eq.hc.observer.NotifyAction;
import ege.ce.ci.age.eq.hc.observer.Subject;

public class ProblemSolver extends Subject {
  HillClimbing hillClimbing;

  public int[] getCurrentPositions() {
    return this.hillClimbing.getCurrentPositions();
  }

  public ProblemSolver() {
    hillClimbing = new HillClimbing();
  }

  public void solveProblem() {
    hillClimbing.init(); // ALGORITMAYI ILKLER.

    this.setChanged();
    this.notifyAllObservers(NotifyAction.START);// ARAYUZDEKI SATRANC TAHTASI PANELINE BILDIRIM
                                                // GONDEREREK TAHTANIN ILK KONUMUNUN
                                                // GORUNTULENMESINI SAGLAR.

    hillClimbing.runHillClimbing(this); // ALGORITMAYI CALISTIRIR.
    this.setChanged();
    this.notifyAllObservers(NotifyAction.FINISH);// ALGORITMA CALISMA ISLEMININ BITTIGINI
                                                 // ARAYUZDEKI SATRANC TAHTASINA BILDIRIR.
  }

  public int getRandomRestartCount() {
    return this.hillClimbing.getRandomRestartCount();
  }

  public int getMoveCount() {
    return this.hillClimbing.getMoveCount();
  }

  public double getProcessTime() {
    return this.hillClimbing.getProcessTime();
  }
}
