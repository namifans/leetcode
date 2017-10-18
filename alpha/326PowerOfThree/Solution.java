public class Solution {
	public boolean isPowerOfThree(int n) {
		// Cannot use natural log here because rounding issue
		double log3 = Math.log10(n) / Math.log10(3);
		return (log3 % 1) == 0;
	}
}