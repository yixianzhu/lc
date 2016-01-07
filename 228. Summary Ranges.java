//my solution
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList();//这句竟然没写！
        int ini = 0;
        for(int i = 0; i < nums.length; i++){
            if(i-ini != nums[i]-nums[ini]){
                if(i-ini == 1){
                    list.add(Integer.toString(nums[ini]));//"Integer.toString" method
                }else{
                    list.add(nums[ini] + "->" + nums[i-1]);
                }
                ini = i;
            }
            if(i == nums.length-1){//最后一个元素，这个边角情况容易忽略
                if(ini == i){
                    list.add(Integer.toString(nums[ini]));
                }else{
                    list.add(nums[ini] + "->" + nums[i]);
                }
            }
        }
        return list;
    }
}

//other people's solution--处理最后一个元素不一样
public class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> list=new ArrayList();
    if(nums.length==1){
        list.add(nums[0]+"");//这也是一个integer to string的方法
        return list;
    }
    for(int i=0;i<nums.length;i++){
        int a=nums[i];
        while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
            i++;
        }
        if(a!=nums[i]){
            list.add(a+"->"+nums[i]);
        }else{
            list.add(a+"");
        }
    }
    return list;
    }
}
