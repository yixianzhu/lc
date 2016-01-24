/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//my wrong solution
public class Solution {
    List<String> pathlist = new List<String>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return pathlist;
        }else{
            String path = "" + root.val;
        }
        
        if(root.left == null && root.right == null){
            pathlist.add(path);
        }else{
            
        }
        
        String path += "->" + root.val;
    }
}

//correct solution
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        //the return type shoule be "void"
        if (root.left == null && root.right == null) answer.add(path + root.val);
        //to determin whether we need to add the string
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        //add the "->" here
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }
}
