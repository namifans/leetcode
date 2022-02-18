class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>(); 
        findCombo(n, k, 1, new ArrayList<>(), res);
        return res;
    }
    
    private void findCombo(int n, int k, int pos, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
        }
        for (int i = pos; i <= n; i++) {
            current.add(i);
            findCombo(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}