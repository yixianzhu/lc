/*
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/
//correct solution
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        int len = word.length();
        res.add(len==0 ? "" : String.valueOf(len));
        for(int i = 0 ; i < len ; i++)
            for(String right : generateAbbreviations(word.substring(i+1))){
                String leftNum = i > 0 ? String.valueOf(i) : "";
                res.add( leftNum + word.substring(i,i + 1) + right );
            }
        return res;
    }
}

//another correct solution
/*
The idea is: for every character, we can keep it or abbreviate it. 
To keep it, we add it to the current solution and carry on backtracking. 
To abbreviate it, we omit it in the current solution, but increment the count, which indicates how many characters have we abbreviated. 
When we reach the end or need to put a character in the current solution, and count is bigger than zero, we add the number into the solution.
*/
public List<String> generateAbbreviations(String word){
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);

        return ret;
    }

    private void backtrack(List<String> ret, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
            backtrack(ret, word, pos + 1, cur, count + 1);
            backtrack(ret, word, pos+1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }
