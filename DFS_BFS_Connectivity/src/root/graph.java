package root;

import java.util.Scanner;

public class graph {
    int[][] adj;
    int[] visited;
    int n;

    public graph(){
        Scanner s = new Scanner(System.in);
        //System.out.println("enter no. of elements");
        int n = s.nextInt();
        //System.out.println("enter adjacency matrix");
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = s.nextInt();
            }
        }
        this.adj = arr.clone();
        this.n = n;
        //visited = new int[n];
    }

    void computeComponents(int source) {
        visited = new int[n];
        int no = 0;
        dfs(source, ++no);
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, ++no);
            }
        }

        for(int i=1;i<=no;i++){
            System.out.println("component: "+i+" vertices: ");
            for(int j=0; j<n;j++){
                if(visited[j]==-i){
                    System.out.print(j+"\t");
                }
            }
            System.out.println("\n");
        }
    }
    void dfs(int source, int no){
        visited[source] = -no;
        //System.out.println("exploring vertex "+ source);
        for(int i=0;i<n;i++){
            if(adj[source][i]==1 && visited[i]==0){
                dfs(i, no);
            }
        }
    }

    void getBFS(int source){
        visited = new int[n];
        System.out.println("bfs traversal: ");
        bfs(source);
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                System.out.println("next component:");
                bfs(i);
            }
        }
    }
    void bfs(int source){
        int[] q = new int[n];
        int head=-1, tail=-1, cur;
        visited[source] = 1;
        q[++head] = source;
        System.out.print(source+"\t");
        while(head!=tail){
            cur = q[++tail];
            //visited[cur] = 1;
            for(int i=0;i<n;i++){
                if(adj[cur][i]==1 && visited[i]==0){
                    q[++head] = i;
                    visited[i] = 1;
                    System.out.print(i+"\t");
                }
            }
        }
    }

}
