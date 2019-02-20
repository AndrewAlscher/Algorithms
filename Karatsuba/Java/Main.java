package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {


    public static long karatsubaMultiplication(long x, long y){

        int n = (int)(Math.log10(Math.max(x, y)) + 1); // Max length of numbers.

        if(n < 2){
            return x * y;
        }

        int nTwo = (n / 2) + (n % 2); // Take a half of number.

        long xRight = x >> nTwo;
        long xLeft = x - (xRight << nTwo);
        long yRight = y >> nTwo;
        long yLeft = y - (yRight << nTwo);

        //System.out.println(xLeft + " " + xRight + "    " + yLeft + " " + yRight);

        long P1 = karatsubaMultiplication(xLeft, yLeft);
        long P2 = karatsubaMultiplication(xRight, yRight);
        long P3 = karatsubaMultiplication(xLeft + xRight, yLeft + yRight);

        //System.out.println("P1: " + P1 + " P2: " + P2 + " P3: " + P3);
        return P1 + (P3 - P1 - P2 << nTwo) + (P2 << 2 * nTwo);
}

    public static void main(String[] args) {
        try {
            System.out.print("Input x: ");
            BufferedReader xBufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String x = xBufferedReader.readLine();

            System.out.print("Input y: ");
            BufferedReader yBufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String y = yBufferedReader.readLine();

            System.out.println("Just multiply: " + Long.parseLong(x) * Long.parseLong(y));
            System.out.println("Karatsuba multiply: " + karatsubaMultiplication(Long.parseLong(x), Long.parseLong(y)));
        } catch (IOException e)
        {
            System.out.println("IOException");
        }
    }
}
