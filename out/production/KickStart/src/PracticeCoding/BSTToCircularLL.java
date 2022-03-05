package PracticeCoding;

public class BSTToCircularLL {

    class TreeNode {

        int info;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

    }

    public void inOrderTraverse(TreeNode root){
        if(root != null){
            inOrderTraverse(root.left);
            TreeNode rightNode = root.right;
            process(root,  Successor(root), Predecessor(root));
            inOrderTraverse(rightNode);
        }
    }

    public TreeNode Successor(TreeNode n){
        if(n.right != null)
        return Minimum(n.right);

        TreeNode p = n.parent;
        while(p != null && n == p.right){
            n = p;
            p = p.parent;
        }

        if(p==null)
            return Minimum(n);
        else
            return p;
    }

    public TreeNode Minimum(TreeNode n){
        while(n.left != null)
            n = n.left;

        return n;
    }

    public TreeNode Maximum(TreeNode n){
        while(n.right != null)
            n = n.right;

        return n;
    }


    public TreeNode Predecessor(TreeNode n){
        if(n.left != null)
            return Maximum(n.left);

        TreeNode p = n.parent;
        while(p != null && n == p.left){
            n = p;
            p = p.parent;
        }

        if(p == null)
            return Maximum(n);
        else
            return p;
    }

    public void process(TreeNode n1, TreeNode successor, TreeNode predecessor){
        n1.right = successor;
        n1.left = predecessor;
    }

}
