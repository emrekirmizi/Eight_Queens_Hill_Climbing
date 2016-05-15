package ege.ce.ci.age.eq.hc.factory;

import ege.ce.ci.age.eq.hc.model.ProblemSolver;

public class EightQueenFactory implements AbstractEightQueenFactory {
  @Override
  public ProblemSolver createSolution() {
    return new ProblemSolver();
  }

  @Override
  public AbstractGUIFactory createGUI() {
    return new GUIFactory();
  }
}
