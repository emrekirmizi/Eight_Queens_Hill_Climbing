package ege.ce.ci.age.eq.hc.factory;

import javax.swing.JFrame;

import ege.ce.ci.age.eq.hc.controller.SolveButtonController;
import ege.ce.ci.age.eq.hc.controller.StatisticButtonController;
import ege.ce.ci.age.eq.hc.view.ButtonPanel;
import ege.ce.ci.age.eq.hc.view.ChessPanel;
import ege.ce.ci.age.eq.hc.view.StatisticPanel;

public class GUIFactory implements AbstractGUIFactory {
  @Override
  public JFrame createEightQueenFrame() {
    return new JFrame();
  }

  @Override
  public ChessPanel createChessPanel() {
    return new ChessPanel();
  }

  @Override
  public ButtonPanel createButtonPanel() {
    return new ButtonPanel();
  }

  @Override
  public SolveButtonController createSolveButtonController() {
    return new SolveButtonController();
  }

  @Override
  public StatisticButtonController createStatisticButtonController() {
    return new StatisticButtonController();
  }

  @Override
  public JFrame createStatisticFrame() {
    return new JFrame();
  }

  @Override
  public StatisticPanel createStatisticPanel() {
    return new StatisticPanel();
  }
}
