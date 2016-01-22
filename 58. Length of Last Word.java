//my solution
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        
        int len = words.length;
        //the tricky part is when input is "", the length is 1, whereas when input is " ", the length is 0
        //so we have to determine whehter its len is 0
        if(len == 0) return 0;
        int j=len-1;
        while(j>0 && words[j].length()<1){
            j--;    
        }
        return words[j].length();
    }
}

//concise correct solution
public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
}
//this method use trim to easy the all-space problem
