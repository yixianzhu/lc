/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Logic here is that if you find a node with either of right or left is absent
 //return the maximum of left/right because one of them is 0 anyway.
 //correct solution
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null) 
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
