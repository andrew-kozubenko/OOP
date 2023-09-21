import org.junit.jupiter.api.Test;
import org.example.HeapSort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HeapSortTest {

    @Test
    public void testHeapSortAscending() {
        int[] arr = {5, 4, 3, 2, 1};
        HeapSort.heapSort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testHeapSortDescending() {
        int[] arr = {5, 4, 3, 2, 1};
        HeapSort.heapSort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testHeapSortEmptyArray() {
        int[] arr = {};
        HeapSort.heapSort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testHeapSortSingleElement() {
        int[] arr = {42};
        HeapSort.heapSort(arr);
        int[] expected = {42};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testHeapSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        HeapSort.heapSort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testHeapSortNegativeNumbers() {
        int[] arr = {-5, -3, -1, -4, -2};
        HeapSort.heapSort(arr);
        int[] expected = {-5, -4, -3, -2, -1};
        assertArrayEquals(expected, arr);
    }
}