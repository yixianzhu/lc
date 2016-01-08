//other people's solution
public class Solution {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++){
            row.add(0, 1);//add a 1 at the first place--modified
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));//change the number--modified
            allrows.add(new ArrayList<Integer>(row));//clone the row just modified
        }
        return allrows;
    }
}
