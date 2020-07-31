package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n, i;
        int[] arr = new int[20];
        Scanner s = new Scanner(System.in);
        System.out.print("enter no of elements in array\n");
        n = s.nextInt();
        System.out.print("enter elements of array\n");
        for(i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        //System.out.print("counting sort:\n");
        sort sorter = new sort();
        int[] counted_arr = sorter.counter(arr, n);
        //System.out.println("\n");
        int[] radix_arr = sorter.radix(arr, n);
        //System.out.println("counting sort output: \n"+ Arrays.toString(counted_arr));
        System.out.println("sorted array is: "+ Arrays.toString(radix_arr));
    }
}

class radixSort{
    int[] counter(int[] arr, int n){
        int k = max(arr, n);
        int[] instances = new int[k+1];
        for(int i=0;i<n;i++){
            instances[arr[i]]+=1;
        }
        for(int i=1;i<k+1;i++){
            instances[i] += instances[i-1];
        }
        int[] output = new int[n];
        for(int i=n-1;i>=0;i--){
            output[(instances[arr[i]]--)-1] = arr[i];
            //System.out.println(Arrays.toString(instances)+"\t"+Arrays.toString(output));
        }
        return output;
    }

    int[] counter(int[] arr_org, int n, int place){
        int[] arr = arr_org.clone();
        for(int i=0;i<n;i++){
            arr[i] = (int) ((arr[i]/Math.pow(10, place-1))%10);
        }
        int k = max(arr, n);
        int[] instances = new int[k+1];
        for(int i=0;i<n;i++){
            instances[arr[i]]+=1;
        }
        for(int i=1;i<k+1;i++){
            instances[i] += instances[i-1];
        }
        int[] output = new int[n];
        for(int i=n-1;i>=0;i--){
            output[(instances[arr[i]]--)-1] = arr_org[i];
           // System.out.println(Arrays.toString(instances)+"\t"+Arrays.toString(output));
        }
        return output;
    }
    int count;
    int[] radix(int[] arr, int n){
        int largest = max(arr, n);
        count = 0;
        while(largest!=0) {
            largest = largest / 10;
            count += 1;
        }
        for(int i=1;i<=count;i++){
            arr = counter(arr, n, i);
        }
        return arr;
    }

    int max(int[] arr, int n){
        int max=0;
        for(int i=0;i<n;i++){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}