package algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxNumberTest {
    @Test
    public void calculate_forVariousDigits_shouldReturnMaxNumber() {
        assertEquals(987, new MaxNumber("9", "7", "8").calculate());
        assertEquals(210, new MaxNumber("0", "1", "2").calculate());
        assertEquals(92100, new MaxNumber("0", "1", "9", "2", "0").calculate());
    }
}
