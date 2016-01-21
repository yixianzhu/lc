//my wrong solution -- seems not suitable to use hashtable
import java.util.Hashtable;

public class Solution {
    public String getHint(String secret, String guess) {
        Hashtable<Character, Character> letters = new Hashtable<Character, Character>();
        int bull = 0;
        int cow = 0;
        
        for(int i=0; i<secret.length(); i++){
            if(!letters.containsKey(secret.charAt(i))){
                letters.put(i,secret.charAt(i));
            }
        }
        for(int j=0; j<guess.length(); j++){
            if(secret.get(j) == guess.get(j)){
                bull++;
                secret.remove(j);
                guess.remove(j);
            }else if(letters.containsValue(guess.charAt(j))){
                cow++;
                
            }
        }
        return Integer.toString(bull)+"A"+Integer.toString(cow)+"B";
    }
}


//the correct solution
public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) bulls++;
        else {
            if (numbers[s] < 0) cows++;
            if (numbers[g] > 0) cows++;
            numbers[s] ++;
            numbers[g] --;
        }
    }
    return bulls + "A" + cows + "B";
}
