package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter no of elements in array");
        int n = s.nextInt();
        System.out.println("enter elements of array");
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = s.nextInt();
        }
        heap h = new heap(arr, n);
        h.sort();
        System.out.println("sorted array is: "+ Arrays.toString(h.arr));
    }
}

class heap{
    int[] arr;
    int n;

    heap(int[] arr, int n){
        this.arr = arr.clone();
        this.n = n;

        for(int i=n/2; i>=1; i--){
            maxHeapify(i);
        }
    }

    void maxHeapify(int i){
        int largest = i;
        int right = i*2+1, left = i*2;

        if(left<=n && arr[left]>arr[largest])
            largest = left;
        if(right<=n && arr[right]>arr[largest])
            largest = right;

        if(largest!=i){
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    void sort(){
        int n_org = n;
        while(n>1){
            swap(1, n);
            n = n-1;
            maxHeapify(1);
        }
        n = n_org;
    }

    void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
