package backtrack;

import static java.lang.Math.abs;

public class nQueens {
    int n, flag;
    int[][] board;
    nQueens(int n){
        this.n = n;
        board = new int[n][n];
    }
    int[][] find(int k, int[][] board){
        if(k==n){
            flag = 1;
            return board;
        }
            for(int j=0;j<n;j++) {
                if (place(k, j, board)) {
                    board[k][j]=1;
                    find(k + 1, board);
                }
                if(flag==1)
                    return board;
                board[k][j] = 0;
            }
        return board;
    }

    boolean place(int k, int j, int[][] board){
            for(int i=0;i<n;i++){
                for(int l=0;l<n;l++){
                    if((i==k || l==j || abs(i-k)==abs(l-j)) && board[i][l]==1)
                        return false;
                }
            }
        return true;
    }
}
