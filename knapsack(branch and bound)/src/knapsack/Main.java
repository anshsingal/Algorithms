package knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int capacity, n;
    public static int[] profits, weights;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("input no of items");
        n = s.nextInt();
        System.out.println("input capacity of knapsack");
        capacity = s.nextInt();
        System.out.println("profits of items");
        profits = new int[n];
        for(int i=0;i<n;i++){
            profits[i] = s.nextInt();
        }
        System.out.println("weights of items");
        weights = new int[n];
        for(int i=0;i<n;i++){
            weights[i] = s.nextInt();
        }
        knapsack k = new knapsack();
        node parent = new node(0, new int[1], 0, 0);
        k.find(parent);

        System.out.println("path = " + Arrays.toString(k.optimal.path));
        System.out.println("solution = " + k.optimal.profit);
    }
}
