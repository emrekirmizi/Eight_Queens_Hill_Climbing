package ege.ce.ci.age.eq.hc.factory;

import javax.swing.JFrame;

import ege.ce.ci.age.eq.hc.controller.SolveButtonController;
import ege.ce.ci.age.eq.hc.controller.StatisticButtonController;
import ege.ce.ci.age.eq.hc.view.ButtonPanel;
import ege.ce.ci.age.eq.hc.view.ChessPanel;
import ege.ce.ci.age.eq.hc.view.StatisticPanel;

public interface AbstractGUIFactory {
  public JFrame createEightQueenFrame();

  public ChessPanel createChessPanel();

  public ButtonPanel createButtonPanel();

  public SolveButtonController createSolveButtonController();

  public StatisticButtonController createStatisticButtonController();

  public JFrame createStatisticFrame();

  public StatisticPanel createStatisticPanel();
}
