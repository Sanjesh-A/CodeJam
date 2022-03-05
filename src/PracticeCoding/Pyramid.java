package PracticeCoding;

import java.util.HashMap;

public class Pyramid {


    public HashMap<Tree, Integer> cache = new HashMap<>();

    public int getMaxSum(Tree tree){
        if(cache.containsKey(tree))
            return cache.get(tree);

        if(tree == null)
            return 0;

        if(tree.left == null && tree.right == null)
            return tree.val;

        int result = tree.val + Integer.max(getMaxSum(tree.left), getMaxSum(tree.right));

        cache.put(tree, result);

        return result;

    }

}

class Tree {
    public Tree left;
    public Tree right;
    public int val;
}