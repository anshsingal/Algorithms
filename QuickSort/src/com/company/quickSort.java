package com.company;

import java.util.Arrays;

public class quickSort{
    int[] arr;
    int  count;

    quickSort(int[] arr, int count){
        this.arr=arr.clone();
        this.count=count;
    }
    quickSort(){}

    void swap(int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    void sort(int low, int high){
        int i;
        if(low<high){
            i=partition(low,high);
            sort(low, i-1);
            sort(i+1, high);
        }
    }

    int partition(int low, int high){
        int pivot=arr[low];
        int i=low+1;
        for(int j=low; j<=high; j++){
            count++;
            if(arr[j]<pivot){
                //count++;
                swap(j, i);
                i++;
            }
        }
        swap(i-1, low);
        //System.out.println(Arrays.toString(this.arr));
        return i-1;
    }
}
