package org.kaa.algorithms.sorting.quicksort;

import org.kaa.algorithms.sorting.Sortable;

import static org.kaa.utils.ArrayUtils.print;
import static org.kaa.utils.ArrayUtils.swap;

public class QuickSort implements Sortable {

  public void sort(int [] array){
    doSort(array, 0, array.length - 1);
  }

  protected void doSort(int[] array, int start, int end){
    if(start < end){
      int q = partition(array, start,end);
      doSort(array, start, q - 1);
      doSort(array, q + 1, end);
    }
  }

  protected int partition(int[] array, int start, int end){
    int pivot = array[end];
    int i = start - 1;
    for(int j = start; j <= end - 1; j++){
      if(array[j] <= pivot){
        i = i + 1;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, end);
    return i + 1;
  }

  public static void main(String[] args) {
    int[] array = new int[]{2,4,6,7,3,5,9,19,55,34,23,21,3,1};
    print(array);
    QuickSort quickSort = new QuickSort();
    quickSort.sort(array);
    print(array);
  }

}
