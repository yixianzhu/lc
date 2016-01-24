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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wraplist = new LinkedList<List<Integer>>();
        //List is abstract; cannot be instantiated
        //must use LinkedList instead
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // Queue is abstract; cannot be instantiated
        //must use LinkedList instead
        
        if(root == null) return wraplist;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelnum = queue.size();
            List<Integer> sublist = new LinkedList<Integer>();
            for(int i=0; i<levelnum; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            wraplist.add(0, sublist);
        }
        return wraplist;
        
    }
}
