package com.codewithsid;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] names) {
        int[][] bombs = {{0, 0}, {0, 1}, {1, 2}};

        int[][] field2 = {{-1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, -1}};
        int[][] result = click(field2, 4, 4, 1, 3);
        //int[][] result = mineSweeper(bombs, 3, 4);

        System.out.println(java.util.Arrays.deepToString(result));
    }

    public static int[][] mineSweeper(int[][] bombs, int numOfRows, int noOfCols) {
        int[][] mineSweeper = new int[numOfRows][noOfCols];

        for (int[] bomb: bombs) {
            int rowIndex = bomb[0];
            int colIndex = bomb[1];
            mineSweeper[rowIndex] [colIndex] = -1;

            for( int i = rowIndex-1; i<= rowIndex+1; i++) {
                for (int j = colIndex - 1; j <= colIndex + 1; j++) {
                    if( (0 <= i && i < numOfRows) && (0 <= j && j < noOfCols) && mineSweeper[i][j] != -1)
                        mineSweeper[i][j] += 1;

                }
            }
        }

        return mineSweeper;
    }

    public static int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {

        Queue<int[]> queue = new ArrayDeque<>();
        if(field[givenI][givenJ] == 0) {
            field[givenI][givenJ] = -2;
            queue.add(new int[]{givenI, givenJ});
        }
        else {
            return field;
        }

        while(!queue.isEmpty()) {
            int[] newCoordinates = queue.remove();
            int currentI = newCoordinates[0];
            int currentJ = newCoordinates[1];

            for (int i = currentI - 1; i <= currentI + 1; i++) {
                for (int j = currentJ -1; j <= currentJ + 1; j++) {
                    if ((0 <= i && i < numRows) && (0 <= j && j < numCols) && field[i][j] == 0) {
                        field[i][j] = -2;
                        queue.add(new int[]{i, j});
                    }

                }
            }
        }
        return field;
    }



}
