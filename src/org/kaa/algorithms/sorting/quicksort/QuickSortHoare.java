package org.kaa.algorithms.sorting.quicksort;

import static org.kaa.utils.ArrayUtils.print;
import static org.kaa.utils.ArrayUtils.swap;

public class QuickSortHoare extends QuickSort{

  public void sort(int [] array){
    doSort(array, 0, array.length - 1);
  }

  protected int partition(int[] array, int start, int end){
    int pivot = array[start];
    int i = start - 1;
    int j = end + 1;
    while(true) {
      do {
        j--;
      } while(array[j] > pivot);
      do {
        i++;
      } while(array[i] < pivot);
      if(i < j) {
        swap(array, i, j);
      } else {
        return j;
      }
    }
  }

  public static void main(String[] args) {
    int[] array = new int[]{13, 19, 9, 5, 12, 8, 7, 4, 11, 2, 6, 21};
    print(array);
    QuickSort quickSort = new QuickSortHoare();
    quickSort.sort(array);
    print(array);
  }

}
