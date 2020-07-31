package knapsack;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.max;

public class Main {

    public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            //System.out.println("input no of items");
            n = s.nextInt();
            //System.out.println("input capacity of knapsack");
            capacity = s.nextInt();
           // System.out.println("profits of items");
            profits = new int[n+1];
            for(int i=1;i<=n;i++){
                profits[i] = s.nextInt();
            }
            //System.out.println("weights of items");
            weights = new int[n+1];
            for(int i=1;i<=n;i++){
                weights[i] = s.nextInt();
            }
            int[][] array = new int[n+1][capacity+1];
            buildArray(array, n);
            System.out.println("optimal: ");
            find(array, n);
            System.out.println("\nmatrix:");
            for(int i=0;i<=n;i++)
               System.out.println(Arrays.toString(array[i]));
            //System.out.println("path = " + Arrays.toString(optimal));
            System.out.println("solution = " + array[n][capacity]);
        }
    static int capacity, n;
    static int[] profits, weights;

    static void buildArray(int[][] array, int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=capacity;j++){
                if(j-weights[i]<0)
                    array[i][j] = array[i-1][j];
                else
                    array[i][j] = max(array[i-1][j], profits[i] + array[i-1][j-weights[i]]);
            }
        }
    }

    static void find(int[][] array, int n){
        //int[] arr = new int[1];
        //ArrayList<Integer> optimal = new ArrayList<Integer>(Arrays.<Integer>asList(arr));
        int i = n;
        int j = capacity;
        while(i>0){
            if (array[i][j] != array[i - 1][j]) {
                System.out.print(profits[i]+"\t");
                j = j - weights[i];
            }
            i = i-1;
        }
        //int[] arr = new int[0];
        //return optimal.toArray(arr);
    }
}
