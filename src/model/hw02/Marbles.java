package cs3500.marblesolitaire.model.hw02;

/**
 * Represents the Marble object.
 */
public class Marbles {
  public boolean gone;
  /**
   * Constructs an instance of the Marble object.
   */

  public Marbles() {
    this.gone = false;
  }

  /**
   * Returns a string that represents the current state of this marble.
   * @return a string that represents the current state of this marble
   */
  public String rep() {
    if (gone) {
      return "_";
    } else {
      return "O";
    }
  }

}
