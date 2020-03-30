package com.codewithsid;

public class InsertionSort {

    public void sort(int[] array) { // O(n2)
        for (int i = 1; i < array.length; i++) {
           var current = array[i];

           var j=i-1;

           while(j>=0 && array[j] > current) {
               array[j+1] = array[j];
               j--;
           }
           array[j+1] = current;
        }
    }
}
