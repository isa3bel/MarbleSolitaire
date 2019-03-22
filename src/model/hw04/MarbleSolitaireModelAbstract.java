package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Board;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

public abstract class MarbleSolitaireModelAbstract implements MarbleSolitaireModel {
  protected int armThickness;
  protected int emptyX;
  protected int emptyY;
  protected int score;
  protected boolean isGameOver;
  protected Board board;

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    this.board.move(fromRow, fromCol, toRow, toCol);
    this.score--;
  }

  @Override
  public boolean isGameOver() {
    return this.board.isGameOver();
  }

  @Override
  public String getGameState() {
    return this.board.getGameState();
  }

  @Override
  public int getScore() {
    return this.score;
  }


}
