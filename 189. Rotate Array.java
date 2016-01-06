//my solution -- Time Limit Exceeded 
public class Solution {
    public void rotate(int[] nums, int k) {
        if(k < nums.length){
            for(int i = 0; i < k; i++){
                int temp = nums[nums.length-1];
                for(int j = nums.length-1; j > 0; j--){
                    nums[j] = nums[j-1];
                }
                nums[0] = temp;
            }
        }
    }
}

//my solution2
public class Solution {
    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = k % nums.length;
        }
        int[] temp = new int[k];
        for(int i = nums.length-k; i < nums.length; i++){
            temp[i-nums.length+k] = nums[i];
        }
        for(int i = nums.length-k-1; i >= 0; i--){
            nums[i+k] = nums[i];
        }
        for(int i = 0; i < k; i++){
            nums[i] = temp[i];
        }
        
    }
}
