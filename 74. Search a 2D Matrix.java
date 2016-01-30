//my wrong solution

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        if(row == 0 || column == 0) return false;
        int lowr = 0;
        int highr = row;
        while(lowr<=highr){
            if(target == matrix[(lowr+highr)/2][0]) return true;
            else if(target<matrix[(lowr+highr)/2][0]) highr = (lowr+highr)/2-1;
            else lowr = (lowr+highr)/2+1;
        }
        row = highr;
        int lowc = 0;
        int highc = column;
        while(lowc<=highc){
            if(target == matrix[row][(lowc+highc)/2]) return true;
            else if(target<matrix[(row)/2][lowc]) highc = (lowc+highc)/2-1;
            else lowc = (lowc+highc)/2+1;
        }
        return false;
    }
}




/**
 *  Do binary search in this "ordered" matrix
 */
public boolean searchMatrix(int[][] matrix, int target) {

    int row_num = matrix.length;
    int col_num = matrix[0].length;

    int begin = 0, end = row_num * col_num - 1;

    while(begin <= end){
        int mid = (begin + end) / 2;
        int mid_value = matrix[mid/col_num][mid%col_num];

        if( mid_value == target){
            return true;

        }else if(mid_value < target){
            //Should move a bit further, otherwise dead loop.
            begin = mid+1;
        }else{
            end = mid-1;
        }
    }

    return false;
}
