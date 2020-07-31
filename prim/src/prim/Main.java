package prim;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        //System.out.println("enter weight matrix");
        int[][] weight = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                weight[i][j] = s.nextInt();
            }
        }
        int[][] span = prims(weight, n);
        for(int i=0;i<n;i++)
            System.out.println(Arrays.toString(span[i]));
    }

    static int[][] prims(int[][] weight, int n){
        int[] visited = new int[n];
        visited[0] = 1;
        int smallest, smallestJ = 0, smallestI = 0;
        int[][] span = new int[n][n];
        for(int k=0;k<n;k++){
            smallest = -1;
            for(int i=0;i<n;i++){
                if(visited[i]==1){
                    for(int j=0;j<n;j++){
                        if(visited[j]==0){
                            if(weight[i][j]<smallest || smallest==-1){
                                smallestJ = j;
                                smallestI = i;
                                smallest = weight[i][j];
                            }
                        }
                    }
                }
            }
            visited[smallestJ] = 1;
            span[smallestI][smallestJ] = 1;
        }
        return span;
    }
}
