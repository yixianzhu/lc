public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++){
            row.add(0,1);
            for(int j = 1; j < i; j++){//j<i也可以写成j<row.size()
                row.set(j, row.get(j)+row.get(j+1));
            }
        }
        return row;
    }
}
