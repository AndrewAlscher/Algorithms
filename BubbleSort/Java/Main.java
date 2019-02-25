package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] randomArray(int max, int min, int[] array, int countOfList) {

        int range = (max - min) + 1;
        for(int i = 0; i < countOfList; i++) {
            array[i] = (int)(Math.random() * range) + min;
        }

        return array;
    }

    public static void printOfArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println('\n');
    }

    public static int[] bubbleSort(int[] array) {

        int buf = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i] < array[j]) {
                    buf = array[i];
                    array[i] = array[j];
                    array[j] = buf;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int countOfList = 0;
        int maxArray = 0;
        int minArray = 0;

        try {
            System.out.print("Введите размер списка: ");
            countOfList = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Введите максимальное значение списка: ");
            maxArray = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Введите минимальное значение списка: ");
            minArray = Integer.parseInt(bufferedReader.readLine());
        } catch(IOException exp){
            System.out.println(exp);
        }

        int[] newArray = new int[countOfList];
        newArray = randomArray(maxArray, minArray, newArray, countOfList);

        printOfArray(newArray);

        newArray = bubbleSort(newArray);

        printOfArray(newArray);

    }
}
