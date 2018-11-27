class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Queue<Integer> window = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            window.add(nums[i]); 
            if (window.size() >= k) {
                res[count++] = window.peek();
                window.remove(nums[i - k + 1]);
            }
        }
        return res;
    }
}