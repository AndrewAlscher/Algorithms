package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] insertionSort(int[] oldArray) {
        int[] newArray = new int[oldArray.length];

        for (int i = 0; i < oldArray.length; i++) {
            int key = oldArray[i];
            int  j = i - 1;

            while(j >= 0 && newArray[j] > key) {
                newArray[j + 1] = newArray[j];
                j--;
            }

            newArray[j + 1]  = key;
        }

        return newArray;
    }

    public static int[] createArray(int count, int max, int min) {
        int[] array = new int[count];
        int range = (max - min) + 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * range) + min;
        }

        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = 0, max = 0, min = 0;

        try{
            System.out.print("Input count of array: ");
            count = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Input max value of array: ");
            max = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Input min value of array: ");
            min = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println(e);
        }

        int[] array = createArray(count, max, min);

        printArray(array);

        array = insertionSort(array);

        printArray(array);
    }
}
