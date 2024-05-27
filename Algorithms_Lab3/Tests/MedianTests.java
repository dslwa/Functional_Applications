import static org.junit.Assert.*;
import org.junit.Test;
import Median.Median;
import Exceptions.EmptyArray;

public class MedianTest {
    @Test
    public void testFindMedian() throws EmptyArray {
        Median median = new Median();
        assertEquals(4.0, median.findMedian(new int[]{1, 3}, new int[]{2, 7}), 0.001);
        assertEquals(3.5, median.findMedian(new int[]{1, 2}, new int[]{3, 4}), 0.001);
        assertEquals(2.0, median.findMedian(new int[]{1, 2}, new int[]{1, 2, 3}), 0.001);
    }

    @Test(expected = EmptyArray.class)
    public void testFindMedianEmptyArray() throws EmptyArray {
        Median median = new Median();
        median.findMedian(new int[]{}, new int[]{});
    }
}