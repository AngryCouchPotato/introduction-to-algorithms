package org.kaa.utils;

public class ArrayUtils {
  public static void print(int[] array){
    System.out.print("{");
    for(int i = 0; i < array.length; i++){
      System.out.print(array[i]);
      System.out.print((i != (array.length - 1)) ? "," : "");
    }
    System.out.println("}");
  }

  public static void print(String[] array){
    System.out.print("{");
    for(int i = 0; i < array.length; i++){
      System.out.println(array[i]);
      System.out.print((i != (array.length - 1)) ? "," : "");
    }
    System.out.println("}");
  }

  public static void swap(int[] array, int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
