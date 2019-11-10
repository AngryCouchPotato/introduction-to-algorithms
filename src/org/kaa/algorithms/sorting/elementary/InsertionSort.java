package org.kaa.algorithms.sorting.elementary;


import org.kaa.utils.ArrayUtils;

import static org.kaa.utils.ArrayUtils.print;

public class InsertionSort {

  public static void main(String[] args) {
    int [] array = {4,7,1,3,9,22,646,0};
    print(array);
    sort(array);
    print(array);

    int [] array2 = {4,7,1,3,9,22,646,0};
    print(array2);
    sortDescent(array2);
    print(array2);

    int [] array3 = {2, 5, 22, 3, 9, 15, 17, 77, 6, 10, 55, 35};
    print(array3);
    int value = 17;
    int index = searchLinear(array3, value);
    System.out.println(String.format("for %d index = %d", value, index));
    value = 666;
    index = searchLinear(array3, value);
    System.out.println(String.format("for %d index = %d", value, index));
  }

  static void sort(int[] array){
    for(int i = 1;i < array.length;i++){
      int current = array[i];
      int j = i - 1;
      while(j > -1 && array[j] > current){
          array[j + 1] = array[j];
          j--;
      }
      array[j + 1] = current;
    }
  }

  public static void sort(String[] a, int lo, int hi, int d) {
    // Sort from a[lo] to a[hi], starting at the dth character.
    for (int i = lo; i <= hi; i++) {
      for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
        ArrayUtils.swap(a, j, j - 1);
      }
    }
  }

  private static boolean less(String v, String w, int d) {
    for (int i = d; i < Math.min(v.length(), w.length()); i++) {
      if (v.charAt(i) < w.charAt(i)) {
        return true;
      } else if (v.charAt(i) > w.charAt(i)) {
        return false;
      }
    }
    return v.length() < w.length();
  }

  /*
    2.1-2 Rewrite the INSERTION-SORT procedure to sort into nonincreasing instead of non- decreasing order.
  */
  static void sortDescent(int[] array){
    for(int i = 1;i < array.length;i++){
      int current = array[i];
      int j = i - 1;
      while(j > -1 && array[j] < current){
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = current;
    }
  }

  /*
    2.1-3 Consider the searching problem:
  */
  static int searchLinear(int[] array, int value){
    for(int i = 0;i < array.length; i++){
      if(array[i] == value){
        return i;
      }
    }
    return -1;// instead Nil
  }
}
