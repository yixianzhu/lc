//correct solution
/* I have the same thought with this method
however I miss some details.
*/
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {//
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;//need to use char, because this is not an array!
        while(head <= tail) {
            cHead = s.charAt(head);//charAt method
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {//isLetterOrDigit method...
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {//toLowerCae method
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}

/*
cannot use 'for(int head = 0, tail = s.length() - 1; head <= tail; head++, tail--){'
it will be a mess.....
because cHead = s.charAt(head); cannot be used anymore
once used, the problem is that the head in the brackets won't change if head++ or tail--
*/

//another method use Regex, which is slower because it uses a new String
public class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
