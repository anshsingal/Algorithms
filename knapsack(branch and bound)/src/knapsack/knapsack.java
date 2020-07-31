package knapsack;

public class knapsack {

    node optimal;

    knapsack(){
        optimal = new node(0, new int[1], 0, 0);
    }


    void find(node parent){
        if(parent.n<Main.n) {

            int[] new_path = new int[parent.path.length + 1];
            System.arraycopy(parent.path, 0, new_path, 0, parent.path.length);
            new_path[parent.path.length] = Main.profits[parent.n];

            node left = new node(parent.n + 1, new_path, parent.weight + Main.weights[parent.n], parent.profit + Main.profits[parent.n]);
            node right = new node(parent.n + 1, parent.path, parent.weight, parent.profit);
//            System.out.println("left node's optimal solution = " + Arrays.toString(left.path));
//            System.out.println("right node's optimal solution = " + Arrays.toString(right.path));
//            System.out.println("left node's upper bound = " + left.upperBound);
//            System.out.println("right node's upper bound = " + right.upperBound);

            if (optimal.profit <= left.profit) optimal = left;
            if (optimal.profit <= right.profit) optimal = right;
//            System.out.println("optimal solution = " + Arrays.toString(optimal.path));
//            System.out.println("optimal solution's upper bound = " + optimal.upperBound);
//            System.out.println("optimal solution's profit = " + optimal.profit + "\n");


            if (left.upperBound != -1 || right.upperBound != -1) {
                if(left.upperBound != -1){
                if (left.upperBound > right.upperBound) {
                    find(left);
                    find(right);
                } else {
                    find(right);
                    find(left);
                }
            } else {
                find(right);
            }
        }
        }
    }
}
