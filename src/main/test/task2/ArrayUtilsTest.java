package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.dvorianchykov_sa.task2.utils.ArrayUtils;
import ru.aston.dvorianchykov_sa.task2.constants.Messages;
import ru.aston.dvorianchykov_sa.task2.exceptions.EmptyArrayException;
import ru.aston.dvorianchykov_sa.task2.exceptions.NullArrayException;

import java.util.Arrays;

public class ArrayUtilsTest {

    private int[] arr1;
    private int[] arr2;
    private int[] arr3;
    private int[] arr4;
    private int[] arr5;
    private int[] arr6;
    private int[] arr7;
    private int[] arr8;
    private int[] arr9;

    @BeforeEach
    public void setUp() {
        arr1 = new int[0];
        arr2 = new int[]{7, 5, 1, 2};
        arr3 = new int[]{6};
        arr4 = new int[]{1, 2, 2, 3};
        arr5 = null;
        arr6 = new int[4];
        arr7 = new int[]{1, 2, 3, 1, 2, 4};
        arr8 = new int[]{7, 5, 1, 2, 9};
        arr9 = new int[]{1,1};
    }

    @Test
    public void isSortedArrayAscTest() throws NullArrayException, EmptyArrayException {
        Assertions.assertThrows(EmptyArrayException.class, () -> ArrayUtils.isSortedArrayAsc(arr1));
        Assertions.assertEquals(Messages.TRY_AGAIN.getMessage(), ArrayUtils.isSortedArrayAsc(arr2));
        Assertions.assertEquals(Messages.OK.getMessage(), ArrayUtils.isSortedArrayAsc(arr3));
        Assertions.assertEquals(Messages.OK.getMessage(), ArrayUtils.isSortedArrayAsc(arr4));
        Assertions.assertThrows(NullArrayException.class, () -> ArrayUtils.isSortedArrayAsc(arr5));
        Assertions.assertEquals(Messages.OK.getMessage(), ArrayUtils.isSortedArrayAsc(arr6));
    }

    @Test
    public void swapFirstAndLastTest() {
        ArrayUtils.swapFirstAndLast(arr2);
        ArrayUtils.swapFirstAndLast(arr4);

        Assertions.assertEquals(2, arr2[0]);
        Assertions.assertEquals(7, arr2[arr2.length - 1]);

        Assertions.assertEquals(3, arr4[0]);
        Assertions.assertEquals(1, arr4[arr4.length - 1]);
    }

    @Test
    public void findFirstUniq() throws NullArrayException, EmptyArrayException {
        Assertions.assertThrows(EmptyArrayException.class, () -> ArrayUtils.findFirstUniq(arr1));
        Assertions.assertEquals(7, ArrayUtils.findFirstUniq(arr2));
        Assertions.assertThrows(NullArrayException.class, () -> ArrayUtils.findFirstUniq(arr5));
        Assertions.assertEquals(3, ArrayUtils.findFirstUniq(arr7));
        Assertions.assertEquals(null, ArrayUtils.findFirstUniq(arr9));
    }

    @Test
    public void mergeSortTest() throws NullArrayException, EmptyArrayException {
        int[] arr3Sorted = ArrayUtils.mergeSort(arr3);
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr3Sorted));
        Assertions.assertEquals(6, arr3Sorted[0]);

        int[] arr4Sorted = ArrayUtils.mergeSort(arr4);
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr4Sorted));
        Assertions.assertEquals(arr4[0], arr4Sorted[0]);
        Assertions.assertEquals(arr4[1], arr4Sorted[1]);
        Assertions.assertEquals(arr4[2], arr4Sorted[2]);
        Assertions.assertEquals(arr4[3], arr4Sorted[3]);

        int[] arr8Sorted = ArrayUtils.mergeSort(arr8);
        System.out.println(Arrays.toString(arr8));
        System.out.println(Arrays.toString(arr8Sorted));
        Assertions.assertEquals(1, arr8Sorted[0]);
        Assertions.assertEquals(2, arr8Sorted[1]);
        Assertions.assertEquals(5, arr8Sorted[2]);
        Assertions.assertEquals(7, arr8Sorted[3]);
        Assertions.assertEquals(9, arr8Sorted[4]);
    }
}
