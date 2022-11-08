package cl.uchile.dcc.exceptions;

import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.exceptions.Require.statValueAtLeast;
import static cl.uchile.dcc.exceptions.Require.statValueAtMost;
import static org.junit.jupiter.api.Assertions.*;

class RequireTest {

  @Test
  void TeststatValueAtLeast() {
    assertThrows(InvalidStatValueException.class,
        () -> statValueAtLeast(0, -10, "negativeTest"));
    assertThrows(InvalidStatValueException.class,
        () -> statValueAtLeast(-12, -16, "LowerNegative"));
    assertThrows(InvalidStatValueException.class,
        () -> statValueAtLeast(31, -53, "NegativePositive"));
    assertThrows(InvalidStatValueException.class,
        () -> statValueAtLeast(31, 19, "LowerPositive"));
    assertThrows(InvalidStatValueException.class,
        () -> statValueAtLeast(58, 0, "positiveTest"));
  }

  @Test
  void TeststatValueAtMostTest() {
    assertThrows(InvalidStatValueException.class,
        () -> statValueAtMost(-10, 0, "negativeTest"));
    assertThrows(InvalidStatValueException.class,
        () -> statValueAtMost(-16, -12, "UpperNegative"));
    assertThrows(InvalidStatValueException.class,
        () -> statValueAtMost(-53, 31, "NegativePositive"));
    assertThrows(InvalidStatValueException.class,
        () -> statValueAtMost(21, 89, "UpperPositive"));
    assertThrows(InvalidStatValueException.class,
        () -> statValueAtMost(0, 67, "positiveTest"));
  }
}