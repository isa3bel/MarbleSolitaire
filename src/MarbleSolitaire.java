package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import java.io.InputStreamReader;

/**
 * Represents the different types of Marble Solitaire game that users can play.
 */
public final class MarbleSolitaire {

  /**
   * The main method that kick-starts the game.
   * @param args the arguments that the user passes in
   */
  public static void main(String[] args) {
    String start = "";
    int size = 0;
    int row = 0;
    int col = 0;

    MarbleSolitaireControllerImpl controller =
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out);
    if (args[0].equals("english") || args[0].equals("european")) {
      start = args[0];
      size = 3;
      row = 3;
      col = 3;
    } else if (args[0].equals("triangular")) {
      start = args[0];
      size = 5;
      row = 0;
      col = 0;
    }

    if (args.length >= 2 && args[2].equals("-size")) {
      size = Integer.parseInt(args[2]);
      row = Integer.parseInt(args[2]) - 1;
      col = Integer.parseInt(args[2]) - 1;
    } else if (args.length >= 2 && args[1].equals("-hole")) {
      row = Integer.parseInt(args[2]) - 1;
      col = Integer.parseInt(args[3]) - 1;
    }

    if (args.length >= 5 && args[4].equals("-size")) {
      size = Integer.parseInt(args[5]);
    } else if (args.length >= 5 && args[3].equals("-hole")) {
      row = Integer.parseInt(args[4]) - 1;
      col = Integer.parseInt(args[5]) - 1;
    }

    switch (start) {
      case "european":
        controller.playGame(new EuropeanSolitaireModelImpl(size, row, col));
        break;
      case "english":
        controller.playGame(new MarbleSolitaireModelImpl(size, row, col));
        break;
      case "triangular":
        controller.playGame(new TriangleSolitaireModelImpl(size, row, col));
        break;
      default:
        break;
    }

  }
}
