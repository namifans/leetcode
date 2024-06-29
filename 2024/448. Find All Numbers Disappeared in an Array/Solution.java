class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] li = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            li[nums[i] - 1] = -1; 
        }
        for (int i = 0; i < li.length; i++) {
            if (li[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}