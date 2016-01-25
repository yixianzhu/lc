/*
Basically it's a fibonacci. The problem seems to be a dynamic programming one. 

Base cases:
if n <= 0, then the number of ways should be zero. 
if n == 1, then there is only way to climb the stair. 
if n == 2, then there are two ways to climb the stairs.

The key intuition to solve the problem is that given a number of stairs n, 
if we know the number ways to get to the points [n-1] and [n-2] respectively, denoted as n1 and n2, 
then the total ways to get to the point [n] is n1 + n2. 
Because from the [n-1] point, we can take one single step to reach [n]. 
And from the [n-2] point, we could take two steps to get there. 
There is NO overlapping between these two solution sets, because we differ in the final step.

Now given the above intuition, one can construct an array where each node stores the solution for each number n. 
Or if we look at it closer, it is clear that this is basically a fibonacci number, 
with the starting numbers as 1 and 2, instead of 1 and 1.
*/

//my wrong solution
public class Solution {
    public int climbStairs(int n) {
        int temp = n/2;
        if(n == 0 || n == 1 || n == 2){return n;}
        // if(n%2==1)
        return (int)Math.pow(2, temp)+1;
        // else return (int)Math.pow(2, temp);
    }
}

//correct solution
public class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2){return n;}
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for(int i = 2; i < n; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n-1];
    }
}
