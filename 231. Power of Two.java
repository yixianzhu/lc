//correct solution
/*if n is power of two, n & n - 1 will be 0.
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return ((n & n - 1) == 0 && n > 0); 
    }
}
