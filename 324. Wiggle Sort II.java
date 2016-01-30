public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int[] temp = new int[nums.length];
    int mid = nums.length%2==0?nums.length/2-1:nums.length/2;
    int index = 0;
    for(int i=0;i<=mid;i++){
        temp[index] = nums[mid-i];
        if(index+1<nums.length)
            temp[index+1] = nums[nums.length-i-1];
        index = index+2;
    }
    for(int i=0;i<nums.length;i++){
        nums[i] = temp[i];
    }
}



Java

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int s = (nums.length + 1) >> 1, t = nums.length;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = (i & 1) == 0 ?  nums[--s] : nums[--t] ;
        }

        for (int i = 0; i < nums.length; i++)
            nums[i] = temp[i];
    }
}


public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int s = (nums.length + 1) >> 1, t = nums.length;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = (i & 1) == 0 ?  nums[--s] : nums[--t] ;
        }
 
        for (int i = 0; i < nums.length; i++)
            nums[i] = temp[i];
    }
}
