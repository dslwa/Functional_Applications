import static org.junit.Assert.*;
import org.junit.Test;
import Spiral.Spiral;
import Exceptions.EmptyArray;

public class SpiralTest {
    @Test
    public void testSpiral() throws EmptyArray {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Spiral spiral = new Spiral(3, 3, matrix);
        spiral.spiral();
        assertEquals("[1, 4, 7, 8, 9, 6, 3, 2, 5]", spiral.getResult().toString());
    }

    @Test(expected = EmptyArray.class)
    public void testSpiralEmptyArray() throws EmptyArray {
        int[][] matrix = {};
        Spiral spiral = new Spiral(0, 0, matrix);
        spiral.spiral();
    }
}