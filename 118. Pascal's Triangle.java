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

//更好理解更正常的做法
/*
 * Pascal’s Triangle I,空间复杂度O(n²),时间复杂度O(n²)
 */
public static List<List<Integer>> generate1(int numRows) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    // 不合法的输入
    if (numRows <= 0)
        return result;
    List<Integer> pre = new ArrayList<Integer>();
    pre.add(1);
    result.add(pre);
    for (int i = 2; i <= numRows; i++) {
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(1); // 开头元素
        for (int j = 0; j < pre.size() - 1; j++) {
            cur.add(pre.get(j) + pre.get(j + 1)); // 中间位置
        }
        cur.add(1);// 末尾元素
        result.add(cur);
        pre = cur;//记得这步
    }
    return result;
}
