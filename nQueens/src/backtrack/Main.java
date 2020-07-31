package backtrack;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    System.out.println("enter no. of queens");
	    int n = s.nextInt();
	    nQueens q = new nQueens(n);
	    int[][] board = new int[n][n];
	    int[][] ans = q.find(0, board);
	    for(int i=0;i<n;i++)
	    	System.out.println("board: " + Arrays.toString(ans[i]));
    }
}
