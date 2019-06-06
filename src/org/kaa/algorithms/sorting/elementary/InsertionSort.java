package org.kaa.algorithms.sorting.elementary;


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
