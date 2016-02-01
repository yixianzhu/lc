/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//correct solution -- recursive
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSysmmetrichelp(root.left, root.right);
    }
    
    public boolean isSysmmetrichelp(TreeNode left, TreeNode right){
        if(left == null || right == null){// efficient and smart code
        //这里不能直接left == right，因为child是symmetric的，肯定不相等
            return left == right;
        }
        if(left.val != right.val) return false;
        
        return isSysmmetrichelp(left.left, right.right) && isSysmmetrichelp(left.right, right.left);
    }
}

//correct solution -- non-recursive -- depth-first search
public boolean isSymmetric(TreeNode root) {
    if (root == null)
        return true;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root.left);
    stack.push(root.right);
    while (!stack.isEmpty()) {
        TreeNode node1 = stack.pop();
        TreeNode node2 = stack.pop();
        if (node1 == null && node2 == null)
            continue;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        stack.push(node1.left);
        stack.push(node2.right);
        stack.push(node1.right);
        stack.push(node2.left);
    }
    return true;
}
