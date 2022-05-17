import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Tests {
    private void checkIfEqual(String input, int expected) {
        Assertions.assertEquals(Integer.decode(input), expected);
    }

    @Test
    public void testEmptyString() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }

    @Test
    public void testSign() {
        checkIfEqual("-1", -1);
        checkIfEqual("1", 1);
        checkIfEqual("+1", 1);
    }

    @Test
    public void testRadixSpecifier() {
        checkIfEqual("11", 11);
        checkIfEqual("0x11", 17);
        checkIfEqual("0X11", 17);
        checkIfEqual("#11", 17);
        checkIfEqual("011", 9);
    }

    @Test
    public void testSignPosition() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("0x-11"));
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("0x+11"));
    }

    @Test
    public void testMinMax() {
        checkIfEqual(Integer.toString(Integer.MIN_VALUE), Integer.MIN_VALUE);
        checkIfEqual(Integer.toString(Integer.MAX_VALUE), Integer.MAX_VALUE);
    }
}
