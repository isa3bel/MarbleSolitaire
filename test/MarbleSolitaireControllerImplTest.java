import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import java.io.StringReader;
import org.junit.Test;

public class MarbleSolitaireControllerImplTest {

  @Test
  public void testGameOver() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("2 4 4 4 5 4 3 4 7 4 5 4 4 6 4 4 4 3 4 5 4 1 4 3");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 29\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 28\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O _ _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 27\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "_ _ O _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 26\n"
        + "Game over!\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "_ _ O _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 26", a1.toString());

  }

  @Test
  public void testQuitq() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("6 4 4 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());
  }

  @Test
  public void testQuitQ() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("6 4 4 4 Q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());
  }

  @Test
  public void testMoveLeft() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("4 6 4 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());

  }

  @Test
  public void testMoveRight() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());

  }

  @Test
  public void testMoveRightLarge() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("7 13 9 13 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl(5);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O _ O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "Score: 104\n"
        + "Invalid move. Please play again. Move must travel orthoganally, must not be more than "
        + "two spaces over, must have a marble in the from position, an empty space in the to "
        + "position, and a marble in between. \n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O _ O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "Score: 104\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O _ O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "Score: 104", a1.toString());

  }

  @Test
  public void testMoveUp() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("6 4 4 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());

  }

  @Test
  public void testMoveDown() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("2 4 4 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());

  }


  @Test
  public void testEndGameTrue() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("2 4 4 4 5 4 3 4 7 4 5 4 4 6 4 4 4 3 4 5 4 1 4 3");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 29\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 28\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O _ _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 27\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "_ _ O _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 26\n"
        + "Game over!\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "_ _ O _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "Score: 26", a1.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testBadInput() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("hello");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);

  }

  @Test(expected = IllegalStateException.class)
  public void testNegativeNumberInput() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("-5");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);

  }

  @Test(expected = IllegalStateException.class)
  public void testRanOut() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("6 4 4 8");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);

  }

  @Test(expected = IllegalStateException.class)
  public void testEmptySpace() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);

  }

  @Test
  public void testUpToFromRowGood() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("2 -8 4 4 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Please enter a valid input \n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());

  }

  @Test
  public void testUpToFromColGood() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("4 6 -4 4 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Please enter a valid input \n"
        + "\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());

  }

  @Test
  public void testUpToToRowGood() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("2 4 4 -4 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Please enter a valid input \n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());

  }

  @Test
  public void testFromRowBad() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("-2 2 4 4 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Please enter a valid input \n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());

  }

  @Test
  public void testWithRandaomLetterInMiddle() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("2 e 4 4 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Please enter a valid input \n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", a1.toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("2 4 4 4 q");
    MarbleSolitaireModel model = null;
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);

  }

  @Test(expected = IllegalStateException.class)
  public void testSingleLetter() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("A");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);

  }

  @Test
  public void testQuitAfterTwoMoves() {
    Appendable a1 = new StringBuilder();
    Readable r1 = new StringReader("2 4 4 4 5 4 3 4 q");
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(r1 ,a1);
    controller.playGame(model);

    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30", a1.toString());
  }

}