package com.codewithsid;

public class Search {

    public int linearSearch(int[] array, int targetValue) {
        for (var i = 0; i < array.length; i++) {
            if (array[i] == targetValue)
                return i;
        }

        return -1;
    }

    public int binarySearchRecursive(int[] array, int targetValue) {
        return binarySearchRecursive(array, targetValue, 0, array.length - 1);
    }

    private int binarySearchRecursive(int[] array, int targetValue, int left, int right) {

        if (right < left)
            return -1;

        var middle = (left + right) / 2;

        if (array[middle] == targetValue)
            return middle;

        if (targetValue < array[middle])
            return binarySearchRecursive(array, targetValue, left, middle - 1);


        return binarySearchRecursive(array, targetValue, middle + 1, right);
    }

    public int binarySearchIterative(int[] array, int targetValue) {
        var left = 0;
        var right = array.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (array[middle] == targetValue)
                return middle;

            if (targetValue < array[middle])
                right = middle - 1;
            else
                left = middle + 1;

        }

        return -1;
    }

    public int ternarySearch(int[] array, int targetValue) {
        return ternarySearch(array, targetValue, 0, array.length - 1);
    }

    public int ternarySearch(int[] array, int targetValue, int left, int right) {
        if (left > right)
            return -1;

        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (array[mid1] == targetValue)
            return mid1;

        if (array[mid2] == targetValue)
            return mid2;

        if (targetValue < array[mid1])
            return ternarySearch(array, targetValue, left, mid1 - 1);

        if (targetValue > array[mid2])
            return ternarySearch(array, targetValue, mid2 + 1, right);

        return ternarySearch(array, targetValue, mid1 + 1, mid2 - 1);
    }

    public int jumpSearch(int[] array, int targetValue) {

        int blocksize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blocksize;

        while (start < array.length && array[next - 1] < targetValue) {
            start = next;

            next += blocksize;
            if (next > array.length)
                next = array.length;
        }

        for (var i = start; i < next; i++)
            if (array[i] == targetValue)
                return i;


        return -1;

    }

    public int exponentialSearch(int[] array, int targetValue) {
        int bound = 1;


        while(bound < array.length && array[bound] < targetValue) {
            bound *= 2;
        }

        int left = bound/2;
        int right = Math.min(bound, array.length-1);

        return binarySearchRecursive(array, targetValue, left, right);
    }
}
