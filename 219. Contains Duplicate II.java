public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {//是否有相同的key，也即相同的integer
                if (Math.abs(map.get(nums[i]) - i) <= k) {//check的是hashmap里key对应的value，也即array里index，的差
                    return true;
                } else {
                    map.put(nums[i], i);//因为hashmap的key不能重复，所以将值作为key存入
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
