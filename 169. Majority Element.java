//correct solution
//关键是思路没想到，既然是超过n/2的，那么不用管其他不是majority的数格子出现几次，只要都归到不是majority number的那类就行
public class Solution {
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}
