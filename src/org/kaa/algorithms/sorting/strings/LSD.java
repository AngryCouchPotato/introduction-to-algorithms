package org.kaa.algorithms.sorting.strings;

import static org.kaa.utils.ArrayUtils.print;

/*
* least-significant-digit first (LSD) string sort
*
*/
public class LSD {

    static void sort(String[] array, int wordsLength) {// Sort a[] on leading W characters.
        int arrayLength = array.length;
        int alphabethLength = 256;
        String[] aux = new String[arrayLength];

        for(int d = wordsLength - 1; d >= 0; d--) { // Sort by key-indexed counting on dth char.
            int[] count = new int[alphabethLength + 1];

            for(int i = 0; i < arrayLength; i++) { // Compute frequency counts.
                count[array[i].charAt(d) + 1]++;
            }

            for(int j = 0; j <alphabethLength; j++) { // Transform counts to indices.
                count[j + 1] += count[j];
            }

            for(int k = 0; k < arrayLength; k++) { // Distribute.
                aux[count[array[k].charAt(d)]++] = array[k];
            }

            for(int l = 0; l < arrayLength; l++) { // Copy back.
                array[l] = aux[l];
            }
        }
    }

    public static void main(String[] args) {
        String [] array = getStringArray();
        print(array);
        sort(array, 10);
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
