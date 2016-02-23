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
//DFS
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null) 
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}

//BDS
//level-order traversal and record current level depth, 
//when meet a node which both child is null then return, no need to go farther
 public int minDepth(TreeNode root) {
    if(root==null) return 0;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    TreeNode endOfLevel = root;
    int depth = 1;

    while( !queue.isEmpty() ) {
        TreeNode node = queue.remove();
        if(node.left==null && node.right==null) return depth;
        if(node.left!=null) queue.add(node.left);
        if(node.right!=null)  queue.add(node.right);
        if(node == endOfLevel) {
            endOfLevel = node.right==null ? node.left : node.right;
            depth++;
        }
    }

    return depth;
}

//another
public class Solution {
public int minDepth(TreeNode root) {
    if (root == null)
        return 0;
    int depth = 1;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    TreeNode temp,magic = new TreeNode(0);
    queue.add(root);
    queue.add(magic);
    while(!queue.isEmpty()){
        temp = queue.poll();
        if(temp.equals(magic)){
            if(!queue.isEmpty()){
                depth++;
                queue.add(magic);
            }
            continue;
        }
        if(temp.left == null && temp.right == null)
            return depth;
        if(temp.left != null)
            queue.add(temp.left);
        if(temp.right != null)
            queue.add(temp.right);
    }
    return depth;
}
}
