/*
final number value = x
list length = n
sum of list = S
min = min
moves = m

1. S + m * (n-1) = x * n
2. x = min + m

so m = sum - min * n

*/
public class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
        	sum += nums[i];
        	if (nums[i] < min)
        		min = nums[i];
        }
        return sum - nums.length * min;
    }
} 