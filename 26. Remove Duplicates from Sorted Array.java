//my solution
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int newlen = 0;
        for(int num : nums){
            if(num != nums[newlen]){
                nums[++newlen] = num;//从原来的“newlen+1++”(不可行)改为“++newlen”（参考了别人的），这样更有效率，且可行
            }
        }
        return ++newlen;
    }
}
