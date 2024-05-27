import static org.junit.Assert.*;
import org.junit.Test;
import Sortings.*;

public class SortingTest {
    @Test
    public void testBubbleSort() {
        int[] array = {5, 2, 9, 1, 5, 6};
        new BubbleSort().sort(array);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, array);
    }

    @Test
    public void testInsertionSort() {
        int[] array = {5, 2, 9, 1, 5, 6};
        new InsertionSort().sort(array);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, array);
    }

    @Test
    public void testMergeSort() {
        int[] array = {5, 2, 9, 1, 5, 6};
        new MergeSort().sort(array);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, array);
    }

    @Test
    public void testQuickSort() {
        int[] array = {5, 2, 9, 1, 5, 6};
        new QuickSort().sort(array);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, array);
    }

    @Test
    public void testSelectionSort() {
        int[] array = {5, 2, 9, 1, 5, 6};
        new SelectionSort().sort(array);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, array);
    }
}