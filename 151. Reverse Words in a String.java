public class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");//trim is important!
        String result = "";
        if(split.length>0){//should not forget this line
            for(int i=split.length-1; i>0; i--){//这个for循环到i=1停止，因为最后一个单词之后不用加空格
                result += split[i] + " ";
            }
            result += split[0];          
        }
        return result; 
    }
}
