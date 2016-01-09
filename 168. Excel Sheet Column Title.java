//correct solution1
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;//easy to ignore!!!
            result.insert(0, (char)('A' + n % 26));
            //'A' + n % 26 --> this works
            //convert to char use casting
            n /= 26;
        }

        return result.toString();
    }
}
