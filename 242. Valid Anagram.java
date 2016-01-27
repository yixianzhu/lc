/*
1. two string given have same length?
2. upper case or lower case?
3. ignore space?
*/
//my correct solution
import java.util.Hashtable;

public class Solution {
    public boolean isAnagram(String s, String t) {
        Hashtable<Character, Integer> letters = new Hashtable<Character, Integer>();
        
        if(s.length()==0) return true;
        
        for(int i=0; i<s.length(); i++){
            if(letters.containsKey(s.charAt(i))){
                letters.put(s.charAt(i), letters.get(s.charAt(i))+1);
            }else{
                letters.put(s.charAt(i), 1);
            }
        }
        
        for(int j=0; j<t.length(); j++){
            if(letters.containsKey(t.charAt(j))){
                letters.put(t.charAt(j), letters.get(t.charAt(j))-1);
                if(letters.get(t.charAt(j)) == 0){
                    letters.remove(t.charAt(j));
                }
            }else{
                return false;
            }
        }
        
        if(letters.size() == 0){
            return true;
        }else{
            return false;
        }

    }
}

//other correct (more concise) solution
public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false; 
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++)  map[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            if(--map[t.charAt(i) - 'a'] < 0)
                return false;
        return true;
  }
