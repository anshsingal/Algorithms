package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter no of elements in array");
        int n = s.nextInt();
        System.out.println("enter elements of array");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        shell sh = new shell(arr, n);
        sh.sort();
        System.out.println("sorted array is: "+ Arrays.toString(sh.arr));
    }
}

class shell{
    int[] arr;
    int n;

    shell(int[] arr, int n){
        this.arr = arr.clone();
        this.n = n;
    }

    void sort(){
        int j, i;
        int gap = n/2;
        while(gap>=1){
            j = gap;
            while(j<n){
                i = j;
                while(i>=0){
                    if (i-gap>=0 && arr[i]<arr[i-gap]) {
                        swap(i, i - gap);
                    }
                    else
                        break;
                    i = i-gap;
                }
                j = j+gap;
            }
            gap = gap/2;
        }
    }

    void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}