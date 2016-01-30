//my wrong solution
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int num_row = matrix.length;
        int num_col = matrix[0].length;
        int rowl = 0;
        int coll = 0;
        int rowh = num_row-1;
        int colh = num_col-1;
        while(rowh-rowl>1){
            int midr = (rowl+rowh)/2;
            
            if(matrix[midr][0] == target) {
                return true;
            }else if(matrix[midr][0] < target){
                rowl = midr;
            }else{
                rowl = midr;
            }
        }
        int row = 0;
        if(target<matrix[rowl+1][0]) row = rowl;
        else row = rowl+1;
        
        while(coll<=colh){
            int midc = (colh+coll)/2;
            
            if(matrix[row][midc] == target){
                return true;
            }else if(matrix[row][midc] < target){
                coll = midc+1;
            }else{
                colh = midc-1;
            }
        }
        return false;
    }
}

//correct solution
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
