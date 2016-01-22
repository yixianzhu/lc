//corrrect solution
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        String pre = strs[0];
        int i = 1;
        while(i<strs.length){
            while(strs[i].indexOf(pre) != 0){//if it's strs[i]'s prefix, it will return "0"
                pre = pre.substring(0, pre.length()-1);
            }
            i++;
        }
        return pre;
    }
}
