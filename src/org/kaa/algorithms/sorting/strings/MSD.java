package org.kaa.algorithms.sorting.strings;

import org.kaa.algorithms.sorting.elementary.InsertionSort;

import static org.kaa.utils.ArrayUtils.print;

public class MSD {

    private static int alphabethLength = 256;
    private static final int M = 15;
    private static String[] aux;

    private static int charAt(String word, int index) {
        if(index < word.length()) {
            return word.charAt(index);
        } else {
            return -1;
        }
    }

    static void sort(String[] array) {
        int arrayLength = array.length;
        aux = new String[arrayLength];
        sort(array, 0, arrayLength - 1, 0);
    }

    private static void sort(String[] array, int low, int high, int index) {
        if(high <= low + M) {
            InsertionSort.sort(array, low, high, index);
            return;
        }
        int[] count = new int[alphabethLength + 2];
        for(int i = low; i <= high; i++) {
            count[charAt(array[i], index) + 2]++;
        }
        for(int r = 0; r < alphabethLength + 1; r++) {
            count[r + 1] += count[r];
        }
        for(int i = low; i <= high; i++) {
            aux[count[charAt(array[i], index) + 1]++] = array[i];
        }
        for(int i = low; i <= high; i++) {
            array[i] = aux[i - low];
        }
        for(int r = 0; r < alphabethLength; r++) {
            sort(array, low + count[r], low + count[r + 1] - 1, index + 1);
        }

    }

    public static void main(String[] args) {
        String [] array = getStringArray();
        print(array);
        sort(array);
        print(array);
    }

    private static String[] getStringArray() {
        return new String[]{
                "NOPQRSTUXY",
                "EFGHKLMNOP",
                "FGHKLMNOPQ",
                "DEFGHKLMNO",
                "LMNOPQRSTU",
                "GHKLMNOPQR",
                "CDEFGHKLMN",
                "HKLMNOPQRS",
                "OPQRSTUXYZ",
                "KLMNOPQRST",
                "ABCDEFGHKL",
                "MNOPQRSTUX",
                "KLMNOPQRST",
                "BCDEFGHKLM"
        };
    }
}
