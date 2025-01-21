class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();
        combination(candidates, target, 0, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    public void combination(int[] can, int target, int pos, List<Integer> list, Set<List<Integer>> set) {
        if (target == 0) {
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < can.length; i++) {
            if (i > pos && can[i] == can[i - 1])
                continue;
            if (target - can[i] < 0)
                break; 
            list.add(can[i]);
            combination(can, target - can[i], i + 1, list, set);
            list.remove(list.size() - 1);
        }
    }
}