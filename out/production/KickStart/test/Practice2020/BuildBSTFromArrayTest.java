package Practice2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildBSTFromArrayTest {

    @Test
    void sortedArrayToBST() {
        BuildBSTFromArray  bst = new BuildBSTFromArray();
        int[] A = {1};
        BuildBSTFromArray.TreeNode root = bst.sortedArrayToBST(A);
        System.out.println(root.toString());
    }

    @Test
    void buildBST() {

        String s = "azxbc";
        System.out.println(s);
    }
}