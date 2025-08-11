package myproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SinhCalculatorTest {

    @Test
    public void testSinhZero() {
        assertEquals(0.0, SinhCalculatorGui.sinh(0), 1e-9);
    }

    @Test
    public void testSinhOne() {
        assertEquals(Math.sinh(1.0), SinhCalculatorGui.sinh(1.0), 1e-9);
    }

    @Test
    public void testNegativeValue() {
        assertEquals(Math.sinh(-2.0), SinhCalculatorGui.sinh(-2.0), 1e-9);
    }
}
