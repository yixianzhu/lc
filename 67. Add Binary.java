//toCharString java api:https://docs.oracle.com/javase/7/docs/api/
//correct solution
public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        char[] aArray = a.toCharArray();//String to array的方法：xx.toCharArray()
        char[] bArray = b.toCharArray();
        StringBuilder stb = new StringBuilder();//这样可以用append的方法
        //比StringBuffer快，但不能保证synchronization

        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int aByte;
        int bByte;
        int carry = 0;
        int result;

        while(i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;//这种判断的方法挺多见的
            bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;
            // result = aByte ^ bByte ^ carry;//http://www.runoob.com/java/java-operators.html
            // ^是按位异或操作符
            result = (aByte + bByte + carry)%2;
            // carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
            carry = (aByte + bByte + carry)/2;
            stb.append(result);
            //The append method always adds these characters at the end of the builder; the insert method adds the characters at a specified point.
        }
        return stb.reverse().toString();//然后再reverse过来，然后toString
    }
}

//a simplified (a little) solution
public class Solution {
    public String addBinary(String a, String b) {
        if(len1==0 || len2==0)
        return len1==0? b: a;//时间复杂度是一样的，行数少一点


        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int aBit;
        int bBit;
        int carry = 0;
        int result;

        while(i >= 0 || j >= 0 || carry == 1) {
            aBit = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;//并没有将string改为array，所以这里不是用aArray[i--]，而是用(a.charAt(i--)
            bBit = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
            result = aBit ^ bBit ^ carry;
            carry = ((aBit + bBit + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();//都要toString一下
    }
}
