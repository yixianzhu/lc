/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//it is much more easier to substract from 'sum' than add up to 'sum'

//my wrong solution
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        int paths = 0;
        int addup = 0;
        boolean last = true;
        return sumHelper(root, sum);
    }
    
    public boolean sumHelper(TreeNode root, int sum){
        if(root == null){
            if(paths>0 && addup == sum) return true;
            else if (last) return false;
        }else{
            addup += root.val;
            return sumHelper(root.left) || sumHelper(root.right);
        }
    }

}

//correct solution
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
