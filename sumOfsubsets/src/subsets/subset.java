package subsets;

import java.util.Arrays;

public class subset {
    int[] set;
    int n, d;

    subset(int n, int[] set, int d){
        this.n = n;
        this.set = set.clone();
        this.d = d;
    }

    void find(nodes node){
        if(node.sum == d)
            System.out.println(Arrays.toString(node.path));
        else{
            if(node.sum<d && node.level<n){

                int[] new_path = new int[node.path.length + 1];
                System.arraycopy(node.path, 0, new_path, 0, node.path.length);
                new_path[node.path.length] = Main.set[node.level];

                nodes left = new nodes(node.sum+Main.set[node.level], node.level+1, new_path);
                nodes right = new nodes(node.sum, node.level+1, node.path);

                find(left);
                find(right);
            }
        }
    }
}
