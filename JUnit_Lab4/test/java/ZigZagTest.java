import static org.junit.Assert.*;
import org.junit.Test;
import ZigZagStr.ZigZag;

public class ZigZagTest {
    @Test
    public void testSolution() {
        ZigZag zigZag = new ZigZag();
        assertEquals("PAHNAPLSIIGYIR", zigZag.solution("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", zigZag.solution("PAYPALISHIRING", 4));
    }
}