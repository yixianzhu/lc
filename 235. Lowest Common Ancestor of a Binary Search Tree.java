/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//my solution
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val==root.val || q.val==root.val){
            return root;
        }else if(p.val<root.val){
            if(q.val<root.val) return lowestCommonAncestor(root.left, p, q);
            else{
                return root;
            }
        }else if(q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}


//correct solution
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while ((root.val - p.val) * (root.val - q.val) > 0)
        root = p.val < root.val ? root.left : root.right;
    return root;
}
//in case of overflow, it's better to use (root.val - (long)p.val) * (root.val - (long)q.val)
