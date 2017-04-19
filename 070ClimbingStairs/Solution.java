public class Solution {
	public int climbStairs(int n) {
		if (n <= 2)
			return n;	
		int s1 = 1;
		int s2 = 2;
		for (int i=2; i<n; i++) {
			int current = s1 + s2;
			s1 = s2;
			s2 = current;
		}
		return s2;
    }
}