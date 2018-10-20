class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return findCombination(candidates, target, 0, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> findCombination(int[] candidates, int target, 
        int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            current = new ArrayList<>();
            return result;
        }
        if (target < 0) {
            return result;
        }
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            findCombination(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
        return result;
    }
}