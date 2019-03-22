package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Board;

/**
 * Constructs a EuroBoard object that extends the Board class.
 * Allows users to play marble solitaire with different boards.
 */
public class EuroBoard extends Board {

  /**
   * Constructs an instance of a game board based on armThickness and empty space coordinates.
   *
   * @param armThickness the thickness of the squares that make up the board.
   * @param emptyX the column position of the empty space.
   * @param emptyY the row position of the empty space.
   */
  public EuroBoard(int armThickness, int emptyX, int emptyY) {
    super(armThickness, emptyX, emptyY);
  }

  @Override
  /**
   * Checks whether or not the given row and column are out of bounds.
   * @param r the row value
   * @param col the column value
   * @return whether or not the given row and column are out of bounds
   */
  protected boolean checkBoundariesFalse(int r, int col) {
    int totalLength = (this.armThickness * 3) - 2;
    return ((r < this.armThickness - 1 && col < (totalLength / 2)
        - ((this.armThickness + (2 * r)) / 2)) || // top left
        (r < this.armThickness - 1 && col > (totalLength / 2)
            + ((this.armThickness + (2 * r)) / 2)) || // top right
        (r > (totalLength / 2) + ((this.armThickness + (2 * col)) / 2)
            && col < armThickness - 1) || // bottom left
        (r > armThickness * 2 - 2 && col > (totalLength / 2)
            + ((this.armThickness + ((totalLength - r - 1) * 2)) / 2))
        || (r < 0 || r > totalLength - 1 || col > totalLength - 1 || col < 0)); // bottom right
  }




}
