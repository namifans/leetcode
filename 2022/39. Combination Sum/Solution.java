class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombination(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void findCombination(int[] candidates, 
                                int target, 
                                int pos,
                                List<Integer> current, 
                                List<List<Integer>> result
                               ) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            current.add(candidates[i]);
            findCombination(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }   
    }
}