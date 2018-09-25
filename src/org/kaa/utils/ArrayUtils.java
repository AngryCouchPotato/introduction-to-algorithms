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
}
