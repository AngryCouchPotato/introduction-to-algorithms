package org.kaa.algorithms.sorting.mergesort;

import static org.kaa.utils.ArrayUtils.print;

public class MergeSort {

  public static void main(String[] args) {
    int [] array = {4, 7, 1, 3, 9, 22, 646, 0, 123, 55, 432, 2, 8, 533, 777, 57};
    print(array);
    sort(array);
    print(array);
  }

  static void sort(int[] array){
    int[] aux = new int[array.length];
    doSort(array, aux, 0, array.length - 1);
  }

  private static void doSort(int[] array, int[] aux, int low, int high){
    if(low >= high) return;
    int mid = low + (high - low)/2;
    doSort(array, aux, low, mid);
    doSort(array, aux,  mid + 1, high);
    merge(array, aux, low, mid,  high);
  }

  static void merge(int[] origin, int[] aux, int low, int mid, int high){
    for(int k = low; k <= high; k++){
      aux[k] = origin[k];
    }
    int i = low, j = mid + 1;
    for(int k = low; k <= high; k++){
      if(i > mid)               origin[k] = aux[j++];
      else if (j > high)        origin[k] = aux[i++];
      else if (aux[i] > aux[j]) origin[k] = aux[j++];
      else                      origin[k] = aux[i++];
    }
  }
}
