package ege.ce.ci.age.eq.hc.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ege.ce.ci.age.eq.hc.model.ProblemSolver;
import ege.ce.ci.age.eq.hc.observer.NotifyAction;
import ege.ce.ci.age.eq.hc.observer.Observer;
import ege.ce.ci.age.eq.hc.observer.Subject;

public class StatisticPanel extends JPanel implements Observer {
  private static final long serialVersionUID = -2299996637736692394L;
  private JLabel[][] fields;
  private JPanel panel = new JPanel(new GridLayout(28, 3));
  int dataCount = 1;

  public StatisticPanel() {
    this.add(panel);
    this.init();
  }

  private void init() {
    this.fields = new JLabel[28][3];
    for (int r = 0; r < 28; r++) {
      for (int c = 0; c < 3; c++) {
        this.fields[r][c] = new JLabel();
        this.fields[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.fields[r][c].setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(this.fields[r][c]);
      }
    }
    fields[0][0].setText("Move Count");
    fields[0][1].setText("Random Restart Count");
    fields[0][2].setText("Process Time(millis)");

    fields[26][0].setText("Mean");
    fields[26][1].setText("Mean");
    fields[26][2].setText("Mean(millis)");

    fields[27][0].setText("0");
    fields[27][1].setText("0");
    fields[27][2].setText("0");
  }

  public void addStatistic(ProblemSolver s) {
    if (dataCount > 25) {
      dataCount = 1;
      this.clear();
      this.init();
    }
    fields[dataCount][0].setText(String.valueOf(s.getMoveCount()));
    fields[dataCount][1].setText(String.valueOf(s.getRandomRestartCount()));
    fields[dataCount][2].setText(String.valueOf(s.getProcessTime()));

    Double currentMeanOfMoveCount = Double.valueOf(fields[27][0].getText());
    fields[27][0].setText(
        String.valueOf((currentMeanOfMoveCount * (dataCount - 1) + s.getMoveCount()) / dataCount));
    Double currentMeanOfRandomRestart = Double.valueOf(fields[27][1].getText());
    fields[27][1].setText(String.valueOf(
        (currentMeanOfRandomRestart * (dataCount - 1) + s.getRandomRestartCount()) / dataCount));
    Double currentMeanOfTime = Double.valueOf(fields[27][2].getText());
    fields[27][2].setText(
        String.valueOf((currentMeanOfTime * (dataCount - 1) + s.getProcessTime()) / dataCount));
    dataCount++;
  }

  public void clear() {
    for (int r = 0; r < 28; r++) {
      for (int c = 0; c < 3; c++) {
        panel.remove(this.fields[r][c]);
      }
    }
  }


  @Override
  public void update(Subject s, NotifyAction action) {
    switch (action) {
      case FINISH:
        addStatistic((ProblemSolver) s);
        break;
      default:
        break;
    }
  }
}
