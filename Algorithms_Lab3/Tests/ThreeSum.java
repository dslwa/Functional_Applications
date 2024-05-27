import static org.junit.Assert.*;
import org.junit.Test;
import ThreeSum.ThreeSum;
import java.util.List;
import java.util.Arrays;

public class ThreeSumTest {
    @Test
    public void testThreeSum() {
        ThreeSum threeSum = new ThreeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> result = threeSum.threeSum();
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );
        assertEquals(expected.size(), result.size());
        for (List<Integer> triplet : expected) {
            assertTrue(result.contains(triplet));
        }
    }

    @Test(expected = EmptyArray.class)
    public void testThreeSumEmptyArray() throws EmptyArray {
        ThreeSum threeSum = new ThreeSum(new int[]{});
        threeSum.threeSum();
    }
}