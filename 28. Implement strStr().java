public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

//actually it wants me to implement the indexOf method
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        int len = needle.length();
        for(int i=0; i<=haystack.length()-len; i++){//here it should be "<=", not "<"
            if(haystack.substring(i, i+len).equals(needle)) return i;// it will not include the letter on position (i+len)
        }
        return -1;
    }
}
