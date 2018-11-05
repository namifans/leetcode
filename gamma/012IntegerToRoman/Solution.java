class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "LX", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (num >= nums[i]) {
                int n = num / nums[i];
                while (n > 0) {
                    res.append(romans[i]);
                    n--;
                }
                num %= nums[i];
            }
        }
        return res.toString();
    }
}