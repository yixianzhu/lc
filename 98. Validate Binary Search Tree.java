/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //corner case: Integer.MIN_VALUE, Integer.MAX_VALUE不能作为初始值设置
 //两个解决办法，一个是用long，另一个是初始值设置null
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}


//inorder traversal
ublic boolean isValidBST (TreeNode root){
           Stack<TreeNode> stack = new Stack<TreeNode> ();
           TreeNode cur = root ;
           TreeNode pre = null ;           
           while (!stack.isEmpty() || cur != null) {               
               if (cur != null) {
                   stack.push(cur);
                   cur = cur.left ;
               } else {                
                   TreeNode p = stack.pop() ;
                   if (pre != null && p.val <= pre.val) {                      
                       return false ;
                   }                   
                   pre = p ;                       
                   cur = p.right ;
               }
           }
           return true ; 
       }
