import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.Board;

import org.junit.Test;

public class BoardTest {

  @Test
  public void testGetBoardStateDefault() {
    Board board = new Board(3, 3, 3);
    assertEquals( "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", board.getGameState());
  }

  @Test
  public void testGetBoardState5CenterOff() {
    Board board = new Board(5, 4, 5);
    assertEquals( "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O _ O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O", board.getGameState());
  }


  @Test
  public void testGetBoardState5CenterOff70() {
    Board board = new Board(5, 0, 7);
    assertEquals( "        O O O _ O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O", board.getGameState());
  }

  @Test
  public void testMove() {
    Board board = new Board(3,3,3);
    board.move(3, 5, 3,3);

    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", board.getGameState());
  }

  @Test
  public void testMoveOnEdge() {
    Board board = new Board(5,8,12);
    board.move(6, 12, 8,12);

    assertEquals( "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O _\n"
        + "O O O O O O O O O O O O _\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O", board.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    Board board = new Board(3,3,3);
    board.move(3, 0, 3,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveAllInvalid() {
    Board board = new Board(3,3,3);
    board.move(0, 0, -3,-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToOutOfBounds1() {
    Board board = new Board(3,3,3);
    board.move(3, 0, 3,-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToOutOfBounds2() {
    Board board = new Board(3,3,3);
    board.move(3, 0, -33,-33);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveDiagonal() {
    Board board = new Board(3,3,3);
    board.move(3, 5, 3,3);
    board.move(1, 2, 3,4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveDidntMove() {
    Board board = new Board(3,3,3);
    board.move(3, 5, 3,5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutside() {
    Board board = new Board(3,3,3);
    board.move(3, 3, 3,7);
  }

  @Test
  public void isGameOverTrue() {
    Board b = new Board(3,3,3);
    b.move(1, 3, 3, 3);
    b.move(4, 3, 2, 3);
    b.move(6, 3, 4, 3);
    b.move(3, 5, 3, 3);
    b.move(3, 2, 3, 4);
    b.move(3, 0, 3, 2);

    assertEquals(true,b.isGameOver());
  }

  @Test
  public void isGameOverFalse() {
    Board b = new Board(3,3,3);
    assertEquals(false, b.isGameOver());
  }

}