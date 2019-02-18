package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> createArray(int value) {
        ArrayList<Integer> arrayForNumbers = new ArrayList<>();

        System.out.print("Your unsorted array: ");

        for (int i = 0; i < value; i++) {
            arrayForNumbers.add((int)(Math.random() * 50 + 1));
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
            if(arrayListLeft.get(0) >= arrayListRight.get(0)) {
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

        System.out.println();
        printArray(mergedList);
        System.out.println();

        return mergedList;
    }

    public static void main(String[] args) throws IOException {
        /* Create Array. */
        System.out.print("Input size of array: ");

        var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayForNumbers = createArray(Integer.parseInt(bufferedReader.readLine()));
        printArray(arrayForNumbers);

        /* Merge Sort. */
        mergeSort(arrayForNumbers);
    }
}
