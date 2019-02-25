package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void cocktailSort(int[] array) {
        int left = 0, right = array.length - 1;

        while (left < right) {
            for (int i = left; i < right; i++) {
                if(array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if(array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                }
            }
            left++;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int buf = array[i];
        array[i] = array[j];
        array[j] = buf;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static int[] createRandomArray(int size, int min, int max) {
        int[] array = new int[size];

        int range = (max - min) + 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * range) + min;
        }

        return array;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int size = 0, min = 0, max = 0;

        try{
            System.out.print("Input size of array: ");
            size = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Input min value: ");
            min = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Input max value: ");
            max = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println(e);
        }

        int[] array = createRandomArray(size, max, min);
        printArray(array);

        cocktailSort(array);

        printArray(array);
    }
}
