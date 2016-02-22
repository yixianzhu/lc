//correct solution
public class Solution{
	public List<String> letterCombinations(String digits){
		LinkedList<String> result = new LinkedList<String>();
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		//要从0开始
		result.add("");
		for(int i=0; i<digits.length();i++){
			int x = Charater.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){//要有这层判断，所以不会把处理过后的string又处理一遍
				String t = result.remove();//存pop出来的string
				for(char s:mapping[x].toCharArray())
					result.add(t+s);
			}
		}
		return result;
	}

}
