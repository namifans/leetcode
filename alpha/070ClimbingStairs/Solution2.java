public class Solution2 {
    public int climbStairs(int n) {
        return climbStairs(n, 1, 2);
    }
    public int climbStairs(int n, int s1, int s2) {
        if (n == 1)
            return s1;
        if (n == 2)
            return s2;
        return climbStairs(n-1, s2, v+s1);
    }
}