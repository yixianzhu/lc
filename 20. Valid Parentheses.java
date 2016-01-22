/*
1.In java, "" means String, '' means characters
2.

*/
//correct solution
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty())//you need !stack.empty() to handle invalid input and because you can't peek when the stack is empty.
                    return false;
                else if(s.charAt(i) == ')' && stack.pop() != '(')
                    return false;
                else if(s.charAt(i) == ']' && stack.pop() != '[')
                    return false;
                else if(s.charAt(i) == '}' && stack.pop() != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
