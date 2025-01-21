class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int times = nums.length / 3;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > times) {
                list.add(e.getKey());
            }
        }
        return list;
    }
}