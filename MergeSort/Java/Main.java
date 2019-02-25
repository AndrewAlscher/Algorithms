package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> createArray(int count, int max, int min) {
        ArrayList<Integer> arrayForNumbers = new ArrayList<>();
        int range = (max - min) + 1;

        System.out.print("Your unsorted array: ");

        for (int i = 0; i < count; i++) {
            arrayForNumbers.add((int)(Math.random() * range + min));
        }

        return arrayForNumbers;
    }

    public static void printArray(ArrayList<Integer> arrayList) {
        for (var c : arrayList) {
            System.out.print(c + " ");
        }
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arrayForNumbers) {

        if(arrayForNumbers.size() <= 1) {
            return arrayForNumbers;
        } else {

            ArrayList<Integer> leftArray = new ArrayList<>();
            ArrayList<Integer> rightArray = new ArrayList<>();

            for (int i = 0; i < arrayForNumbers.size(); i++) {
                if (i < arrayForNumbers.size() / 2) {
                    leftArray.add(arrayForNumbers.get(i));
                } else {
                    rightArray.add(arrayForNumbers.get(i));
                }
            }
            leftArray = mergeSort(leftArray);
            rightArray = mergeSort(rightArray);
            return merge(leftArray, rightArray);
        }
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> arrayListLeft, ArrayList<Integer> arrayListRight) {
        ArrayList<Integer> mergedList = new ArrayList<>();

        while(arrayListLeft.size() > 0 && arrayListRight.size() > 0){
            if(arrayListLeft.get(0) <= arrayListRight.get(0)) {
                mergedList.add(arrayListLeft.get(0));
                arrayListLeft.remove(0);
            } else {
                mergedList.add(arrayListRight.get(0));
                arrayListRight.remove(0);
            }
        }

        while(arrayListLeft.size() > 0) {
            mergedList.add(arrayListLeft.get(0));
            arrayListLeft.remove(0);
        }

        while(arrayListRight.size() > 0) {
            mergedList.add(arrayListRight.get(0));
            arrayListRight.remove(0);
        }

        /* System.out.println();
        printArray(mergedList);
        System.out.println(); */

        return mergedList;
    }

    public static void main(String[] args) throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Input size of array: ");
        int count = Integer.parseInt(bufferedReader.readLine());

        System.out.print("Input max value of array: ");
        int maxValue = Integer.parseInt(bufferedReader.readLine());

        System.out.print("Input min value of array: ");
        int minValue = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Integer> arrayForNumbers = createArray(count, maxValue, minValue);
        printArray(arrayForNumbers);


        arrayForNumbers = mergeSort(arrayForNumbers);


        System.out.println();
        System.out.print("Your sorted array: ");
        printArray(arrayForNumbers);
    }
}
