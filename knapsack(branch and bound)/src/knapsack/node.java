package knapsack;

public class node {
    int upperBound, n, weight, profit;
    int[] path;
    node(int n, int[] path, int weight, int profit){
        this.n = n;
        this.path = path.clone();
        this.weight = weight;
        this.profit = profit;
        calcUpperBound();
    }

    void calcUpperBound(){
        if(weight>Main.capacity) {
            upperBound = -1;
            profit = -1;
        }
        else if(n<Main.n)
            upperBound = profit + (Main.capacity-weight)*(Main.profits[n]/Main.weights[n]);
        else
            upperBound = profit;
    }
}
