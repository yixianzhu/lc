//two pass
public void sortColors(int[] nums) {
    // 2-pass
    int count0 = 0, count1 = 0, count2 = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {count0++;}
        if (nums[i] == 1) {count1++;}
        if (nums[i] == 2) {count2++;}
    }
    for(int i = 0; i < nums.length; i++) {
        if (i < count0) {nums[i] = 0;}
        else if (i < count0 + count1) {nums[i] = 1;}
        else {nums[i] = 2;}
    }
}

//one pass
public class Solution {
    public void sortColors(int[] nums) {
        int h = 0;
        int t = nums.length-1;
        int move = 0;
        while(move<=t){
            if(nums[move] == 0){
                nums[move] = nums[h];
                nums[h] = 0;
                h++;
            }
            if(nums[move] == 2){
                nums[move] = nums[t];
                nums[t] = 2;
                t--;//please be careful!!
                move--;//this one is really tricky, because we have to check whether the new number placed here equals to 0
            }
            move++;
        }

    }
}


