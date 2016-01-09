//correct solution
//主要是注意Corner case，如下所示：
//1. null or empty string
//2. white spaces，可以直接用trim
//3. +/- sign
//4. calculate real value
//5. handle min & max。溢出：简单处理可以用long或者double存放结果最后强转回来；或者累积算结果时提前对 max/10或者min/10比较一下来预测是否会溢出，等到溢出再比较就来不及了。
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    //1. Empty string
    if(str.length() == 0) return 0;

    //2. Remove Spaces
    while(str.charAt(index) == ' ' && index < str.length())
        index ++;
    //str = str.trim();

    //3. Handle signs
    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }

    //4. Convert number and avoid overflow
    while(index < str.length()){
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;

        //check if total will be overflow after 10 times and add digit
        if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        total = 10 * total + digit;
        index ++;
    }
    return total * sign;
}

//a little improvement
public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int i = 0, len = str.length();
        int num = 0, sign = 1, bound = Integer.MAX_VALUE / 10;//先说num = 0， 这样如果是“ ”或者null，也会返回0

        // 1. Remove whitespace
        while(i < len && str.charAt(i) == ' ') i ++;//判断条件

        // 2. Handle signs
        if(i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {//判断条件还要加上i<len
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }

        // 3. Convert number
        while(i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int digit = str.charAt(i++) - '0';
            boolean overlow = (num == bound && digit >= 8) || num > bound;
            if(overlow) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            num = num * 10 + digit;
        }

        return sign * num;
    }
}
