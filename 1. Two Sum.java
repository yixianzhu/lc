//my wrong solution
/*
这题不能sort，因为要返回index，sort了就改变顺序了
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] result = new int[2];
        for(int i=0; i<nums.length-1; i++){
            int find = target-nums[i];
            int index = binarysearch(nums, find, i+1, nums.length-1);
            if(index != -1){
                result[0] = i+1;
                result[1] = index+1;
                return result;
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }
    
    
    public int binarysearch(int[] num, int number, int low, int high){
        while(low<high){
            int mid = low+(high-low)/2;
            if(num[mid] == number) return mid;
            else if(num[mid] < number) low = mid+1;
            else high = mid;
        }
        return -1;
    }
}

//correct solution
public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i + 1;
            result[0] = map.get(target - numbers[i]);
            return result;
        }
        map.put(numbers[i], i + 1);
    }
    return result;
}
