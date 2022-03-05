package PracticeCoding;

public class BSTreeCircularLinkList {

    public BSTreeCircularLinkList() {

    }

    public class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int key;

        public TreeNode(int i, TreeNode parent) {
            key = i;
            left = null;
            right = null;
            this.parent = parent;
        }
    }


    TreeNode minElement;
    TreeNode maxElement;


    BSTreeCircularLinkList(TreeNode root){
        inorderTraversal(root);
        if(minElement !=null && maxElement!=null){
            minElement.left = maxElement;
            maxElement.right = minElement;
        }
    }

    public void inorderTraversal(TreeNode root){

        if(root != null){
            inorderTraversal(root.left);
            TreeNode rightNode = root.right;
            TreeNode successor = successor(root);
            if(successor == null){
                maxElement = root;
            }
            TreeNode predecessor = predecessor(root);
            if(predecessor == null){
                minElement = root;
            }
            linkNode(root, successor, predecessor);
            inorderTraversal(rightNode);
        }
    }

    private void linkNode(TreeNode root, TreeNode successor, TreeNode predecessor) {
        root.left = predecessor;
        root.right = successor;
    }

    private TreeNode predecessor(TreeNode root) {
        if(root.left != null){
            return maximum(root.left);
        }

        TreeNode parent = root.parent;
        while(parent != null && parent.left == root){
            root = parent;
            parent = root.parent;
        }


        return parent;
    }

    private TreeNode maximum(TreeNode root) {
        while(root.right != null){
            root = root.right;
        }

        return root;
    }

    private TreeNode minimum(TreeNode root) {
        while(root.left !=null){
            root = root.left;
        }
        return root;
    }

    private TreeNode successor(TreeNode root) {
        if(root.right != null){
            return minimum(root.right);
        }

        TreeNode parent = root.parent;
        while(parent != null && parent.right == root){
            root = parent;
            parent = root.parent;
        }

        return parent;
    }
}
