//my correct solution
//Hashtable more general than Map or other things... and it's 't' not 'T'...
//And pls remember to import!
import java.util.Hashtable;//remember this!!
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Hashtable<Character, Character> letters = new Hashtable<Character, Character>();

        for(int i=0; i<s.length(); i++){
            if(letters.containsKey(s.charAt(i))){
                if(!letters.get(s.charAt(i)).equals(t.charAt(i)))
                return false;
            }else if(letters.contains(t.charAt(i))) {
                return false;
            }else{
                letters.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
