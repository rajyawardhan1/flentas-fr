package com.flentas.fr;

public class TempleUtil {

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    public static int[] sortCrossingValues(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sortCrossingValues(arr, low, pi - 1);
            sortCrossingValues(arr, pi + 1, high);
        }
        return arr;
    }

    public static int[] removeMinimumTwoElement(int[] arr) {

        int[] anotherArray = new int[arr.length - 2];
        for (int i = 2, k = 0; i < arr.length; i++) {
            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }

    public static int[] removeMaximumTwoElement(int[] arr) {

        int[] anotherArray = new int[arr.length - 2];
        for (int i = 0, k = 0; i < arr.length - 2; i++) {
            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }

    public static int[] removeElementByIndex(int[] arr, int index) {

        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) continue;
            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }

    public static int[] addElementToArray(int[] arr, int element) {
        int[] anotherArray = new int[arr.length + 1];

        System.arraycopy(arr, 0, anotherArray, 0, arr.length);
        anotherArray[anotherArray.length - 1] = element;

        return anotherArray;
    }

    public static int[] addTwoElementsToArray(int[] arr, int firstElement, int secondElement) {
        int[] anotherArray = new int[arr.length + 2];

        System.arraycopy(arr, 0, anotherArray, 0, arr.length);
        anotherArray[anotherArray.length - 1] = firstElement;
        anotherArray[anotherArray.length - 2] = secondElement;

        return anotherArray;
    }
}
