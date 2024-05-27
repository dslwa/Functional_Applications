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
        assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", spiral.getResult().toString());
    }
}