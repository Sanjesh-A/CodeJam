package Practice2020;

public class BuildBSTFromArray {


  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }


    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {
        return  buildBST(A, 0, A.length-1);

    }

    TreeNode buildBST(int[] A, int low, int high){
        if(low == high){
            TreeNode root = new TreeNode(A[low]);
            return root;
        }

        if(low> high)
            return null;

        int mid = (low+high)/2;
        TreeNode leftTree = buildBST(A,low,mid-1);
        TreeNode rightTree = buildBST(A,mid+1, high);
        TreeNode root = new TreeNode(A[mid]);
        root.left = leftTree;
        root.right = rightTree;

        return root;
    }
}

