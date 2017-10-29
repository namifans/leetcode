class Solution {
    public int[] twoSum(int[] numbers, int target) throws IllegalArgumentException{
        if (numbers == null || numbers.length == 0)
            throw new IllegalArgumentException("No two sum solution");
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("No two sum solution"); 
    }
}