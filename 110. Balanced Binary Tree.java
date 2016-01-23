/*
IsHeightBalanced(tree)
    return (tree is empty) or 
           (IsHeightBalanced(tree.left) and
            IsHeightBalanced(tree.right) and
            abs(Height(tree.left) - Height(tree.right)) <= 1)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
    return height(root)!=-1;
    }
    
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lH=height(node.left);
        int rH=height(node.right);
        if(lH==-1 || rH==-1 || Math.abs(lH-rH)>1){
            return -1;
        }
    
        return Math.max(lH,rH)+1;
    }
}
