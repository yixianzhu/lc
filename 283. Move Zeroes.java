//my solution
public class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int zero = 0;
        for(int i = length-1; i >= 0; i--){
            if(nums[i] == 0){
                for(int j = i+1; j < length; j++){
                    nums[j-1] = nums[j];
                }
                zero++;
                nums[length-zero] = 0;
            }
        }
    }
}

//faster code
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;        
    
        int insertPos = 0;
        for (int num: nums) {//学会这个for 循环写法！！
            if (num != 0) nums[insertPos++] = num;//这样的查询可以很有效的移动，O(n)，上面的接近O(n^2)
        }        
    
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
