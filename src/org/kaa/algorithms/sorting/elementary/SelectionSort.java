package org.kaa.algorithms.sorting.elementary;

import static org.kaa.utils.ArrayUtils.print;
import static org.kaa.utils.ArrayUtils.swap;

public class SelectionSort {

  public static void main(String[] args) {
    int [] array = {4,7,1,3,9,22,646,0};
    print(array);
    sort(array);
    print(array);
  }

  static void sort(int[] array){
    for(int i = 0; i < array.length; i++){
      int min = i;
      for(int j = i + 1; j < array.length; j++){
        if(array[min] > array[j]){
          min = j;
        }
      }
      swap(array, i, min);
    }
  }

}
