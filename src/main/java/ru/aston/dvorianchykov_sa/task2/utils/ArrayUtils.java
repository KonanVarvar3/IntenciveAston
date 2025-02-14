package ru.aston.dvorianchykov_sa.task2.utils;

import ru.aston.dvorianchykov_sa.task2.constants.Messages;
import ru.aston.dvorianchykov_sa.task2.exceptions.EmptyArrayException;
import ru.aston.dvorianchykov_sa.task2.exceptions.NullArrayException;

public class ArrayUtils {

    public static String isSortedArrayAsc(int[] array) throws EmptyArrayException, NullArrayException {
        if (array == null) throw new NullArrayException(Messages.NULL_ARRAY.getMessage());
        if (array.length == 0) throw new EmptyArrayException(Messages.EMPTY_ARRAY.getMessage());
        if (array.length == 1) return Messages.OK.getMessage();

        for (int i = 0; i < array.length; i++) {
            if (i + 1 != array.length && array[i] > array[i + 1]) return Messages.TRY_AGAIN.getMessage();
        }
        return Messages.OK.getMessage();
    }

    public static void swapFirstAndLast(int[] array) {
        if (array != null && array.length != 0 && array.length != 1) {
            int temp = array[0];
            array[0] = array[array.length - 1];
            array[array.length - 1] = temp;
        }
    }

    public static Integer findFirstUniq(int[] array) throws NullArrayException, EmptyArrayException {
        if (array == null) throw new NullArrayException(Messages.NULL_ARRAY.getMessage());
        if (array.length == 0) throw new EmptyArrayException(Messages.EMPTY_ARRAY.getMessage());

        if (array.length == 1) return array[0];

        boolean isElem = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) continue;
                if (array[i] == array[j]) {
                    isElem = true;
                    break;
                }
            }
            if(!isElem) return array[i];
            isElem = false;
        }

        return null;
    }

    public static int[] mergeSort(int[] array) throws NullArrayException, EmptyArrayException {
        if (array == null) throw new NullArrayException(Messages.NULL_ARRAY.getMessage());
        if (array.length == 0) throw new EmptyArrayException(Messages.EMPTY_ARRAY.getMessage());

        if(array.length == 1) return array;

        int arr1Len = array.length / 2;
        int arr2Len = array.length - arr1Len;

        int[] arr1 = copyArr(array, 0, arr1Len);
        int[] arr2 = copyArr(array, arr1Len, arr2Len);

        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);

        return merge(arr1, arr2);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int arr1Index = 0, arr2Index = 0, len = arr1.length + arr2.length;
        int[] arrRes = new int[len];

        for (int i = 0; i < len; i++) {
            if (arr1Index == arr1.length) {
                arrRes[i] = arr2[arr2Index];
                arr2Index++;
            } else if(arr2Index == arr2.length) {
                arrRes[i] = arr1[arr1Index];
                arr1Index++;
            } else if (arr1[arr1Index] < arr2[arr2Index]) {
                arrRes[i] = arr1[arr1Index];
                arr1Index++;
            } else {
                arrRes[i] = arr2[arr2Index];
                arr2Index++;
            }
        }

        return arrRes;
    }

    private static int[] copyArr(int[] sourceArr, int start, int len) {
        int[] resArr = new int[len];
        for (int i = 0; i < len; i++) {
            resArr[i] = sourceArr[i + start];
        }
        return resArr;
    }

}















