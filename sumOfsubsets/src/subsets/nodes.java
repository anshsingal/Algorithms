package subsets;

public class nodes {
    int[] path;
    int level, sum;

    nodes(int sum, int level, int[] path){
        this.sum = sum;
        this.level = level;
        this.path = path.clone();
    }
}
