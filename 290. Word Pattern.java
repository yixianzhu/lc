/*
public V put(K key, V value) ==> The return type is V
*/
//my wrong solution
import java.util.Hashtable;//You have to import!!
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Hashtable<Character, String> table = new Hashtable<Character, String>();
        //The key is Character, not String
        int j=0;
        StringBuilder wordst = new StringBuilder();
        String word = "";
        for(int i=0; i<pattern.length()-1; i++){
            while(str.charAt(j) != " "){
                wordst.append(str.charAt(j));
                j++;
            }
            //Method charAt(index) will give you return type of Character
            //so better use method str.split()
            word = wordst.toString();
            
            if(!table.containsKey(pattern.charAt(i))){
                table.put(pattern.charAt(i), word);
            }else{
                if(word == table.get(pattern.charAt(i))) return false;
            }
        }
        return true;
    }
}


//correct solution using hashtable
import java.util.Hashtable;
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");//remember this
        int len = pattern.length();
        if(arr.length != len){//general check
            return false;
        }
        Hashtable<Character, String> table = new Hashtable<Character, String>();//type of key is Character
        for( int i = 0; i < len; i++){
            char c = pattern.charAt(i);
            if( table.containsKey(c) && !table.get(c).equals(arr[i])){//hashtable has the key, but have different values
                return false;
            }
            else if( !table.containsKey(c) && table.contains(arr[i])){//value exists, but has different key from the hashtable
                return false;
            }
            else{
                table.put(c, arr[i]);
            }
        }
        return true;
    }
}


////correct solution using Map
//It goes through the pattern letters and words in parallel and compares the indexes where they last appeared.
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i){
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
            //return: the previous value associated with key, or null if there was no mapping for key
                return false;
        }
            
            
        return true;
    }
}
