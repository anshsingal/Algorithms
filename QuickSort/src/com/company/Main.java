package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s1=new Scanner(System.in);
        System.out.println("enter no of elements in array");
        int n=s1.nextInt();
        System.out.println("enter elements of array");
        int[] array=new int[n];
        for(int i=0;i<n;i++)
            array[i]=s1.nextInt();
        quickSort q1=new quickSort(array, 0);
        q1.sort(0,6);
        System.out.println("sorted array is: "+Arrays.toString(q1.arr));
      //  analysis a1=new analysis();
       // a1.analyse();
    }
}
