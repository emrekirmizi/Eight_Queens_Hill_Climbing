package ege.ce.ci.age.eq.hc.algorithm;

import java.util.concurrent.TimeUnit;

import ege.ce.ci.age.eq.hc.model.ProblemSolver;

public class HillClimbing {
  private Queens queens; // SATRANC TAHTASI SINIFI.
  private double currentValue; // SU ANKI ATAK SAYISI.
  private int moveCount;
  private int randomRestartCount;
  private double processTime;

  public void init() {
    this.queens = new Queens();
  }

  public void runHillClimbing(ProblemSolver problemSolver) {
    this.moveCount = 0;
    this.randomRestartCount = 0;
    this.processTime = 0;

    long start = System.nanoTime();
    this.currentValue = this.queens.initialState(); // BASLANGIC TAHTASI AYARLANIR.
    while (true) {
      double bestSuccessorValue = this.queens.generateBestSuccessor(); // YENI EN IYI ADAY URETILIR
                                                                       // VE DEGERI HESAPLANIR.
      if (bestSuccessorValue < this.currentValue) { // YENI EN IYI ADAYIN DEGERI SU ANKI DEGERDEN
                                                    // DAHA IYIDIR.
        this.queens.acceptSuccessor(); // YENI EN IYI ADAY KABUL EDILIR. TAHTA GUNCELLENIR.
        this.currentValue = bestSuccessorValue; // YENI EN IYI ADAYIN DEGERI SU ANKI DEGER OLARAK
                                                // GUNCELLENIR.
        this.moveCount++; // YER DEGISTIRME SAYISI ARTIRILIR.
        if (this.currentValue == 0) { // GENEL OPTIMUM ELDE EDILMISTIR. PROBLEM COZULMUSTUR.
          long end = System.nanoTime();
          this.processTime = TimeUnit.NANOSECONDS.toMillis(end - start);
          return;
        }
      } else { // YEREL OPTIMUMDA VEYA YAYLADA TAKILMISTIR.
        this.currentValue = this.queens.generateRandomPositions(); // RASTGELE YENI TAHTA
                                                                   // OLUSTURULUR.
        this.randomRestartCount++; // RANDOM RESTART SAYISI ARTIRILIR.
      }
    }
  }

  public int[] getCurrentPositions() {
    return this.queens.getCurrentPositions();
  }

  public int getMoveCount() {
    return this.moveCount;
  }

  public int getRandomRestartCount() {
    return this.randomRestartCount;
  }

  public double getProcessTime() {
    return this.processTime;
  }
}
