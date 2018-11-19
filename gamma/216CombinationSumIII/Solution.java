class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return helper(k, n, 1, new ArrayList<>(), new ArrayList<>());
        
    }

    private List<List<Integer>> helper(int k, int n, int index, 
        List<Integer> current, List<List<Integer>> result) {
        if (n == 0 && current.size() == k) {
            result.add(new ArrayList<>(current));
            return result;
        }
        for (int i = index; i <= 9; i++) {
            current.add(i);
            helper(k, n - i, i + 1, current, result);
            current.remove(current.size() - 1);
        }
        return result;
    }
}