package cs3500.marblesolitaire.model.hw02;

/**
 * Represents the game board object.
 */
public class Board {

  protected Marbles[][] board;
  protected int armThickness;
  protected int size;
  protected Marbles midCell;

  /**
   * Constructs an instance of a game board based on armThickness and empty space coordinates.
   * @param armThickness the thickness of the squares that make up the board.
   * @param emptyX the column position of the empty space.
   * @param emptyY the row position of the empty space.
   */
  public Board(int armThickness, int emptyX, int emptyY) {
    this.size = (armThickness * 3) - 2;
    this.armThickness = armThickness;
    generateBoard(emptyX, emptyY);
  }

  /**
   * Generates the board as a 2D array and sets marbles in the correct spots.
   * @param emptyX the x position of the empty slot
   * @param emptyY the y position of the empty slot
   */
  protected void generateBoard(int emptyX, int emptyY) {
    board = new Marbles[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (checkBoundariesFalse(i, j)) {
          board[i][j] = null;
        } else {
          board[i][j] = new Marbles();
        }
      }
    }
    this.board[emptyX][emptyY].gone = true; // the initial empty space has no marble

  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, X or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   * @return the game state as a string
   */
  public String getGameState() {
    String initial = "";
    for (int i = 0; i < this.board.length; i++) {
      boolean drewM = false;
      for (int j = 0; j < this.board[i].length; j++) {
        if (this.board[i][j] == null) {
          if (!drewM) {
            initial += "  ";
          }
        } else {
          if (j == 0  || this.board[i][j - 1] == null) {
            initial += this.board[i][j].rep();
          } else {
            initial += " " + this.board[i][j].rep();
          }
          drewM = true;
        }
      }
      if ((i != this.board.length - 1)) {
        initial += "\n";
      }
    }
    return initial;
  }

  /**
   * Deteremines whether or not the given posn is a valid position on the board.
   * @param row the y position of the given position.
   * @param col the x position of the given position.
   * @return whether or not the given posn is a valid position on the board.
   */
  protected boolean goodPosn(int row, int col) {
    return !(checkBoundariesFalse(row, col));
  }

  /**
   * Checks whether or not the given row and column are out of bounds.
   * @param r the row value
   * @param col the column value
   * @return whether or not the given row and column are out of bounds
   */
  protected boolean checkBoundariesFalse(int r, int col) {
    return ((r < armThickness - 1 && col < armThickness - 1) || // top left
        (r < armThickness - 1 && col > ((2 * armThickness) - 2)) || // top right
        (r > ((armThickness * 2) - 2) && col < armThickness - 1) || // bottom left
        (r > ((armThickness * 2) - 2) && col > ((2 * armThickness) - 2)) || // bottom right
        (r < 0 || r >= size || col >= size || col < 0));

  }

  /**
   * Determines whether or not the given move action is valid.
   * @param fromRow the row position of the marble before it is moved.
   * @param fromCol the column position of the marble before it is moved.
   * @param toRow the row position of the marble after it is moved.
   * @param toCol the column position of the marble after it is moved.
   * @return whether or not the given move action is valid.
   */
  protected boolean goodMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (!(goodPosn(fromRow, fromCol))
        || !(goodPosn(toRow, toCol))
        || (!(!this.board[fromRow][fromCol].gone && this.board[toRow][toCol].gone))
        || (!((Math.abs(toRow - fromRow) == 2 && fromCol == toCol)
        || (Math.abs(toCol - fromCol)
        == 2 && toRow == fromRow)))) {
      return false;
    } else {
      midCell = this.board[fromRow + (toRow - fromRow) / 2][(fromCol + (toCol - fromCol) / 2)];
      return !(midCell.gone);
    }
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow the row number of the position to be moved to
   *              (starts at 0)
   * @param toCol the column number of the position to be moved to
   *              (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    if (goodMove(fromRow, fromCol, toRow, toCol)) {
      this.board[fromRow][fromCol].gone = true;
      midCell.gone = true;
      this.board[toRow][toCol].gone = false;
    } else {
      throw new IllegalArgumentException("Move must be valid");
    }
  }

  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   * @return true if the game is over, false otherwise
   */
  public boolean isGameOver() {
    for (int row = 0; row < this.board.length - 1; row++) {
      for (int col = 0; col  < this.board[row].length - 1; col++) {
        if (row + 2 < size && goodMove(row, col, row + 2, col)) {
          return false;
        } else if ( row - 2 > 0 && goodMove(row, col, row - 2, col)) {
          return false;
        } else if (col + 2 < size && goodMove(row, col, row, col + 2)) {
          return false;
        } else if (col - 2 > 0 && goodMove(row, col, row, col - 2)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Calculates the current score at any moment in the game.
   * @return an integer representing the current score
   */
  public int calculateScore() {
    int count = 0;
    for (int i = 0; i < this.size; i++ ) {
      for (int k = 0; k < this.size; k++) {
        if ((this.board[i][k] != null) && this.board[i][k].rep().equals("O")) {
          count++;
        }
      }
    }
    return count;
  }

}

