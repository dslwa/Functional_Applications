import static org.junit.Assert.*;
import org.junit.Test;
import Median.Median;
import Exceptions.EmptyArray;

public class MedianTests {
    @Test
    public void testFindMedian() {
        Median median = new Median();
        assertEquals(2.0, median.findMedian(new int[]{1, 2}, new int[]{1, 2, 3}), 0.001);
    }
}