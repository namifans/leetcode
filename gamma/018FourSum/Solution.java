class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(4, nums, target, 0);
    }

    private List<List<Integer>> kSum(int k, int[] nums, int target, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 2) {
            twoSum(result, nums, target, index);
            return result;
        } else {
            for (int i = index; i < nums.length - k + 1 ; i++) {
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<List<Integer>> tmp = kSum(k - 1, nums, target - nums[i], i + 1);
                for (List<Integer> l : tmp) {
                    l.add(0, nums[i]);
                }
                result.addAll(tmp);
            }
        }
        return result;
    }

    private void twoSum(List<List<Integer>> result, int[] nums, int target, int index) {
        int end = nums.length - 1;
        while (index < end) {
            int sum = nums[index] + nums[end];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[index++]);
                list.add(nums[end--]);
                result.add(list);
                while (index < end && nums[index] == nums[index - 1]) {
                    index++;
                }
                while (index < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (sum < target) {
                index++;
            } else {
                end--;
            }
        }
    }
}