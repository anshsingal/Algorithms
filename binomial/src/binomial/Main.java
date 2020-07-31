package binomial;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.min;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        System.out.println(binomial(n, k));

    }
    static int binomial(int n, int k){
        int[][] array = new int[n+1][k+1];
        array[0][0] = 1;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=min(i,k);j++){
                if(i==j||j==0){
                    array[i][j] = 1;
                }
                else{
                    array[i][j] = array[i-1][j-1]+array[i-1][j];
                }
            }
        }
        for(int i=0;i<=n;i++)
            System.out.println(Arrays.toString(array[i]));
        return array[n][k];
    }
}
