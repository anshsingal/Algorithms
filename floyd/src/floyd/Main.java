package floyd;

//import static java.lang.Integer.sum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = s.nextInt();
            }
        }
        floyd(arr, n);
    }

    static void floyd(int[][] arr, int n){
        int[][] temp = new int[n][n];
        int sum = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                sum = sum+arr[i][j];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(arr[i][j]==0 && i!=j)
                    arr[i][j] = sum+1;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    temp[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
            arr = temp;
        }
        for(int i=0;i<n;i++)
            System.out.println(Arrays.toString(arr[i]));
    }
}
