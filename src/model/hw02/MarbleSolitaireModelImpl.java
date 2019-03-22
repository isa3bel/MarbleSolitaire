package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.MarbleSolitaireModelAbstract;

/**
 * Represents a Marble Solitaire game object.
 */
public class MarbleSolitaireModelImpl extends MarbleSolitaireModelAbstract
    implements MarbleSolitaireModel {
  /**
   * Constructs an instance of the Marble Solitaire game based on no parameters.
   */

  public MarbleSolitaireModelImpl() {
    this(3,3,3);
  }
  /**
   * Constructs an instance of the Marble Solitaire game based on sRow and sCol.
   * @param row the row number of the empty space
   * @param col the column number of the empty space
   * @throws IllegalArgumentException if the positions of the empty space are invalid
   */

  public MarbleSolitaireModelImpl(int row, int col) {
    this(3, row, col);
  }
  /**
   * Constructs an instance of the Marble Solitaire game based on armThickness.
   * @param armThickness the thickness of each square on the game board
   * @throws IllegalArgumentException if the armThickness is not a positive, odd number
   */

  public MarbleSolitaireModelImpl(int armThickness) {
    this(armThickness, 3,3);
  }
  /**
   * Constructs an instance of the Marble Solitaire game based on armThickness, row, and column of
   * empty space.
   * @param armThickness the thickness of each square on the game board
   * @param row the row number of the empty space
   * @param col the column number of the empty space
   * @throws IllegalArgumentException if none of the fields are valid
   */

  public MarbleSolitaireModelImpl(int armThickness, int row, int col) {
    if (!((armThickness > 0) && (armThickness % 2 == 1))) {
      throw new IllegalArgumentException("Arm thickness must be a positive, odd number");
    } else if ((row < armThickness - 1 && col < armThickness - 1) || // top left
        (row < armThickness - 1 && col > ((2 * armThickness) - 2)) || // top right
        (row > ((armThickness * 2) - 2) && col < armThickness - 1) || // bottom left
        (row > ((armThickness * 2) - 2) && col > ((2 * armThickness) - 2)) || // bottom right
        (row < 0 || row > ((armThickness * 3) - 2) || col > ((armThickness * 3) - 2) || col < 0)) {
      throw new IllegalArgumentException("Row and column must be valid");
    } else {
      this.armThickness = armThickness;
      this.emptyX = row;
      this.emptyY = col;
      this.isGameOver = false;
      this.score = (armThickness * armThickness * 5) - (armThickness * 4) - 1;
      this.board = new Board(this.armThickness,this.emptyX,this.emptyY);
    }
  }

}