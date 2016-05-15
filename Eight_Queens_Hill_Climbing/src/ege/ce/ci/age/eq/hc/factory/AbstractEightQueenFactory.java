package ege.ce.ci.age.eq.hc.factory;

import ege.ce.ci.age.eq.hc.model.ProblemSolver;

public interface AbstractEightQueenFactory {
  public ProblemSolver createSolution();

  public AbstractGUIFactory createGUI();
}
