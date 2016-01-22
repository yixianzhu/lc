/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

//start + (end-start) / 2 can avoid possible overflow
//for example start = 2^20 and end = 2^30.

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while(low<high){
            int mid = low+(high-low)/2;
            if(!isBadVersion(mid)){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return high;
    }
}

//concise correct solution
public int firstBadVersion(int n) {
    int start = 1, end = n;
    while (start < end) {
        int mid = start + (end-start) / 2;
        if (!isBadVersion(mid)) start = mid + 1;
        else end = mid;            
    }        
    return start;
}
