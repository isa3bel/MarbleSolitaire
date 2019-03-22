package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Board;
import cs3500.marblesolitaire.model.hw02.Marbles;

/**
 * Constructs a TriangleBoard object that extends the Board class.
 */
public class TriangleBoard extends Board {

  /**
   * Constructs an instance of a game board based on armThickness and empty space coordinates.
   *
   * @param armThickness the thickness of the squares that make up the board.
   * @param emptyX the column position of the empty space.
   * @param emptyY the row position of the empty space.
   */
  public TriangleBoard(int armThickness, int emptyX, int emptyY) {
    super(armThickness, emptyX, emptyY);
    super.size = armThickness;
    generateBoard(emptyX, emptyY);
  }

  @Override
  public void generateBoard(int emptyX, int emptyY) {
    board = new Marbles[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (j > i) {
          board[i][j] = null;
        } else {
          board[i][j] = new Marbles();
        }
      }
    }
    this.board[emptyX][emptyY].gone = true; // the initial empty space has no marble
  }

  @Override
  public String getGameState() {
    String initial = "";
    for (int i = 0; i < this.board.length; i++) {
      for (int k = 0; k < (this.size - 1 - i); k++) {
        initial += " ";
      }
      for (int j = 0; j < this.board[i].length; j++) {
        if (this.board[i][j] != null) {
          if (j == i) {
            initial += this.board[i][j].rep();
          } else {
            initial += this.board[i][j].rep() + " ";
          }
        }
      }
      if ((i != this.board.length - 1)) {
        initial += "\n";
      }
    }

    return initial;

  }

  @Override
  protected boolean checkBoundariesFalse(int row, int col) {
    return (row < 0 || col < 0 || row > this.size - 1 || col > this.size - 1 || col > row);
  }

  @Override
  protected boolean goodMove(int fromRow, int fromCol, int toRow, int toCol) {
    if ((goodPosn(toRow, toCol))
        && (goodPosn(fromRow, fromCol))
        && ((!this.board[fromRow][fromCol].gone && this.board[toRow][toCol].gone))) {
      if ((Math.abs(toCol - fromCol)
          == 2 && toRow == fromRow)) { // moving left or right
        midCell = this.board[fromRow + (toRow - fromRow) / 2][(fromCol + (toCol - fromCol) / 2)];
        return !(midCell.gone);
      } else if ((Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 2)) {
        // moving up left
        midCell = this.board[fromRow + (toRow - fromRow) / 2][(fromCol + (toCol - fromCol) / 2)];
        return !(midCell.gone);
      } else if ((Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 0)) {
        // moving up right
        midCell = this.board[fromRow + (toRow - fromRow) / 2][(fromCol + (toCol - fromCol) / 2)];
        return !(midCell.gone);
      }
    }
    return false;
  }

  @Override
  public boolean isGameOver() {
    for (int row = 0; row < this.board.length; row++) {
      for (int col = 0; col  <= row; col++) {
        if (row + 2 < size && goodMove(row, col, row + 2, col)) { // move up left
          return false;
        } else if (row + 2 < size && col + 2 < size
            && goodMove(row, col + 2, row + 2, col)) { // move up right
          return false;
        } else if ( row - 2 >= 0 && goodMove(row, col, row - 2, col)) { // move down right
          return false;
        } else if ( row - 2 >= 0 && col - 2 >= 0
            && goodMove(row, col - 2, row - 2, col)) { // move down left
          return false;
        } else if (col + 2 <= row && goodMove(row, col, row, col + 2)) { // move right
          return false;
        } else if (col - 2 >= 0 && goodMove(row, col, row, col - 2)) { // move left
          return false;
        }
      }
    }
    return true;
  }




}
