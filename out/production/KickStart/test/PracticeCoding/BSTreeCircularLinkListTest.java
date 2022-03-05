package PracticeCoding;

import org.junit.jupiter.api.Test;

class BSTreeCircularLinkListTest {

    @Test
    void inorderTraversal() {
    }

    @Test
    void BSTToCLL(){
        BSTreeCircularLinkList t = new BSTreeCircularLinkList();
        BSTreeCircularLinkList.TreeNode root = t.new TreeNode(5, null);

        root.right = t.new TreeNode(10, root);
        root .left = t.new TreeNode(3, root);

        root.left.left = t.new TreeNode(2, root.left);
        root.left.left.left = t.new TreeNode(1, root.left.left);
        root.left.right = t.new TreeNode(4, root.left);
        root.right.left = t.new TreeNode(9, root.right);
        root.right.right = t.new TreeNode(11, root.right);

        BSTreeCircularLinkList t1 = new BSTreeCircularLinkList(root);
        BSTreeCircularLinkList.TreeNode node = root;
        do {
            System.out.println(node.key);
            node = node.right;

        } while(node != root);

    }
}