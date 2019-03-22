import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.Marbles;
import org.junit.Test;


public class MarblesTest {
  Marbles marble = new Marbles();

  @Test
  public void testConstructor() {
    assertEquals(false, this.marble.gone);
  }

  @Test
  public void testRepFalse() {
    assertEquals("O", this.marble.rep());
  }

  @Test
  public void testRepTrue() {
    this.marble.gone = true;
    assertEquals("_", this.marble.rep());
  }
}