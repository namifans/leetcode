class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        calculate(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    public void calculate(int[] candidates, 
                          int target, 
                          int pos,
                          List<List<Integer>> res,
                          List<Integer> current) {
        
        if (pos >= candidates.length || target < 0) {
            return; 
        }
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            current.add(candidates[i]);
            calculate(candidates, target - candidates[i], i, res, current);
            current.remove(current.size() - 1);
        }
    }
}