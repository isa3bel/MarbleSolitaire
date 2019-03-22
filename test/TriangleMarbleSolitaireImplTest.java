import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import org.junit.Test;

public class TriangleMarbleSolitaireImplTest {
  private MarbleSolitaireModel e;

  @Test
  public void testValidInitialConstructor() {
    this.e = new TriangleSolitaireModelImpl();
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", e.getGameState());
  }

  @Test
  public void testValidSecondConstructor() {
    this.e = new TriangleSolitaireModelImpl(3);
    assertEquals("  _\n"
        + " O O\n"
        + "O O O", e.getGameState());

  }

  @Test
  public void testValidThirdConstructor5() {
    this.e = new TriangleSolitaireModelImpl(5,0,0);
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", e.getGameState());
  }

  @Test
  public void testValidThirdConstructor3() {
    this.e = new TriangleSolitaireModelImpl(5,1,0);
    assertEquals("    O\n"
        + "   _ O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", e.getGameState());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor() {
    this.e = new TriangleSolitaireModelImpl(-1,0);
    assertEquals("", e.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructorInvalidEmpty() {
    this.e = new TriangleSolitaireModelImpl(3,0,5);
    assertEquals("", e.getGameState());
  }

  @Test
  public void testInvalidThirdConstructorBadArmLength() {
    this.e = new TriangleSolitaireModelImpl(2,0,0);
    assertEquals(" _\n"
        + "O O", e.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveNoFromMarble() {
    this.e = new TriangleSolitaireModelImpl(5,0,0);
    e.move(0,0, 0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveTooFar() {
    this.e = new TriangleSolitaireModelImpl(7,6,3);
    e.move(6,0,6,3);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMiddleGone() {
    this.e = new TriangleSolitaireModelImpl(7,6,3);
    e.move(6,4,6,2);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testVerticleMove() {
    this.e = new TriangleSolitaireModelImpl(5,0,0);
    e.move(2,1,0,0);

  }

  @Test
  public void testMoveRight() {
    this.e = new TriangleSolitaireModelImpl(5,4,2);
    e.move(4,0,4,2);
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "_ _ O O O", e.getGameState());

  }

  @Test
  public void testMoveLeft() {
    this.e = new TriangleSolitaireModelImpl(5,4,2);
    e.move(4,4,4,2);
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O _ _", e.getGameState());
  }

  @Test
  public void testMoveUpLeft() {
    this.e = new TriangleSolitaireModelImpl(5,2,0);
    e.move(4,2,2,0);
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O _ O O\n"
        + "O O _ O O", e.getGameState());

  }

  @Test
  public void testMoveUpRight() {
    this.e = new TriangleSolitaireModelImpl(5,2,2);
    e.move(4,2,2,2);
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O _ O\n"
        + "O O _ O O", e.getGameState());
  }

  @Test
  public void testMoveDownRight() {
    this.e = new TriangleSolitaireModelImpl(5,4,2);
    e.move(2,0,4,2);
    assertEquals("    O\n"
        + "   O O\n"
        + "  _ O O\n"
        + " O _ O O\n"
        + "O O O O O", e.getGameState());

  }

  @Test
  public void testMoveDownLeft() {
    this.e = new TriangleSolitaireModelImpl(5,4,2);
    e.move(2,2,4,2);
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O _\n"
        + " O O _ O\n"
        + "O O O O O", e.getGameState());
  }

  @Test
  public void testScore() {
    this.e = new TriangleSolitaireModelImpl(5,4,2);
    assertEquals(14, e.getScore());
    e.move(2,2,4,2);
    assertEquals(13, e.getScore());


  }

  @Test
  public void testIsGameOverFalse() {
    this.e = new TriangleSolitaireModelImpl(5,4,2);
    e.move(4,4,4,2);
    e.move(4,1,4,3);
    e.move(2,1,4,1);
    e.move(2,2,4,2);
    e.move(4,2,4,4);
    e.move(4,4,2,2);
    e.move(1,1,3,3);
    e.move(4,0,4,2);
    e.move(2,0,4,0);
    assertEquals(false, e.isGameOver());

  }

  @Test
  public void testIsGameOverFalseDefault() {
    this.e = new TriangleSolitaireModelImpl(5,0,0);
    assertEquals(false, e.isGameOver());

  }

  @Test
  public void testIsGameOverTrue() {
    this.e = new TriangleSolitaireModelImpl(5,4,2);
    e.move(4,4,4,2);
    e.move(4,1,4,3);
    e.move(2,1,4,1);
    e.move(2,2,4,2);
    e.move(4,2,4,4);
    e.move(4,4,2,2);
    e.move(1,1,3,3);
    e.move(4,0,4,2);
    e.move(2,0,4,0);
    e.move(0,0,2,0);
    assertEquals(true, e.isGameOver());
  }


}