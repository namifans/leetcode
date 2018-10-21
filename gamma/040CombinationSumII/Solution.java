class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return findCombination(candidates, target, 0, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> findCombination(int[] candidates, int target, int index, 
        List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList(current));
            return result;
        }
        if (target < 0) {
            return result;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            current.add(candidates[i]);
            findCombination(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
        return result;
    }
}