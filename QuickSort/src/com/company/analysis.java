package com.company;

import java.util.Random;

public class analysis extends quickSort{
    analysis(int[] arr, int count) {
        super(arr, count);
    }
    analysis(){}
    /*analysis(int[] arr, int count){
        super(arr, count);
    }*/

    void analyse(){
            //quickSort q1=new quickSort();
            Random rand=new Random();
            int[] a=new int[1000];
            int[] b=new int[1000];
            int[] c=new int[1000];
            System.out.println("iter\t"+"ASC\t"+"DES\t"+"RAND");
            for(int i=16;i<1000;i=i*2) {
                for(int j=0;j<i;j++){
                    a[j]=j;
                    b[j]=i-j-1;
                    c[j]=rand.nextInt(1000);
                }
                super.count=0;
                super.arr=a.clone();
                sort(0,i-1);
                int c1=super.count;
                super.count=0;
                super.arr=b.clone();
                sort(0,i-1);
                int c2=super.count;
                count=0;
                super.arr=c.clone();
                sort(0,i-1);
                int c3=super.count;
                super.count=0;
                System.out.println(i+"\t\t"+c1+"\t\t"+c2+"\t\t"+c3);
        }
    }
}
