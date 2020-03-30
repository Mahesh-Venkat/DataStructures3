package com.codewithsid;

public class Countingsort {
    public void sort(int[] array, int max) {
        int[] counts = new int[max+1];

        for(var itm: array)
            counts[itm] ++;

        var k= 0;
        for(var i=0; i<counts.length; i++) {
            for(var j=0; j<counts[i]; j++) {
                array[k++] = i;
            }
        }
    }
}
