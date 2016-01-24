// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

//my wrong solution
/*
the problem is that it will overflow
In the question:
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

public class NumArray {
    int[] nums;
    public NumArray(int[] nums) {//seems like you don't know much about constructor

    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int s=i; s<=j&&s<=nums.length; s++){
            sum += nums[s];
        }
        return sum;
    }
}

//correct solution
public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {//in the constructor...
        sum = new int[nums.length];
        if(nums.length>0) sum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            sum[i] = nums[i] + sum[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) {
            return sum[j];//it should be "sum[j]", not "sum[i]"
        }else{
            return sum[j]-sum[i-1];//it should be "sum[i-1]", not "sum[i]"
        }
    }
}





