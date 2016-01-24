/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//my correct solution
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            if(p!=q) return false;
            else return true;
        }else{
            if(p.val!=q.val) return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

//more concise version
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;
    if(p.val == q.val)
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    return false;
}
