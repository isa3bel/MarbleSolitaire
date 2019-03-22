package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents a TriangleSolitaire game, which allows the user play the triangle version of marble
 * solitaire.
 */
public class TriangleSolitaireModelImpl extends MarbleSolitaireModelAbstract
    implements MarbleSolitaireModel {

  /**
   * Constructs a TriangleMarbleSolitaire game with default parameters. Allows players to play with
   * triangle board, and move two spaces to the left, right, or diagonal.
   */
  public TriangleSolitaireModelImpl() {
    this(5,0,0);
  }

  /**
   * Constructs a TriangleMarbleSolitaire game based on the dimensions of the triangle.
   * @param dimension the length of each side of the triangle
   */
  public TriangleSolitaireModelImpl(int dimension) {
    this(dimension, 0,0);

  }

  /**
   * Constructs a TriangleMarbleSolitaire game based on the row position and col position of the
   * empty space.
   * @param row the row position of the empty space
   * @param col the col position of the empty space
   */
  public TriangleSolitaireModelImpl(int row, int col) {
    this(5,row,col);

  }

  /**
   * Constructs a TriangleMarbleSolitaire game based on the dimensions of the triangle, row of
   * empty space, and col of empty space.
   * @param dimension the length of each side of the triangle
   * @param row the row position of the empty space
   * @param col the col position of the empty space
   * @throws IllegalArgumentException for invalid dimension, and invalid empty spot position
   */
  public TriangleSolitaireModelImpl(int dimension, int row, int col) {
    if (dimension < 1) {
      throw new IllegalArgumentException("Arm thickness must be a positive, odd number");
    } else if (row < 0 || col < 0 || row > dimension || col > dimension || col > row) {
      throw new IllegalArgumentException("must be a valid position");
    }
    this.armThickness = dimension;
    this.emptyX = row;
    this.emptyY = col;
    this.isGameOver = false;
    this.board = new TriangleBoard(this.armThickness,this.emptyX,this.emptyY);
    this.score = board.calculateScore();
  }
}
