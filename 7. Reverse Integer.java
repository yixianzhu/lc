//my solution
public class Solution {
    public int reverse(int x) {
        long tempx = x;
        long xreverse = 0;
        int sign = 1;
        if (tempx<0) {
            sign = -1;
            tempx = tempx*(-1);
        }
        while (tempx>0){
            xreverse = xreverse*10 + tempx%10;
            tempx /= 10;
        }
        if (xreverse>Integer.MAX_VALUE || xreverse<Integer.MIN_VALUE){
            return 0;
        }
        else return (int)xreverse*sign;
    }
}
