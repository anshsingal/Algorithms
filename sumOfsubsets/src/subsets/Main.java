package subsets;

import java.util.Scanner;

import static java.util.Arrays.sort;

public class Main {
    static int[] set;
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    System.out.println("enter no of elements in set");
        int n = s.nextInt();
        System.out.println("enter set elements");
        set = new int[n];
        for(int i=0;i<n;i++)
            set[i] = s.nextInt();
        sort(set);
        System.out.println("enter value of sum of subset elements");
        int d = s.nextInt();
        int[] path = new int[0];
        nodes node = new nodes(0, 0, path);
        new subset(n, set, d).find(node);
    }
}
