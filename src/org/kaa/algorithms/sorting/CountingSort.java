package org.kaa.algorithms.sorting;

import static org.kaa.utils.ArrayUtils.print;

public class CountingSort {

  public static int[] sort(int[] array) {
    int max = searchMax(array);
    return doSort(array, max);
  }

  private static int searchMax(int[] array) {
    int max = 0;
    for(int i = 0; i < array.length; i++){
      if(array[i] > max){
        max = array[i];
      }
    }
    return max;
  }

  private static int[] doSort(int[] array, int max) {
     int[] temp = new int[max + 1];
     for(int i = 0; i < array.length; i++){
       temp[array[i]] = temp[array[i]] + 1;
     }
     for(int i = 1; i < temp.length; i++){
       temp[i] = temp[i] + temp[i - 1];
     }
     int[] result = new int[array.length];
     for(int i = array.length - 1; i >= 0; i--){
       result[temp[array[i]] - 1] = array[i];
       temp[array[i]] = temp[array[i]] - 1;
     }
     return  result;
  }

  public static void main(String[] args) {
    int [] array = {2, 5, 3, 0, 2, 3, 0, 3};
    int[] result;
    print(array);
    result = sort(array);
    print(result);

    int [] array2 = {6, 0, 2, 0, 1, 3, 4, 6, 1, 3, 2};
    print(array2);
    result = sort(array2);
    print(result);
  }

}
