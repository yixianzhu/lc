// HashMap的工作原理 http://www.importnew.com/7099.html
// HashMap和Hashtable的区别 http://www.importnew.com/7010.html

//my code ---- time runs out
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int size = nums.length;
        for(int i = 0; i < size-1; i++){
            for(int j = i+1; j < size; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}

//solution
//http://blog.welkinlan.com/2015/09/11/contains-duplicate-i-ii-iii-leetcode-java/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}
