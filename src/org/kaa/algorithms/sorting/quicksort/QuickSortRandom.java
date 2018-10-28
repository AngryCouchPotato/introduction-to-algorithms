package org.kaa.algorithms.sorting.quicksort;

import static org.kaa.utils.ArrayUtils.print;
import static org.kaa.utils.ArrayUtils.swap;

public class QuickSortRandom extends QuickSort{

  protected void doSort(int[] array, int start, int end){
    if(start < end){
      int q = randomizedPartition(array, start,end);
      doSort(array, start, q - 1);
      doSort(array, q + 1, end);
    }
  }

  protected int randomizedPartition(int[] array, int start, int end) {
    int i = random(start, end);
    swap(array, end, i);
    return partition(array, start, end);
  }

  private static int random(int start, int end) {
    return (int)Math.floor(Math.random() * (end - start + 1) + start);
  }

  public static void main(String[] args) {
    int[] array = new int[]{2,4,6,7,3,5,9,19,55,34,23,21,3,1, 23, 33, 30, 76, 56, 60, 90, 200, 234, 67, 7, 78, 47};
    print(array);
    QuickSort quickSort = new QuickSortRandom();
    quickSort.sort(array);
    print(array);
  }

}
