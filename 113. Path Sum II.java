//backtracking, DFS

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sublist = new ArrayList<Integer>();
        pathSum(root, sum, sublist, result);
        return result;
    }
    
    public void pathSum(TreeNode root, int sum, List<Integer> sublist, List<List<Integer>> result){
        if (root == null) {
            return;
        }
        sublist.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            // when you use add function of List, it just add a copy of reference of the object into 
            // the List instead of a new copy of the object. So if you don't create a new copy, all the 
            // reference you add to your result refer to the same object.
            result.add (new ArrayList(sublist));
        } else {
             pathSum(root.left, sum-root.val, sublist, result);
             pathSum(root.right, sum-root.val, sublist, result);
        }
        // This is the backtracking point. If we execute two sub recursive code in else branch and still
        // can't get a match pathSum, this means the current "root" which already added into the List 
        // currentResult can not lead us to the correct answer. So we need to remove it from List currentResult 
        // and try other possible branches, this is what backtracking means.
        sublist.remove(sublist.size()-1);
    }
}
