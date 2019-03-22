package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents a controller object for the marble solitaire game.
 */
public interface MarbleSolitaireController {

  /** Sets the game in motion for the user to play the game.
   * @param model the model interface of the solitaire game
   * @throws IllegalStateException if readable and appendable cannot be transmitted
   * @throws IllegalArgumentException if model is null
   */
  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException;

}
