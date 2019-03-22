package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents a EuropeanSolitaireModel game.
 */

public class EuropeanSolitaireModelImpl extends MarbleSolitaireModelAbstract
    implements MarbleSolitaireModel {

  /**
   * Constructs default EuropeanSolitaireMarble game.
   */
  public EuropeanSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructs a EuropeanSolitaireMarble game based on the sideLength.
   *
   * @param sideLength the length of each square-side of the board
   */
  public EuropeanSolitaireModelImpl(int sideLength) {
    this(sideLength, 3, 3);
  }

  /**
   * Constructs a EuropeanSolitaireMarble game based on given positions for the empty space.
   *
   * @param row the row position of the empty space
   * @param col the col position of the empty space
   */
  public EuropeanSolitaireModelImpl(int row, int col) {
    this(3, row, col);
  }

  /**
   * Constructs a EopreanSolitaireMarble game based on sideLength, row and col of the empty space.
   *
   * @param sideLength the length of each square-side
   * @param r the row position of the empty space
   * @param col the col position of the empty space
   * @throws IllegalArgumentException for invalid sideLength thickness and invalid empty space
   *
   */
  public EuropeanSolitaireModelImpl(int sideLength, int r, int col) {
    int totalLength = (sideLength * 3) - 2;
    if (!((sideLength > 0) && (sideLength % 2 == 1))) {
      throw new IllegalArgumentException("Arm thickness must be a positive, odd number");
    } else if ((r < sideLength - 1 && col < (totalLength / 2) - ((sideLength + (2 * r)) / 2)) ||
        // top left
        (r < sideLength - 1 && col > ((totalLength / 2) + ((sideLength + (2 * r)) / 2))) ||
        // top right
        (r > (totalLength / 2) + ((sideLength + (2 * col)) / 2) && col < sideLength - 1) ||
        // bottom left
        (r > sideLength * 2 - 2 && col > (totalLength / 2) + (
            (sideLength + ((totalLength - r - 1) * 2)) / 2))
        || (r < 0 || r > totalLength - 1 || col > totalLength - 1 || col < 0)) {
      throw new IllegalArgumentException("Must have a valid empty row and empty col");
    }

    this.armThickness = sideLength;
    this.emptyX = r;
    this.emptyY = col;
    this.isGameOver = false;
    this.board = new EuroBoard(armThickness, this.emptyX, this.emptyY);
    this.score = this.board.calculateScore();
  }

}
