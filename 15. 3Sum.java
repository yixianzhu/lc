//my wrong solution
/*
整个思路都不缜密
针对每个i找到sum为0的就下一个i的话可能会错过不同的head tail组合。 
比如nums[0]=-6, nums[1]=1, nums[2]=2, nums[3]=4, nums[4]=5
另外会把重复的head tail组合放进去
所以应该针对每个i，head++ tail--不断进行到相遇
并且如果head++或tail--的时候遇到相同值，直接继续++--下去
*/
public class Solution{
    public List<List<Integer>> threeSum(int[] nums){
    	List<List<Integer>> list = new ArrayList<>();
    	Arrays.sort(nums);//先确认是不是sort的？
    	for(int i=0; i<nums.length-2; i++){
    		int head =i+1;
    		int tail = nums.length-1;
    		int temp = nums[i] + nums[head] + nums[tail];
    		while(temp != 0 && head<tail-1){
                if(temp<0){
                head++;
                }else{
                	tail--;
                }
            }
    
            if(temp == 0){
            	List<Integer> sumzero = new ArrayList<>();
        		sumzero.add(nums[i]);
        		sumzero.add(nums[head]);
        		sumzero.add(nums[tail]);
        		list.add(sumzero);
            }
        }
            return list;
    }
}


//correct solution
public class Solution{
    public List<List<Integer>> threeSum(int[] nums){
    	List<List<Integer>> list = new ArrayList<>();//cannot use List 在等式的右边
    	Arrays.sort(nums);
    	for(int i=0; i<nums.length-2; i++){
    	    if(i==0 || (i>0 && nums[i] != nums[i-1])){
    	        int head = i+1, tail = nums.length-1, target = 0-nums[i];
    	        while(head<tail){
    	            if(nums[head]+nums[tail] == target){
    	                list.add(Arrays.asList(nums[i],nums[head],nums[tail]));//Arrays.asList
    	                while(head<tail && nums[head] == nums[head+1]) head++;
    	                while(head<tail && nums[tail] == nums[tail-1]) tail--;//tail-1, not "+1"
    	                head++;
    	                tail--;
    	            }else if(nums[head]+nums[tail]<target){
    	                head++;
    	            }else{
    	                tail--;
    	            }
    	        }
    	    }
    	     
    	}
        return list;
    }
}
