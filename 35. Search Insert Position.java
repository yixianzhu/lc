public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int lo = 0;
        int hi = len-1;
        int mid = 0;
        while(lo <= hi){
            mid = lo + (hi-lo)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target<nums[mid]){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return lo;//it's so easy but I think too complex
    }
}
