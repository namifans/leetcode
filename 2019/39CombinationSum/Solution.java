class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void findCombination(int[] candidates, int target, int index, 
        List<Integer> list, List<List<Integer>> result) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList(list));
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                findCombination(candidates, target - candidates[i], i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}