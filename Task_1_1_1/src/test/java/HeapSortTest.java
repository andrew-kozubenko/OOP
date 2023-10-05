import org.junit.jupiter.api.Test;
import org.example.HeapSort;

import java.util.Arrays;
import java.util.Random;

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

    @Test
    public void testHeapSortRandomNumbers(){
        int[] arr1 = new int[1000];
        int[] arr2 = new int[1000];
        var random = new Random();
        for(int i = 0; i < 1000; i++){
            arr1[i] = random.nextInt(1000);
            arr2[i] = arr1[i];
        }
        Arrays.sort(arr1);
        HeapSort.heapSort(arr2);

        assertArrayEquals(arr1, arr2);
    }
}
