import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import org.junit.Test;

public class EuropeanSolitaireModelImplTest {
  private MarbleSolitaireModel e;

  @Test
  public void testValidInitialConstructor() {
    this.e = new EuropeanSolitaireModelImpl(3, 3,3);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O",this.e.getGameState());

  }

  @Test
  public void testValidSecondConstructor() {
    this.e = new EuropeanSolitaireModelImpl(3,3);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O",this.e.getGameState());

  }

  @Test
  public void testValidThirdConstructor5() {
    this.e = new EuropeanSolitaireModelImpl(5,5,5);
    assertEquals("        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O _ O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O",this.e.getGameState());
  }

  @Test
  public void testValidThirdConstructor3() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O",this.e.getGameState());
  }

  @Test
  public void testValidThirdConstructorCustom() {
    this.e = new EuropeanSolitaireModelImpl(3,2,6);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O _\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O",this.e.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor() {
    this.e = new EuropeanSolitaireModelImpl(-3,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructorInvalidEmpty() {
    this.e = new EuropeanSolitaireModelImpl(3,3,-3);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructorBadArmLength() {
    this.e = new EuropeanSolitaireModelImpl(4,3,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveNoFromMarble() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    e.move(3,3, 0,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveTooFar() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    e.move(2,3, 3,6);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiagonalMove() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    e.move(2,3, 4,5);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToMarbleGone() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    e.move(0,3, 3,3);
  }

  @Test
  public void testMoveLeft() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    e.move(3,5,3,3);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", e.getGameState());
  }

  @Test
  public void testMoveRight() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    e.move(3,1,3,3);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", e.getGameState());

  }

  @Test
  public void testMoveUp() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    e.move(5,3,3,3);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "  O O _ O O\n"
        + "    O O O", e.getGameState());
  }

  @Test
  public void testCenterOff() {
    this.e = new EuropeanSolitaireModelImpl(3,4,3);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "  O O O O O\n"
        + "    O O O", e.getGameState());

  }

  @Test
  public void testMoveDown() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    e.move(1,3, 3,3);
    assertEquals("    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", e.getGameState());
  }

  @Test
  public void testScore() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    assertEquals(36, e.getScore());
    e.move(1,3, 3,3);
    assertEquals(35, e.getScore());

  }

  @Test
  public void testIsGameOverFalse() {
    this.e = new EuropeanSolitaireModelImpl(3,3,3);
    assertEquals(false, e.isGameOver());
    e.move(1,3, 3,3);
    assertEquals(false, e.isGameOver());

  }

  @Test
  public void testIsGameOverTrue() {
    this.e = new MarbleSolitaireModelImpl();
    this.e.move(1, 3, 3, 3);
    this.e.move(4, 3, 2, 3);
    this.e.move(6, 3, 4, 3);
    this.e.move(3, 5, 3, 3);
    this.e.move(3, 2, 3, 4);
    this.e.move(3, 0, 3, 2);
    System.out.print(this.e.getGameState());
    assertEquals(true, this.e.isGameOver());
  }


}