package ege.ce.ci.age.eq.hc;

import javax.swing.UIManager;

import ege.ce.ci.age.eq.hc.factory.EightQueenClient;

public class HillClimbingSimulator {
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    new EightQueenClient();
  }
}
