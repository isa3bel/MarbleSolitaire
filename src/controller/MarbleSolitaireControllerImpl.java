package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** Represents the controller object for the solitaire game.
 * Allows the game to react based on user input.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  final Readable in;
  final Appendable out;
  /**
   * Constructs an instance of a controller for the marble solitaire game.
   * @param rd any input coming from the user
   * @param ap any output sent to the user
   * @throws IllegalArgumentException Determines whether rd and ap are null
   */

  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Readable and Appendable must not be null");
    }
    this.in = rd;
    this.out = ap;
  }

  @Override
  public void playGame(MarbleSolitaireModel model) throws IllegalStateException {
    Scanner scan = new Scanner(this.in);
    int goodPosn = 0;
    int[] posns = new int[4];


    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    try {
      this.out.append(model.getGameState() + "\n");
      this.out.append("Score: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Cannot transmit output");
    }
    while (!model.isGameOver()) {
      while (goodPosn != 4) {
        String temp;
        try {
          temp = scan.next();
        } catch (NoSuchElementException e) {
          throw new IllegalStateException("Ran out of inputs");
        }
        try {
          if (temp.equals("q") || temp.equals("Q")) {
            try {
              this.out.append("Game quit!\n");
              this.out.append("State of game when quit:\n");
              this.out.append(model.getGameState() + "\n");
              this.out.append("Score: " + model.getScore());
              return;
            } catch (IOException e) {
              throw new IllegalStateException("Cannot transmit output");
            }
          } else if (Integer.parseInt(temp) > 0) {
            posns[goodPosn] = Integer.parseInt(temp) - 1;
            goodPosn++;
          } else {
            try {
              this.out.append("Please enter a valid input \n");
            } catch (IOException e) {
              throw new IllegalStateException("Cannot transmit output");
            }
          }
        } catch (NumberFormatException nfe) {
          try {
            this.out.append("Please enter a valid input \n");
          } catch (IOException e) {
            throw new IllegalStateException("Cannot transmit output");
          }
        }
      }
      try {
        try {
          model.move(posns[0], posns[1], posns[2], posns[3]);
          this.out.append("\n");
        } catch (IOException e) {
          throw new IllegalStateException("Cannot transmit output");
        }

      } catch (IllegalArgumentException i) {
        try {
          this.out.append("Invalid move. Please play again. Move must travel orthoganally, "
              + "must not be more than two spaces over, must have a marble in the from position, "
              + "an empty space in the to position, and a marble in between. \n");
        } catch (IOException e) {
          throw new IllegalStateException("Cannot transmit output");
        }
      }
      try {
        this.out.append(model.getGameState());
        this.out.append("\n");
        this.out.append("Score: " + model.getScore());
        this.out.append("\n");
      } catch (IOException e) {
        throw new IllegalStateException("Cannot transmit output");
      }
      goodPosn = 0;
    }

    scan.close();
    if (model.isGameOver()) {
      try {
        this.out.append("Game over!\n");
        this.out.append(model.getGameState() + "\n");
        this.out.append("Score: " + model.getScore());
        return;
      } catch (IOException e) {
        throw new IllegalStateException("Cannot transmit output");
      }

    }
  }
}
