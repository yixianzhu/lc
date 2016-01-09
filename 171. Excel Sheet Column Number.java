//my wrong solution
public class Solution {
    public int titleToNumber(String s) {
        if(s.length() == 1){
            return s.toChar()-'A'+1;//没有toChar()这个方法，只有toCharArray()
            return 0;
        }
        else{
            return ((int)s.charAt(0)-(int)'A'+1)*26 +(int)s.charAt(1)-(int)'A'+1;//charAr return char variables
        }
        
    }
}

//correct solution
int result = 0;
for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++);
return result;
