class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombination(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void findCombination(int[] candidates, int target, int index, 
        List<Integer> current, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (index == candidates.length || target < 0)
            return;
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            findCombination(candidates, target - candidates[i], i, current, res);
            current.remove(current.size() - 1);
        }
    }
}