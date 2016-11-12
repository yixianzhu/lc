// my solution
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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> nums = new LinkedList<Integer>();
        String temp = "";
        generateNumbers(root, temp, nums);
        int sum = 0;
        ListIterator<Integer> iter = nums.listIterator();
        while(iter.hasNext()) {
            sum += iter.next();
        }
        return sum;
    }
    
    public void generateNumbers(TreeNode root, String temp, List<Integer> nums) {
        temp += root.val;
        if (root.left == null && root.right == null) {
            nums.add(Integer.parseInt(temp));
            temp = temp.substring(0, temp.length()-1);
            return;
        } else {
            if (root.left != null) generateNumbers(root.left, temp, nums);
            if (root.right != null) generateNumbers(root.right, temp, nums);
        }
    }
}





//clean code and fast solution
public int sumNumbers(TreeNode root) {
	return sum(root, 0);
}

public int sum(TreeNode n, int s){
	if (n == null) return 0;
	if (n.right == null && n.left == null) return s*10 + n.val;
	return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
}
